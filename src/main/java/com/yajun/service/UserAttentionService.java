package com.yajun.service;

import com.yajun.dao.UserAttentionDao;
import com.yajun.domain.UserAttention;
import com.yajun.vo.UserAttentionCarInfoVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserAttentionService {

    @Autowired
    UserAttentionDao userAttentionDao;

    public Long insertUserAttention(UserAttention userAttention){
        return userAttentionDao.insertUserAttention(userAttention);
    }

    public void updateStatus(Long userId, Long carInfoId, Integer status, Date updateTime){
        userAttentionDao.updateStatus(userId,carInfoId,status,updateTime);
    }

    public UserAttention selectByUserIdAndCarInfoId(Long userId, Long carInfoId){
        return userAttentionDao.selectByUserIdAndCarInfoId(userId, carInfoId);
    }

    public List<UserAttentionCarInfoVo> selectByUserId(Long userId, Integer status){
        return userAttentionDao.selectByUserIdAndStatus(userId, status);
    }
}
