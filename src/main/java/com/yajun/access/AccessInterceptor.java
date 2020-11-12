package com.yajun.access;

import com.alibaba.fastjson.JSON;
import com.yajun.domain.Users;
import com.yajun.redis.AccessKey;
import com.yajun.redis.RedisService;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccessInterceptor  extends HandlerInterceptorAdapter {
	
	@Autowired
	UsersService usersService;

	@Autowired
	RedisService redisService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			Users user = getUser(request, response);
			UserContext.setUser(user);
			HandlerMethod hm = (HandlerMethod)handler;
			AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
			if(accessLimit != null) {
				if (user == null){
					render(response, CodeMsg.SESSION_ERROR);
					return false;
				}
			}
		}
		return true;
	}
	
	private void render(HttpServletResponse response, CodeMsg cm)throws Exception {
		response.setContentType("application/json;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		String str  = JSON.toJSONString(Result.error(cm));
		out.write(str.getBytes("UTF-8"));
		out.flush();
		out.close();
	}

	private Users getUser(HttpServletRequest request, HttpServletResponse response) {
		String headerToken = getHeader(request, UsersService.COOKI_NAME_TOKEN);
		String paramToken = request.getParameter(UsersService.COOKI_NAME_TOKEN);
		String cookieToken = getCookieValue(request, UsersService.COOKI_NAME_TOKEN);
		if(StringUtils.isEmpty(headerToken) && StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(paramToken)) {
			return null;
		}
		String token = headerToken;
		if (StringUtils.isNotEmpty(paramToken)){
			token = paramToken;
		}
		if (StringUtils.isNotEmpty(cookieToken)){
			token = cookieToken;
		}

		return usersService.getByToken(response, token);
	}

	private String getHeader(HttpServletRequest request, String headerName) {
		return request.getHeader(headerName);
	}

	//get request headers
	private Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}
	
	private String getCookieValue(HttpServletRequest request, String cookiName) {
		Cookie[]  cookies = request.getCookies();
		if(cookies == null || cookies.length <= 0){
			return null;
		}
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(cookiName)) {
				return cookie.getValue();
			}
		}
		return null;
	}
}
