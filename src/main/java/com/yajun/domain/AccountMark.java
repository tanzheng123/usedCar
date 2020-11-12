package com.yajun.domain;


import java.util.Date;

/**
 * 账号标记
 */
public class AccountMark {

  private long id;

  /**
   * 时间
   */
  private Date time;

  /**
   * 微信openId
   */
  private String openId;

  /**
   * 用户ID
   */
  private long userId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }


  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
