package com.yajun.service;

import com.yajun.dao.AccountMarkDao;
import com.yajun.domain.AccountMark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountMarkService {

    @Autowired
    AccountMarkDao accountMarkDao;

    public Long insertAccountMark(AccountMark accountMark) {
        return accountMarkDao.insertAccountMark(accountMark);
    }

    public AccountMark getById(long accountMarkId) {
        return accountMarkDao.getById(accountMarkId);
    }

    public AccountMark getByOpenId(String openId) {
        return accountMarkDao.getByOpenId(openId);
    }

    public AccountMark getByUserId(long userId) {
        return accountMarkDao.getByUserId(userId);
    }
}
