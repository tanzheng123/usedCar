package com.yajun.dao;

import com.yajun.domain.UserAttention;
import com.yajun.vo.UserAttentionCarInfoVo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UserAttentionDao {

    @Insert("INSERT INTO user_attention (user_id, car_info_id, status, create_time, update_time) VALUES " +
            "(#{userId}, #{carInfoId}, #{status}, #{createTime, jdbcType=TIMESTAMP}, #{updateTime, jdbcType=TIMESTAMP})")
    public Long insertUserAttention(UserAttention userAttention);

    @Update({"UPDATE user_attention SET status=#{status}, update_time=#{updateTime, jdbcType=TIMESTAMP} WHERE user_id=#{userId} AND car_info_id=#{carInfoId}"})
    public void updateStatus(Long userId, Long carInfoId, Integer status, Date updateTime);

    @Select("SELECT * FROM user_attention WHERE user_id = #{userId} AND car_info_id = #{carInfoId} ")
    public UserAttention selectByUserIdAndCarInfoId(Long userId, Long carInfoId);

    @Select("SELECT cb.brand_name brandName,cm.make_name makeName,cp.purpose,cs.style_disname styleDisname,cs.style_name styleName,ci.* " +
            "FROM user_attention ua " +
            "LEFT JOIN car_info ci on ci.id = ua.car_info_id " +
            "LEFT JOIN car_brand cb on cb.id = ci.brand_id " +
            "LEFT JOIN car_make cm ON cm.id = ci.make_id " +
            "LEFT JOIN car_purpose cp ON cp.id = ci.purpose_id " +
            "LEFT JOIN car_style cs ON cs.id = ci.car_style_id WHERE ua.user_id = #{userId} AND ua.status = #{status}")
    public List<UserAttentionCarInfoVo> selectByUserIdAndStatus(@Param(value = "userId") Long userId,@Param(value = "status") Integer status);
}
