package com.yajun.dao;

import com.yajun.domain.CarMake;
import com.yajun.domain.CarPurpose;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarPurposeDao {

    @Select("select * from car_purpose where make_id = #{makeId}")
    public List<CarPurpose> getByMakeId(@Param("makeId") long makeId);

    @Select("select * from car_purpose where id = #{id}")
    public CarPurpose getById(@Param("id") long id);


    @Insert({"INSERT INTO car_purpose (id, purpose, make_id) VALUES (#{id}, #{purpose}, #{makeId})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long insertCarPurpose(CarPurpose carPurpose);

    @Select({"<script>select * from car_purpose where id IN <foreach collection='purposeIdList' item='purposeId' open='(' separator=',' close=')'>#{purposeId}</foreach></script>"})
    public List<CarPurpose> getByPurposeIdList(@Param("purposeIdList") List<Long> purposeIdList);
}
