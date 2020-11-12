package com.yajun.service;

import com.yajun.dao.UsersDao;
import com.yajun.domain.Users;
import com.yajun.redis.RedisService;
import com.yajun.redis.UserKey;
import org.apache.catalina.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class UsersService {
	
	
	public static final String COOKI_NAME_TOKEN = "token";

	public static final String SERSSION_NAME = "users";

	public static final String SERSSION_OPENID_NAME = "session_openId";

	@Autowired
	RedisService redisService;
	
	@Autowired
	UsersDao usersDao;
	
	public Users getById(long id) {
		//取缓存
		Users users = null;
		if (null != users){
			return users;
		}
		//取数据库
		users = usersDao.getById(id);
		return users;
	}


	public Users getByMobile(String mobile) {
		return usersDao.getByMobile(mobile);
	}

	public Users getByOpenId(String openId){
		return usersDao.getByOpenId(openId);
	}
	

	public Users getByToken(HttpServletResponse response, String token) {
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		Users user = redisService.get(UserKey.token, token, Users.class);
		return user;
	}
	
	private void addCookie(HttpServletResponse response, String token, Users user) {
		//redisService.set(MiaoshaUserKey.token, token, user);
		Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
		//cookie.setMaxAge(MiaoshaUserKey.token.expireSeconds());
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public long insertUsers(Users users){
		return usersDao.insertUsers(users);
	}
}
