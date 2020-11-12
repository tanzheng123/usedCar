package com.yajun.dao;

import com.yajun.domain.Citys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CitysDao {

    @Select({"SELECT * FROM citys"})
    public List<Citys> getAll();

    @Select({"SELECT * FROM citys WHERE id = #{id}"})
    public Citys getById(Long id);

    @Select({"SELECT * FROM citys WHERE province_id = #{provinceId}"})
    public List<Citys> getByProvinceId(Long provinceId);
}
