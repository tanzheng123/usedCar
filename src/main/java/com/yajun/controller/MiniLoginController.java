package com.yajun.controller;

import com.alibaba.fastjson.JSONObject;
import com.yajun.domain.AccountMark;
import com.yajun.domain.RelationshipUser;
import com.yajun.domain.Users;
import com.yajun.redis.RedisService;
import com.yajun.redis.UserKey;
import com.yajun.result.Result;
import com.yajun.service.AccountMarkService;
import com.yajun.service.RelationshipUserService;
import com.yajun.service.UsersService;
import com.yajun.service.WxService;
import com.yajun.utils.ObjectUtil;
import com.yajun.utils.UUIDUtil;
import com.yajun.utils.WXBizDataCrypt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/mini/login")
public class MiniLoginController {

    Logger logger = LoggerFactory.getLogger(MiniLoginController.class);

    @Autowired
    private WxService wxService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private RelationshipUserService relationshipUserService;

    @Autowired
    private AccountMarkService accountMarkService;

    @Autowired
    protected RedisService redisService;

    @RequestMapping("getSessionKey")
    @ResponseBody
    public Result getSessionKey(@RequestParam(value = "code", required = false)String code, HttpServletRequest request) {
        Map<String, Object> key = wxService.getSessionKey(code);
        String openid = ObjectUtil.getString(key.get("openid"));
        openid = "1654688165";  //多余
        if (openid == null){
            return Result.success(key);
        }
        Users users = usersService.getByOpenId(openid);
        HttpSession session = request.getSession();
        if (users != null){
            //生成token
            String token = UUIDUtil.uuid();
            redisService.set(UserKey.token, token, users);
            key.put("token", token);
            key.put("status", 1);
        }else{
            redisService.set(UserKey.openid,"", openid);
            key.put("status", 2);
        }
        return Result.success(key);
    }

    /**
     * 小程序授权获取手机号
     */
    @RequestMapping(value="/getPhoneNumber")
    @ResponseBody
    public  Result getPhoneNumber(String encryptedData, String iv, String session_key, HttpServletRequest request) {
        Map<String,Object> map=new HashMap<>();

        String result= WXBizDataCrypt.decrypt1(encryptedData,session_key,iv);
        JSONObject json=JSONObject.parseObject(result);

        HttpSession session = request.getSession();

        if (!StringUtils.isEmpty(result)&&result.length()>0) {
            map.put("purePhoneNumber", json.getString("purePhoneNumber"));
            map.put("phoneNumber", json.getString("phoneNumber"));
            map.put("countryCode", json.getString("countryCode"));
            map.put("msg","success");
        }
        String openId = ObjectUtil.getString(session.getAttribute(UsersService.SERSSION_NAME));
        String phoneNumber = ObjectUtil.getString(map.get("phoneNumber"));
        Users users = new Users();
        users.setMobile(phoneNumber);
        users.setType(0);
        users.setOpenId(openId);
        users.setRegisterTime(new Date());
        long userId = usersService.insertUsers(users);

        //生成token
        String token = UUIDUtil.uuid();
        redisService.set(UserKey.token, token, users);
        Map<String, Object> resultMap = new HashMap<>();
        map.put("user", users);
        map.put("token", token);

        AccountMark accountMark = accountMarkService.getByOpenId(openId);
        if (accountMark == null){
            logger.info("不存在分享关系， openId = %s", openId);
        }else {
            Users managerUser = usersService.getById(accountMark.getUserId());
            if (managerUser == null){
                logger.info("邀请关系用户id = %s 不存在", accountMark.getUserId());
            }else {
                if (managerUser.getType() != Users.UserStyle.MANAGER.code){
                    logger.info("邀请关系用户id = %s 非管理人员，userType = %s, 被邀请userId = %s", managerUser.getId(), managerUser.getType(), userId);
                }else {
                    RelationshipUser relationshipUser = new RelationshipUser();
                    relationshipUser.setSpreaderId(managerUser.getId());
                    relationshipUser.setTime(new Date());
                    relationshipUser.setUserId(userId);
                    relationshipUserService.insertRelationshipUser(relationshipUser);
                }
            }
        }



        return Result.success(resultMap);
    }
}
