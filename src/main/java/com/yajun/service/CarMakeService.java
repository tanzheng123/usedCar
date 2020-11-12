package com.yajun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.CarInfoDao;
import com.yajun.dao.CarMakeDao;
import com.yajun.domain.CarInfo;
import com.yajun.domain.CarMake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarMakeService {

    @Autowired
    CarMakeDao carMakeDao;

    public List<CarMake> getByBrandKey(String brandKey){
        return carMakeDao.getByBrandKey(brandKey);
    }

    public List<CarMake> getByBrandId(long brandId){
        return carMakeDao.getByBrandId(brandId);
    }

    public Long insertCarMake(CarMake carMake){
        return carMakeDao.insertCarMake(carMake);
    }
}
