package com.yajun.vo;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

public class OrdersVo extends CarInfoVo {

    private Long orderId;

    private Integer orderStatus;

    /**
     * 加密ID
     */
    private String sign;

    public String getSign() {
        return EncryptUtil.addSign(this.orderId, Constants.ORDERS_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
