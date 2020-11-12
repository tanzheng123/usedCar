package com.yajun.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yajun.dao.RelationshipUserDao;
import com.yajun.domain.RelationshipUser;
import com.yajun.vo.RelationshipUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipUserService {

    @Autowired
    RelationshipUserDao relationshipUserDao;

    public Long insertRelationshipUser(RelationshipUser relationshipUser) {
        return relationshipUserDao.insertRelationshipUser(relationshipUser);
    }

    public RelationshipUser getById(long id) {
        return relationshipUserDao.getById(id);
    }

    public RelationshipUserVo getByUserId(long userId) {
        return relationshipUserDao.getByUserId(userId);
    }

    public PageInfo<RelationshipUserVo> getBySpreaderId(long spreaderId, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<RelationshipUserVo> carInfoVoList = relationshipUserDao.getBySpreaderId(spreaderId);
        PageInfo<RelationshipUserVo> pageInfo = new PageInfo<>(carInfoVoList);
        return pageInfo;
    }
}
