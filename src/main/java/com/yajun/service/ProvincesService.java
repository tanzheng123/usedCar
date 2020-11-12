package com.yajun.service;

import com.yajun.dao.ProvincesDao;
import com.yajun.domain.Provinces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvincesService {

    @Autowired
    private ProvincesDao provincesDao;

    public List<Provinces> getAll() {
        return provincesDao.getAll();
    }

    public List<Provinces> getByStatus(Integer status) {
        return provincesDao.getByStatus(status);
    }

    public Provinces getById(Long id) {
        return provincesDao.getById(id);
    }
}
