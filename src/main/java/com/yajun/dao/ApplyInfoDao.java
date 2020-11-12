package com.yajun.dao;

import com.yajun.domain.ApplyInfo;
import com.yajun.domain.CarBrand;
import com.yajun.vo.ApplyInfoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplyInfoDao {

    @Select("SELECT * FROM apply_info WHERE id = #{applyInfoId}")
    public ApplyInfo getByApplyInfoId(@Param("applyInfoId") long applyInfoId);

    @Select({"select ai.*,cb.first_letter,cb.brand_name,cb.`key` from apply_info ai ",
            " LEFT JOIN car_brand cb ON cb.id = ai.brand_id WHERE ai.user_id = #{userId}"})
    public List<ApplyInfoVo> getByUserId(@Param("userId") long userId);

    @Select({"select ai.*,cb.first_letter,cb.brand_name,cb.`key` from apply_info ai ",
            " LEFT JOIN car_brand cb ON cb.id = ai.brand_id "})
    public List<ApplyInfoVo> getAll();

    @Insert("INSERT INTO apply_info (user_name, province, city, brand_id, make_id, contact_mobile, is_urgent, identity_front_image, identity_reverse_image, registration_image1, registration_image2, registration_image3, registration_image4, apply_time, user_id) " +
            "VALUES (#{userName}, #{province}, #{city}, #{brandId},#{makeId}, #{contactMobile}, #{isUrgent}, #{identityFrontImage}, #{identityReverseImage}, #{registrationImage1}, #{registrationImage2}, #{registrationImage3}, #{registrationImage4}, #{applyTime, jdbcType=TIMESTAMP}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long insertApplyInfo(ApplyInfo applyInfo);
}
