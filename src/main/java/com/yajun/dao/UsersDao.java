package com.yajun.dao;

import com.yajun.domain.Users;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UsersDao {
	
	@Select("select * from users where id = #{id}")
	public Users getById(@Param("id") long id);

	@Select("select * from users where nickname = #{nickname}")
	public Users getByNickname(@Param("nickname") String nickname);

	@Select("select * from users where mobile = #{mobile}")
	public Users getByMobile(@Param("mobile") String mobile);

	@Select("select * from users where open_id = #{openId}")
	public Users getByOpenId(@Param("openId") String openId);

	@Insert("INSERT INTO users (mobile, user_name, true_name, address, type, open_id) VALUES " +
			"(#{mobile}, #{userName}, #{trueName}, #{address}, #{type}, #{openId}, #{registerTime, jdbcType=TIMESTAMP})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public long insertUsers(Users users);
}
