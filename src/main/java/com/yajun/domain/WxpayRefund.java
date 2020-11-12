package com.yajun.domain;


import java.math.BigDecimal;
import java.util.Date;

public class WxpayRefund {

  private long id;
  private String wxpayUnifiedId;
  private String outRefundNo;
  private BigDecimal totalFee;
  private BigDecimal refundFee;
  private String refundFeeType;
  private String opUserId;
  private String refundAccount;
  private String refundDesc;
  private String notifyUrl;
  private long status;
  private long deleted;
  private Date createTime;
  private Date updateTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getWxpayUnifiedId() {
    return wxpayUnifiedId;
  }

  public void setWxpayUnifiedId(String wxpayUnifiedId) {
    this.wxpayUnifiedId = wxpayUnifiedId;
  }


  public String getOutRefundNo() {
    return outRefundNo;
  }

  public void setOutRefundNo(String outRefundNo) {
    this.outRefundNo = outRefundNo;
  }


  public BigDecimal getTotalFee() {
    return totalFee;
  }

  public void setTotalFee(BigDecimal totalFee) {
    this.totalFee = totalFee;
  }


  public BigDecimal getRefundFee() {
    return refundFee;
  }

  public void setRefundFee(BigDecimal refundFee) {
    this.refundFee = refundFee;
  }


  public String getRefundFeeType() {
    return refundFeeType;
  }

  public void setRefundFeeType(String refundFeeType) {
    this.refundFeeType = refundFeeType;
  }


  public String getOpUserId() {
    return opUserId;
  }

  public void setOpUserId(String opUserId) {
    this.opUserId = opUserId;
  }


  public String getRefundAccount() {
    return refundAccount;
  }

  public void setRefundAccount(String refundAccount) {
    this.refundAccount = refundAccount;
  }


  public String getRefundDesc() {
    return refundDesc;
  }

  public void setRefundDesc(String refundDesc) {
    this.refundDesc = refundDesc;
  }


  public String getNotifyUrl() {
    return notifyUrl;
  }

  public void setNotifyUrl(String notifyUrl) {
    this.notifyUrl = notifyUrl;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public long getDeleted() {
    return deleted;
  }

  public void setDeleted(long deleted) {
    this.deleted = deleted;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

}
