package com.yajun.dao;

import com.yajun.domain.CarPurpose;
import com.yajun.domain.CarStyle;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarStyleDao {

    @Select("select * from car_style where style_purpose_id = #{stylePurposeId}")
    public List<CarStyle> getByPurposeId(@Param("stylePurposeId") long stylePurposeId);

    @Select("select * from car_style where id = #{id}")
    public CarStyle getById(long id);

    @Insert({"INSERT INTO car_style (brand_id, make_id, engine_max_horsepower, style_bulletin_model, style_drive_mode, style_disname, style_name, style_purpose_id, style_purpose_name, emission_standard_id, engine_brand, gerrbox_brand) VALUES " +
            "(#{brandId}, #{makeId}, #{engineMaxHorsepower}, #{styleBulletinModel}, #{styleDriveMode}, #{styleDisname}, #{styleName}, #{stylePurposeId}, #{stylePurposeName}, #{emissionStandardId}, #{engineBrand}, #{gerrboxBrand})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long insertCarStyle(CarStyle carStyle);

    @Select({"SELECT DISTINCT style_purpose_id FROM car_style WHERE make_id = #{makeId}"})
    public List<Long> getByMakeIdForPurposeId(long makeId);

    @Select({"SELECT * FROM car_style WHERE make_id = #{makeId}"})
    public List<CarStyle> getByMakeId(long makeId);
}
