package com.yajun.access;

import com.alibaba.fastjson.JSON;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;

@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            LoginCheck loginCheck = hm.getMethodAnnotation(LoginCheck.class);
            if (loginCheck == null) {
                return true;
            }
            Users user = getUser(request, response);
            UserContext.setUser(user);
            if(user == null) {
                render(response, CodeMsg.SESSION_ERROR);
                return false;
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
        // 使用@LoginCheck注解，则进行登录验证
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute(UsersService.SERSSION_NAME);
        return user;
    }
}
