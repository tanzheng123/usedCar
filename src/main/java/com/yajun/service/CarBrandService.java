package com.yajun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.CarBrandDao;
import com.yajun.dao.CarInfoDao;
import com.yajun.domain.CarBrand;
import com.yajun.domain.CarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandService {

    @Autowired
    CarBrandDao carBrandDao;

    public CarBrand getByBrandKey(String brandKey){
       return carBrandDao.getByBrandKey(brandKey);
    }

    public List<CarBrand> getAll(){
        return carBrandDao.getAll();
    }
}
