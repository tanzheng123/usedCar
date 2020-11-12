package com.yajun.controller;

import com.yajun.access.AccessLimit;
import com.yajun.config.Constants;
import com.yajun.domain.UserAttention;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.CarInfoService;
import com.yajun.service.UserAttentionService;
import com.yajun.utils.EncryptUtil;
import com.yajun.vo.CarInfoVo;
import com.yajun.vo.UserAttentionCarInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/attention/")
public class UserAttentionController {

    @Autowired
    UserAttentionService userAttentionService;

    @Autowired
    CarInfoService carInfoService;

    @RequestMapping(value = "/myAttention")
    @ResponseBody
    @AccessLimit
    public Result selectMyAttention(Users users){
        List<UserAttentionCarInfoVo> userAttentionCarInfoVoList = userAttentionService.selectByUserId(users.getId(), 0);

        return Result.success(userAttentionCarInfoVoList);
    }

    @RequestMapping(value = "/addAttention")
    @ResponseBody
    @AccessLimit
    public Result addAttention(String sign, Users users){
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long carInfoId = Long.parseLong(result.getData().toString());

        CarInfoVo carInfoVo = carInfoService.findDetailById(carInfoId, null);
        if(null == carInfoVo){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        UserAttention userAttention = userAttentionService.selectByUserIdAndCarInfoId(users.getId(), carInfoId);
        if (null == userAttention){
            userAttention = new UserAttention();
            userAttention.setUserId(users.getId());
            userAttention.setCarInfoId(carInfoId);
            userAttention.setStatus(0);
            userAttention.setCreateTime(new Date());
            userAttentionService.insertUserAttention(userAttention);
        }else {
            userAttentionService.updateStatus(users.getId(), carInfoId, 0, userAttention.getUpdateTime());
        }
        return Result.success("成功");
    }

    @RequestMapping(value = "/cancelAttention")
    @ResponseBody
    @AccessLimit
    public Result cancelAttention(String sign, Users users){
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long carInfoId = Long.parseLong(result.getData().toString());
        CarInfoVo carInfoVo = carInfoService.findDetailById(carInfoId, null);
        if(null == carInfoVo){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        UserAttention userAttention = userAttentionService.selectByUserIdAndCarInfoId(users.getId(), carInfoId);
        if (null == userAttention){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        userAttentionService.updateStatus(users.getId(), carInfoId, 1, userAttention.getUpdateTime());
        return Result.success("成功");
    }
}
