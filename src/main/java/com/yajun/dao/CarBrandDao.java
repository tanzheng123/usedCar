package com.yajun.dao;

import com.yajun.domain.CarBrand;
import com.yajun.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarBrandDao {

    @Select("select * from car_brand where brand_key = #{brandKey}")
    public CarBrand getByBrandKey(@Param("brandKey") String brandKey);

    @Select("select * from car_brand")
    public List<CarBrand> getAll();
}
