package com.yajun.dao;

import com.yajun.domain.Provinces;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvincesDao {

    @Select({"SELECT * FROM provinces"})
    public List<Provinces> getAll();

    @Select({"SELECT * FROM provinces WHERE `status` = #{status}"})
    public List<Provinces> getByStatus(Integer status);

    @Select({"SELECT * FROM provinces WHERE id = #{id}"})
    public Provinces getById(Long id);
}
