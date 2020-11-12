package com.yajun.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.CarInfoDao;
import com.yajun.domain.CarInfo;
import com.yajun.domain.CarStyle;
import com.yajun.vo.CarInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarInfoService {

    @Autowired
    CarInfoDao carInfoDao;

    public List<CarInfoVo> getByStatus(int status, Long userId){
       return carInfoDao.getByStatus(status, userId);
    }

    public PageInfo<CarInfoVo> pageByStatus(int status, int pageIndex, int pageSize, Long userId){
        PageHelper.startPage(pageIndex, pageSize);
        List<CarInfoVo> carInfoVoList = carInfoDao.getByStatus(status, userId);
        PageInfo<CarInfoVo> pageInfo = new PageInfo<>(carInfoVoList);
        return pageInfo;
    }

    public CarInfoVo findDetailById(long carInfoId, Long userId){
        return carInfoDao.findDetailById(carInfoId, userId);
    }

    public long insertCarInfo(CarInfo carInfo){
        return carInfoDao.insertCarInfo(carInfo);
    }

    public PageInfo<CarInfoVo> pageByUserId(int pageIndex, int pageSize, Long userId) {
        PageHelper.startPage(pageIndex, pageSize);
        List<CarInfoVo> carInfoVoList = carInfoDao.getByUserId(userId);
        PageInfo<CarInfoVo> pageInfo = new PageInfo<>(carInfoVoList);
        return pageInfo;
    }
}
