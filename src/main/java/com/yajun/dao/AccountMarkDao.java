package com.yajun.dao;

import com.yajun.domain.AccountMark;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMarkDao {

    @Insert({"INSERT INTO account_mark (time, open_id, user_id) VALUES (#{time, jdbcType=TIMESTAMP}, #{openId}, #{userId})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long insertAccountMark(AccountMark accountMark);

    @Select({"SELECT * FROM account_mark WHERE id = #{accountMarkId}"})
    public AccountMark getById(long accountMarkId);

    @Select({"SELECT * FROM account_mark WHERE open_id = #{openId}"})
    public AccountMark getByOpenId(String openId);

    @Select({"SELECT * FROM account_mark WHERE user_id = #{userId}"})
    public AccountMark getByUserId(long userId);
}
