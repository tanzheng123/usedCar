package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;
import com.yajun.utils.UUIDUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Orders {

    /**
     * 主键
     */
    private Long id;

    /**
     * 汽车信息ID
     */
    private Long carInfoId;

    /**
     * 预约时间
     */
    private Date appointTime;

    /**
     * 预约人
     */
    private Long userId;

    /**
     * 支付金额
     */
    private BigDecimal amount;

    /**
     * 状态：0已预约待支付，1取消预约，2：支付中，3支付成功，4：退款申请，5：退款中，6退款成功
     */
    private Integer status;

    /**
     * 支付订单号
     */
    private String orderNo;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 退款时间
     */
    private Date refundTime;

    /**
     * 加密ID
     */
    private String sign;

    public String getSign() {
        return EncryptUtil.addSign(this.id, Constants.ORDERS_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(Long carInfoId) {
        this.carInfoId = carInfoId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 订单状态
     * @description
     */
    public enum OrdersStatus {

        APPOINT(0, "待支付"),

        APPOINT_CANCEL(1,"预约取消"),

        IN_PAYMENT(2,"支付中"),

        PAY_SUCCESS(3,"支付成功"),

        REFUND_APPLICATION(4,"退款申请"),

        REFUND(5,"退款中"),

        REFUND_SUCCESS(6,"退款成功"),

        ;

        /** 状态 */
        public int code;

        /** 描述 */
        public String value;

        private OrdersStatus(int code, String value){
            this.code = code;
            this.value = value;
        }

        public static OrdersStatus getEnum(int code){
            OrdersStatus[] ordersStatuss = OrdersStatus.values();
            for(OrdersStatus ordersStatus : ordersStatuss){
                if(ordersStatus.code == code){

                    return ordersStatus;
                }
            }
            return null;
        }
    }

    /**
     * 获得唯一订单号
     */
    public static String getUniqueOrder() {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMddHHmmss");
        String format2 = format.format(new Date());
        int hashCodeV = UUIDUtil.uuid().toString().hashCode();
        if(hashCodeV < 0) {
            //有可能是负数
            hashCodeV = - hashCodeV;
        }
        return "pk"+format2+String.format("%012d", hashCodeV);
    }

    public static void main(String[] args) {
        String uniqueOrder = getUniqueOrder();
        System.out.println(uniqueOrder);
        System.out.println(uniqueOrder.length());
    }
}
