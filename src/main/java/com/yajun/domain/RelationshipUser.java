package com.yajun.domain;


import java.util.Date;

/**
 * 用户关系
 */
public class RelationshipUser {

  private long id;

  /**
   * 创建时间
   */
  private Date time;

  /**
   * 用户id(被推广人)
   */
  private long userId;

  /**
   * 推广人id
   */
  private long spreaderId;


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


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getSpreaderId() {
    return spreaderId;
  }

  public void setSpreaderId(long spreaderId) {
    this.spreaderId = spreaderId;
  }

}
