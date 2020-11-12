package com.yajun.controller;

import com.alibaba.fastjson.JSONObject;
import com.yajun.access.AccessLimit;
import com.yajun.config.Constants;
import com.yajun.domain.Orders;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.OrdersService;
import com.yajun.service.PaymentService;
import com.yajun.utils.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payment/")
public class PaymentController {

    private static Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrdersService ordersService;

    /**
     * 统一下单入口
     *
     * @param request
     * @throws Exception
     */

    @RequestMapping(value="toPay", method= RequestMethod.POST, produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    @AccessLimit
    public Result toPay(HttpServletRequest request,String orderSign, BigDecimal realAmount, Users user) throws Exception {

        Result result = EncryptUtil.decodeSign(orderSign, Constants.ORDERS_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long orderId = Long.parseLong(result.getData().toString());
        Orders orders = ordersService.selectOrdersById(orderId);
        if (null == orders){
            return Result.error(CodeMsg.ORDERS_EMPTY);
        }

        if (orders.getStatus() != Orders.OrdersStatus.APPOINT.code){
            return Result.error(CodeMsg.ORDERS_NO_PAY_STATUS);
        }

        String openId = user.getOpenId();

        logger.info("【小程序支付服务】请求订单编号:["+orders.getOrderNo()+"]");
        Map<String, String> resMap = paymentService.xcxPayment(orders.getOrderNo(),orders.getAmount(), openId);
        if("SUCCESS".equals(resMap.get("returnCode")) && "OK".equals(resMap.get("returnMsg"))){
                //统一下单成功
                resMap.remove("returnCode");
                resMap.remove("returnMsg");
                logger.info("【小程序支付服务】支付下单成功！");
                return Result.success(resMap);
            }else{
                logger.info("【小程序支付服务】支付下单失败！原因:"+resMap.get("returnMsg"));
                return Result.error(CodeMsg.BIND_ERROR.fillArgs(resMap.get("returnMsg")));
            }
    }

    /**
     * <p>回调Api</p>
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="xcxNotify")
    public void xcxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        InputStream inputStream =  request.getInputStream();
        //获取请求输入流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        outputStream.close();
        inputStream.close();
        Map<String,Object> map = getMapFromXML(new String(outputStream.toByteArray(),"utf-8"));
        logger.info("【小程序支付回调】 回调数据： \n"+map);
        String resXml = "";
        String returnCode = (String) map.get("return_code");
        if ("SUCCESS".equalsIgnoreCase(returnCode)) {
            String returnmsg = (String) map.get("result_code");
            if("SUCCESS".equals(returnmsg)){
                //更新数据
                int result = paymentService.xcxNotify(map);
                if(result > 0){
                    //支付成功
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>"+"</xml>";
                }
            }else{
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报文为空]></return_msg>" + "</xml>";
                logger.info("支付失败:"+resXml);
            }
        }else{
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]></return_msg>" + "</xml>";
            logger.info("【订单支付失败】");
        }

        logger.info("【小程序支付回调响应】 响应内容：\n"+resXml);
        response.getWriter().print(resXml);
    }

    public static Map<String, Object> getMapFromXML(String responseString) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            SAXReader reader = new SAXReader();
            Document doc;
            doc = reader.read(new ByteArrayInputStream(responseString.getBytes("UTF-8")));
//            doc = reader.read(responseString);
            Element root = doc.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list) {
                map.put(element.getName(), element.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

}
