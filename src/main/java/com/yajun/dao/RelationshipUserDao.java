package com.yajun.dao;

import com.yajun.domain.RelationshipUser;
import com.yajun.vo.RelationshipUserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RelationshipUserDao {

    @Insert({"INSERT INTO relationship_user (time, user_id, spreader_id) VALUES (#{time, jdbcType=TIMESTAMP}, #{userId}, #{spreaderId})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long insertRelationshipUser(RelationshipUser relationshipUser);

    @Select({"SELECT * FROM relationship_user WHERE id = #{id}"})
    public RelationshipUser getById(long id);

    @Select({"SELECT u.*,ru.id relationshipUserId,ru.time,ru.user_id,ru.spreader_id FROM relationship_user ru LEFT JOIN users u ON ru.user_id = u.id WHERE ru.user_id = #{userId}"})
    public RelationshipUserVo getByUserId(long userId);

    @Select({"SELECT u.*,ru.id relationshipUserId,ru.time,ru.user_id,ru.spreader_id FROM relationship_user ru LEFT JOIN users u ON ru.user_id = u.id WHERE ru.spreader_id = #{spreaderId}"})
    public List<RelationshipUserVo> getBySpreaderId(long spreaderId);
}
