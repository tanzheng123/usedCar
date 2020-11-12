package com.yajun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.CarInfoDao;
import com.yajun.dao.CarPurposeDao;
import com.yajun.domain.CarInfo;
import com.yajun.domain.CarPurpose;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPurposeService {

    @Autowired
    CarPurposeDao carPurposeDao;

    public List<CarPurpose> getByMakeId(long makeId){
        return carPurposeDao.getByMakeId(makeId);
    }

    public CarPurpose getById(long id){
        return carPurposeDao.getById(id);
    }

    public Long insertCarPurpose(CarPurpose carPurpose) {
        return carPurposeDao.insertCarPurpose(carPurpose);
    }

    public List<CarPurpose> getByPurposeIdList(List<Long> purposeIdList){
        return carPurposeDao.getByPurposeIdList(purposeIdList);
    }
}
