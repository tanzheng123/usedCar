package com.yajun.service;

import com.yajun.dao.CarStyleDao;
import com.yajun.domain.CarMake;
import com.yajun.domain.CarStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStyleService {

    @Autowired
    CarStyleDao carStyleDao;

    public List<CarStyle> getByPurposeId(long stylePurposeId){
        return carStyleDao.getByPurposeId(stylePurposeId);
    }

    public CarStyle getById(long id){
        return carStyleDao.getById(id);
    }

    public Long insertCarStyle(CarStyle carStyle) {
        return carStyleDao.insertCarStyle(carStyle);
    }

    public List<Long> getByMakeIdForPurposeId(long makeId){
        return carStyleDao.getByMakeIdForPurposeId(makeId);
    }

    public List<CarStyle> getByMakeId(long makeId){
        return carStyleDao.getByMakeId(makeId);
    }
}
