package com.yajun.dao;

import com.yajun.domain.CarMake;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMakeDao {

    @Select("select * from car_make where brand_key = #{brandKey}")
    public List<CarMake> getByBrandKey(@Param("brandKey") String brandKey);

    @Select("select * from car_make where brand_id = #{brandId}")
    public List<CarMake> getByBrandId(@Param("brandId") long brandId);

    @Insert({"INSERT INTO car_make (brand_id, make_name, model_id) VALUES (#{brandId}, #{makeName}, #{modelId})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long insertCarMake(CarMake carMake);
}
