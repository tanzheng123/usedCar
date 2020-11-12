package com.yajun.vo;

import com.yajun.domain.Users;

import java.util.Date;

public class RelationshipUserVo extends Users {

    private long relationshipUserId;

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

    public long getRelationshipUserId() {
        return relationshipUserId;
    }

    public void setRelationshipUserId(long relationshipUserId) {
        this.relationshipUserId = relationshipUserId;
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
