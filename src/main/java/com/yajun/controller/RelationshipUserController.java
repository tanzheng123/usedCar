package com.yajun.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.github.pagehelper.PageInfo;
import com.yajun.access.AccessLimit;
import com.yajun.config.Constants;
import com.yajun.domain.AccountMark;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.AccountMarkService;
import com.yajun.service.RelationshipUserService;
import com.yajun.service.UsersService;
import com.yajun.service.WxService;
import com.yajun.utils.EncryptUtil;
import com.yajun.utils.ObjectUtil;
import com.yajun.vo.RelationshipUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/relationship/")
public class RelationshipUserController {

    Logger logger = LoggerFactory.getLogger(RelationshipUserController.class);

    @Autowired
    AccountMarkService accountMarkService;

    @Autowired
    RelationshipUserService relationshipUserService;

    @Autowired
    WxService wxService;

    @Autowired
    UsersService usersService;

    @RequestMapping("mark")
    @ResponseBody
    public Result getSessionKey(@RequestParam(value = "code", required = false)String code, HttpServletRequest request, String sign) {

        Result result = EncryptUtil.decodeSign(sign, Constants.USER_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long userId = Long.parseLong(result.getData().toString());

        Users managerUser = usersService.getById(userId);
        if (managerUser == null){
            logger.info("分享参数为null");
            return Result.error(CodeMsg.PARAM_EMPTY);
        }

        Map<String, Object> key = wxService.getSessionKey(code);
        String openid = ObjectUtil.getString(key.get("openid"));
        Users users = usersService.getByOpenId(openid);
        if (users != null){
            logger.info("已经注册用户不用标记， %s", JSONUtils.toJSONString(users));
        }else{
            AccountMark accountMark = new AccountMark();
            accountMark.setOpenId(openid);
            accountMark.setUserId(managerUser.getId());
            accountMark.setTime(new Date());
            accountMarkService.insertAccountMark(accountMark);
        }
        return Result.success("成功");
    }

    @RequestMapping(value = "/tolist")
    @ResponseBody
    @AccessLimit
    public Result pageCarInfo(@RequestParam(value = "pageIndex", required = false, defaultValue = "1")int pageIndex,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                              HttpServletRequest request, Users users){

        if (users.getType() != Users.UserStyle.MANAGER.code){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        PageInfo<RelationshipUserVo> pageInfo = relationshipUserService.getBySpreaderId(users.getId(), pageIndex, pageSize);

        return Result.success(pageInfo);
    }
}
