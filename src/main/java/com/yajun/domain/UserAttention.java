package com.yajun.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户关注信息表
 */
public class UserAttention implements Serializable {

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 汽车ID
     */
    private Long carInfoId;

    /**
     * 状态：0：关注， 1:取消关注
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarInfoId() {
        return carInfoId;
    }

    public void setCarInfoId(Long carInfoId) {
        this.carInfoId = carInfoId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
