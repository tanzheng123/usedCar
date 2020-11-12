package com.yajun.dao;

import com.github.pagehelper.PageInfo;
import com.yajun.domain.CarInfo;
import com.yajun.vo.CarInfoVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarInfoDao {

    @Select({"<script>","SELECT cb.brand_name brandName,cm.make_name makeName,cp.purpose,cs.style_disname styleDisname,",
            "cs.style_name styleName,ci.*<when test='userId != null'>, caa.user_id attentionUserId,caa.status attentionStatus </when> " ,
            "FROM car_info ci " ,
            "LEFT JOIN car_brand cb on cb.id = ci.brand_id " ,
            "LEFT JOIN car_make cm ON cm.id = ci.make_id " ,
            "LEFT JOIN car_purpose cp ON cp.id = ci.purpose_id " ,
            "<when test='userId != null'> LEFT JOIN user_attention caa ON caa.car_info_id = ci.id AND caa.user_id = #{userId} </when> " ,
            "LEFT JOIN car_style cs ON cs.id = ci.car_style_id WHERE ci.status = #{status}</script>"})
    public List<CarInfoVo> getByStatus(@Param("status") int status,@Param("userId") Long userId);

    @Select({"<script>","SELECT cb.brand_name brandName,cm.make_name makeName,cp.purpose,cs.style_disname styleDisname,",
            "cs.style_name styleName,ci.*<when test='userId != null'>, caa.user_id attentionUserId,caa.status attentionStatus </when> " ,
            "FROM car_info ci " ,
            "LEFT JOIN car_brand cb on cb.id = ci.brand_id " ,
            "LEFT JOIN car_make cm ON cm.id = ci.make_id " ,
            "LEFT JOIN car_purpose cp ON cp.id = ci.purpose_id " ,
            "<when test='userId != null'> LEFT JOIN user_attention caa ON caa.car_info_id = ci.id AND caa.user_id = #{userId} </when> " ,
            "LEFT JOIN car_style cs ON cs.id = ci.car_style_id WHERE ci.id = #{carInfoId}</script>"})
    CarInfoVo findDetailById(@Param("carInfoId") long carInfoId,@Param("userId") Long userId);

    @Insert({ "INSERT INTO car_info (brand_id, make_id, purpose_id, car_style_id, province_id, province ,city_id ,city, formalities_time, mileage, price, photo1, photo2, photo3, photo4, photo5, user_id, remak, release_time, status, manager_name, manager_mobile, manager_user_id) " +
            "VALUES (#{brandId}, #{makeId}, #{purposeId}, #{carStyleId}, #{provinceId}, #{province}, #{cityId}, #{city}, #{formalitiesTime, jdbcType=TIMESTAMP}, #{mileage}, #{price}, #{photo1}, #{photo2}, #{photo3}, #{photo4}, #{photo5}, #{userId}, #{remak}, #{releaseTime, jdbcType=TIMESTAMP}, #{status}, #{managerName}, #{managerMobile}, #{managerUserId})" })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long insertCarInfo(CarInfo carInfo);

    @Select({"<script>","SELECT cb.brand_name brandName,cm.make_name makeName,cp.purpose,cs.style_disname styleDisname,",
            "cs.style_name styleName,ci.* " ,
            "FROM car_info ci " ,
            "LEFT JOIN car_brand cb on cb.id = ci.brand_id " ,
            "LEFT JOIN car_make cm ON cm.id = ci.make_id " ,
            "LEFT JOIN car_purpose cp ON cp.id = ci.purpose_id " ,
            "LEFT JOIN car_style cs ON cs.id = ci.car_style_id WHERE ci.user_id = #{userId}</script>"})
    public List<CarInfoVo> getByUserId(@Param("userId") Long userId);
}
