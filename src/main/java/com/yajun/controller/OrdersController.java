package com.yajun.controller;

import com.github.pagehelper.PageInfo;
import com.yajun.access.AccessLimit;
import com.yajun.config.Constants;
import com.yajun.domain.Orders;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.CarInfoService;
import com.yajun.service.OrdersService;
import com.yajun.utils.EncryptUtil;
import com.yajun.vo.CarInfoVo;
import com.yajun.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/order/")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    CarInfoService carInfoService;

    @RequestMapping(value = "/appoint")
    @ResponseBody
    @AccessLimit
    public Result toDetail(HttpServletRequest request, Users users, String carInfoSign){
        Result result = EncryptUtil.decodeSign(carInfoSign, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long carInfoId = Long.parseLong(result.getData().toString());

        CarInfoVo carInfoVo = carInfoService.findDetailById(carInfoId, null);

        if (carInfoVo == null){
            return Result.error(CodeMsg.PARAM_EMPTY);
        }
        Orders orders = new Orders();
        orders.setCarInfoId(carInfoId);
        orders.setAmount(new BigDecimal(2000));
        orders.setAppointTime(new Date());
        orders.setOrderNo(Orders.getUniqueOrder());
        orders.setStatus(Orders.OrdersStatus.APPOINT.code);
        orders.setUserId(users.getId());
        ordersService.insetOrders(orders);

        return Result.success(orders);
    }

    @RequestMapping(value = "/myOrder")
    @ResponseBody
    @AccessLimit
    public Result toDetail(@RequestParam(value = "pageIndex", required = false, defaultValue = "1")int pageIndex,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,Users users, Integer status, HttpServletRequest request){
        List<Integer> statusList = new ArrayList<>();
        if(status == null || status == 1){
            statusList.add(Orders.OrdersStatus.APPOINT.code);
            statusList.add(Orders.OrdersStatus.APPOINT_CANCEL.code);
            statusList.add(Orders.OrdersStatus.IN_PAYMENT.code);
        }else if(status == 2){
            statusList.add(Orders.OrdersStatus.PAY_SUCCESS.code);
            statusList.add(Orders.OrdersStatus.REFUND_APPLICATION.code);
            statusList.add(Orders.OrdersStatus.REFUND.code);
            statusList.add(Orders.OrdersStatus.REFUND_SUCCESS.code);
        }
        PageInfo<OrdersVo> ordersVos = ordersService.pageOrdersByStatusList(pageIndex, pageSize, users.getId(), statusList);
        return Result.success(ordersVos);
    }
}
