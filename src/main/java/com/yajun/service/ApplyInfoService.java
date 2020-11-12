package com.yajun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.ApplyInfoDao;
import com.yajun.domain.ApplyInfo;
import com.yajun.vo.ApplyInfoVo;
import com.yajun.vo.CarInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyInfoService {

    @Autowired
    ApplyInfoDao applyInfoDao;

    public ApplyInfo getByApplyInfoId(long applyInfoId){
        return applyInfoDao.getByApplyInfoId(applyInfoId);
    }

    public PageInfo<ApplyInfoVo> pageByUserId(long userId, int pageIndex, int pageSize){
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyInfoVo> applyInfoList = applyInfoDao.getByUserId(userId);
        PageInfo<ApplyInfoVo> pageInfo = new PageInfo<>(applyInfoList);
        return pageInfo;
    }

    public PageInfo<ApplyInfoVo> pageAll(int pageIndex, int pageSize){
        PageHelper.startPage(pageIndex, pageSize);
        List<ApplyInfoVo> applyInfoVoList = applyInfoDao.getAll();
        PageInfo<ApplyInfoVo> pageInfo = new PageInfo<>(applyInfoVoList);
        return pageInfo;
    }

    public Long insertApplyInfo(ApplyInfo applyInfo){
        return applyInfoDao.insertApplyInfo(applyInfo);
    }
}
