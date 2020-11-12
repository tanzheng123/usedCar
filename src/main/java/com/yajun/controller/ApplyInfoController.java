package com.yajun.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yajun.access.AccessLimit;
import com.yajun.config.Constants;
import com.yajun.domain.ApplyInfo;
import com.yajun.domain.Citys;
import com.yajun.domain.Provinces;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.ApplyInfoService;
import com.yajun.service.CitysService;
import com.yajun.service.ProvincesService;
import com.yajun.utils.EncryptUtil;
import com.yajun.vo.ApplyInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("/apply/")
public class ApplyInfoController {

    @Autowired
    ApplyInfoService applyInfoService;

    @Autowired
    private ProvincesService provincesService;

    @Autowired
    private CitysService citysService;

    @RequestMapping(value = "/toList")
    @ResponseBody
    @AccessLimit
    public Result toList(@RequestParam(value = "pageIndex", required = false, defaultValue = "1")int pageIndex,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                         HttpServletRequest request, Users users){
        if(users.getType() != Users.UserStyle.MANAGER.code){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        PageInfo<ApplyInfoVo> pageInfo = applyInfoService.pageAll(pageIndex, pageSize);

        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/myList")
    @ResponseBody
    @AccessLimit
    public Result myList(@RequestParam(value = "pageIndex", required = false, defaultValue = "1")int pageIndex,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                         HttpServletRequest request, Users users){

        PageInfo<ApplyInfoVo> pageInfo = applyInfoService.pageByUserId(users.getId(), pageIndex, pageSize);

        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/addApply")
    @ResponseBody
    @AccessLimit
    public Result insertApplyInfo(String userName, String provinceSign, String citySign, String brandSign, String makeSign, String contactMobile,
                                  Boolean isUrgent, String identityFrontImage, String identityReverseImage,
                                  String registrationImage1, String registrationImage2, String registrationImage3, String registrationImage4, HttpServletRequest request, Users users){

        if (StringUtil.isEmpty(userName)){
            return Result.error(CodeMsg.USER_NAME_EMPTY);
        }

        Result result = EncryptUtil.decodeSign(provinceSign, Constants.PROVINCES_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long provinceId = Long.parseLong(result.getData().toString());
        Provinces provinces = provincesService.getById(provinceId);
        if (provinces == null){
            return Result.error(CodeMsg.ADDRESS_ERROR);
        }

        result = EncryptUtil.decodeSign(citySign, Constants.CITYS_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long cityId = Long.parseLong(result.getData().toString());
        Citys citys = citysService.getById(cityId);
        if (citys == null){
            return Result.error(CodeMsg.ADDRESS_ERROR);
        }


        ApplyInfo applyInfo = new ApplyInfo();
        result = EncryptUtil.decodeSign(brandSign, Constants.CAR_BRAND_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long brandId = Long.parseLong(result.getData().toString());

        result = EncryptUtil.decodeSign(makeSign, Constants.CAR_MAKE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long makeId = Long.parseLong(result.getData().toString());

        if (StringUtil.isEmpty(contactMobile)){
            return Result.error(CodeMsg.CONTACT_MOBILE_EMPTY);
        }

        if (isUrgent == null){
            applyInfo.setUrgent(false);
        }
        applyInfo.setUrgent(isUrgent);
        if (applyInfo.getUrgent()){
            if (StringUtil.isEmpty(identityFrontImage)){
                return Result.error(CodeMsg.IDENTITY_FRONT_IMAGE_EMPTY);
            }
            if (StringUtil.isEmpty(identityReverseImage)){
                return Result.error(CodeMsg.IDENTITY_REVERSE_IMAGE_EMPTY);
            }
        }
        applyInfo.setUserName(userName);
        applyInfo.setProvinceId(provinces.getId());
        applyInfo.setProvince(provinces.getName());
        applyInfo.setCityId(citys.getId());
        applyInfo.setCity(citys.getName());
        applyInfo.setContactMobile(contactMobile);
        applyInfo.setBrandId(brandId);
        applyInfo.setMakeId(makeId);
        applyInfo.setIdentityFrontImage(identityFrontImage);
        applyInfo.setIdentityReverseImage(identityReverseImage);
        applyInfo.setRegistrationImage1(registrationImage1);
        applyInfo.setRegistrationImage2(registrationImage2);
        applyInfo.setRegistrationImage3(registrationImage3);
        applyInfo.setRegistrationImage4(registrationImage4);
        applyInfo.setApplyTime(new Date());
        applyInfo.setUserId(1L);
        Long i = applyInfoService.insertApplyInfo(applyInfo);
        return Result.success("申请成功");
    }
}