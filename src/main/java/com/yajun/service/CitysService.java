package com.yajun.service;

import com.yajun.dao.CitysDao;
import com.yajun.domain.Citys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitysService {

    @Autowired
    private CitysDao citysDao;

    public List<Citys> getAll() {
        return citysDao.getAll();
    }

    public Citys getById(Long id) {
        return citysDao.getById(id);
    }

    public List<Citys> getByProvinceId(Long provinceId) {
        return citysDao.getByProvinceId(provinceId);
    }
}
