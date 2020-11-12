package com.yajun.service;

import com.yajun.config.PayConstant;
import com.yajun.config.WxConfig;
import com.yajun.domain.Orders;
import com.yajun.domain.WxpayUnified;
import com.yajun.utils.HttpClientUtil;
import com.yajun.utils.PayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class PaymentService {

    private static Logger LOGGER = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    OrdersService ordersService;

    public Map<String, String> xcxPayment(String orderNum, BigDecimal payAmount, String openId) throws Exception {
        LOGGER.info("【小程序支付】 统一下单开始, 订单编号="+orderNum);
        SortedMap<String, String> resultMap = new TreeMap<String, String>();

        //添加或更新支付记录(参数跟进自己业务需求添加)
        int flag = this.addOrUpdatePaymentRecord(orderNum, payAmount);
        if(flag < 0){
            resultMap.put("returnCode", "FAIL");
            resultMap.put("returnMsg", "此订单已支付！");
            LOGGER.info("【小程序支付】 此订单已支付！");
        }else if(flag == 0){
            resultMap.put("returnCode", "FAIL");
            resultMap.put("returnMsg", "支付记录生成或更新失败！");
            LOGGER.info("【小程序支付】 支付记录生成或更新失败！");
        }else {
            WxConfig wxConfig = new WxConfig();
            Map<String,String> resMap = this.xcxUnifieldOrder(orderNum, WxConfig.TRADE_TYPE_JSAPI, payAmount,openId);
            if(PayConstant.SUCCESS.equals(resMap.get("return_code")) && PayConstant.SUCCESS.equals(resMap.get("result_code"))){
                resultMap.put("appId", wxConfig.getAppId());
                resultMap.put("timeStamp", PayUtil.getCurrentTimeStamp());
                resultMap.put("nonceStr", PayUtil.makeUUID(32));
                resultMap.put("package", "prepay_id="+resMap.get("prepay_id"));
                resultMap.put("signType", "MD5");
                String sign = PayUtil.createSign(resultMap,wxConfig.getKey());
                resultMap.put("sign", sign);
                resultMap.put("returnCode", "SUCCESS");
                resultMap.put("returnMsg", "OK");
                LOGGER.info("【小程序支付】统一下单成功，返回参数:"+resultMap);
            }else{
                resultMap.put("returnCode", resMap.get("return_code"));
                resultMap.put("returnMsg", resMap.get("return_msg"));
                LOGGER.info("【小程序支付】统一下单失败，失败原因:"+resMap.get("return_msg"));
            }
        }
        return resultMap;
    }

    /**
     * 小程序支付统一下单
     */
    private Map<String,String> xcxUnifieldOrder(String orderNum,String tradeType, BigDecimal payAmount,String openid) throws Exception{
        //封装参数
        WxConfig wxConfig = new WxConfig();

        String nonce_str = PayUtil.makeUUID(32);
        SortedMap<String,String> paramMap = new TreeMap<String,String>();
        paramMap.put("appid", wxConfig.getAppId());
        paramMap.put("mch_id", wxConfig.getMchid());
        paramMap.put("nonce_str", nonce_str);
        paramMap.put("body", WxConfig.PLATFORM_COMPANY_NAME);
        paramMap.put("out_trade_no", orderNum);
        paramMap.put("total_fee", PayUtil.moneyToIntegerStr(payAmount));
        paramMap.put("spbill_create_ip", PayUtil.getLocalIp());
        paramMap.put("notify_url", this.getNotifyUrl());
        paramMap.put("trade_type", tradeType);
        paramMap.put("openid",openid);
        paramMap.put("sign", PayUtil.createSign(paramMap,wxConfig.getKey()));
        //转换为xml
        String xmlData = PayUtil.mapToXml(paramMap);
        //请求微信后台，获取预支付ID
        String resXml = HttpClientUtil.doPostXml(WxConfig.WX_PAY_UNIFIED_ORDER, xmlData);
        LOGGER.info("【小程序支付】 统一下单响应：\n"+resXml);
        return PayUtil.xmlStrToMap(resXml);
    }

    private String getNotifyUrl(){
        WxConfig wxConfig = new WxConfig();
        //服务域名
        return wxConfig.getProServerDomain() + "/payment/xcxNotify";
    }

    /**
     * 更新支付记录
     */
    public int addOrUpdatePaymentRecord(String orderNo, BigDecimal payAmount) throws Exception{
        //写自己的添加或更新支付记录的业务代码
        int i = ordersService.updateStatusByOrderNo(orderNo, Orders.OrdersStatus.IN_PAYMENT.code);
        return i;
    }

    public int xcxNotify(Map<String,Object> map) throws Exception{
        int flag = 0;
        //支付订单编号
        String orderNo = (String)map.get("out_trade_no");
        //检验是否需要再次回调刷新数据
        //TODO 微信后台回调，刷新订单支付状态等相关业务

        return flag;
    }

}
