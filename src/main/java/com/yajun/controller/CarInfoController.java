package com.yajun.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.yajun.access.AccessLimit;
import com.yajun.config.Constants;
import com.yajun.domain.*;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.*;
import com.yajun.utils.DateUtil;
import com.yajun.utils.EncryptUtil;
import com.yajun.utils.ObjectUtils;
import com.yajun.vo.CarInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping("/carInfo/")
public class CarInfoController {

    @Autowired
    CarInfoService carInfoService;

    @Autowired
    CarStyleService carStyleService;

    @Autowired
    UsersService usersService;

    @Autowired
    private ProvincesService provincesService;

    @Autowired
    private CitysService citysService;

    @RequestMapping(value = "/tolist")
    @ResponseBody
    public Result pageCarInfo(@RequestParam(value = "pageIndex", required = false, defaultValue = "1")int pageIndex,
                                        @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                                        HttpServletRequest request, Users users){
        Long userId = null;
        if (null != users){
            userId = users.getId();
        }
        PageInfo<CarInfoVo> carInfoVoList = carInfoService.pageByStatus(0, pageIndex, pageSize, userId);
        return Result.success(carInfoVoList);
    }

    @RequestMapping(value = "/detail")
    @ResponseBody
    public Result toDetail(HttpServletRequest request, Users users, String sign){
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long carInfoId = Long.parseLong(result.getData().toString());
        Long userId = null;
        if (null != users){
            users.getId();
        }
        CarInfoVo carInfoVo = carInfoService.findDetailById(carInfoId, userId);
        return Result.success(carInfoVo);
    }

    @RequestMapping(value = "/releaseCarInfo")
    @ResponseBody
    @AccessLimit
    public Result releaseCarInfo(String carStyleSign, String provinceSign, String citySign,
                                 String formalitiesTime, String mileage, BigDecimal price, String photo1, String photo2,
                                 String photo3, String photo4, String photo5, String remak, String managerName,
                                 String managerMobile, Users users){

        Result result = EncryptUtil.decodeSign(carStyleSign, Constants.CAR_STYLE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long carStyleId = Long.parseLong(result.getData().toString());

        result = EncryptUtil.decodeSign(provinceSign, Constants.PROVINCES_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
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

        if(StringUtil.isEmpty(formalitiesTime)){
            return Result.error(CodeMsg.FORMALITIES_TIME_EMPTY);
        }

        if(StringUtil.isEmpty(mileage)){
            return Result.error(CodeMsg.MILEAGE_EMPTY);
        }

        if(null == price){
            return Result.error(CodeMsg.PRICE_EMPTY);
        }

        if(null == photo1){
            return Result.error(CodeMsg.PHOTO1_EMPTY);
        }

        if(null == photo2){
            return Result.error(CodeMsg.PHOTO2_EMPTY);
        }

        if(null == photo3){
            return Result.error(CodeMsg.PHOTO3_EMPTY);
        }
        if(null == photo4){
            return Result.error(CodeMsg.PHOTO4_EMPTY);
        }
        if (StringUtil.isEmpty(managerName)){
            return Result.error(CodeMsg.CUSTOMER_MANAGER_NAME_EMPTY);
        }

        if (StringUtil.isEmpty(managerMobile)){
            return Result.error(CodeMsg.CUSTOMER_MANAGER_MOBILE_EMPTY);
        }

        CarStyle carStyle = carStyleService.getById(carStyleId);
        if (carStyle == null){
            return Result.error(CodeMsg.REQUEST_ILLEGAL);
        }
        CarInfo carInfo = new CarInfo();
        carInfo.setBrandId(carStyle.getBrandId());
        carInfo.setMakeId(carStyle.getMakeId());
        carInfo.setPurposeId(carStyle.getStylePurposeId());
        carInfo.setCarStyleId(carStyleId);
        carInfo.setProvinceId(provinces.getId());
        carInfo.setProvince(provinces.getName());
        carInfo.setCityId(citys.getId());
        carInfo.setCity(citys.getName());
        carInfo.setFormalitiesTime(DateUtil.strToDate(formalitiesTime, "yyyy-MM"));
        carInfo.setMileage(mileage);
        carInfo.setPrice(price);
        carInfo.setPhoto1(photo1);
        carInfo.setPhoto2(photo2);
        carInfo.setPhoto3(photo3);
        carInfo.setPhoto4(photo4);
        carInfo.setPhoto5(photo5);
        carInfo.setUserId(1L);
        carInfo.setRemak(remak);
        carInfo.setReleaseTime(new Date());
        carInfo.setStatus(0);
        carInfo.setManagerName(managerName);
        carInfo.setManagerMobile(managerMobile);
        Users managerUser = usersService.getByMobile(managerMobile);
        if (null != managerUser){
            //if (managerUser.getType() == 1){
                carInfo.setManagerUserId(managerUser.getId());
           // }
        }
        carInfoService.insertCarInfo(carInfo);

        return Result.success("成功");
    }

    @RequestMapping(value = "/mySellCar")
    @ResponseBody
    @AccessLimit
    public Result mySellCar(@RequestParam(value = "pageIndex", required = false, defaultValue = "1")int pageIndex,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
                              HttpServletRequest request, Users users){
        Long userId = null;
        if (null != users){
            users.getId();
        }
        PageInfo<CarInfoVo> carInfoVoList = carInfoService.pageByUserId(pageIndex, pageSize, userId);
        return Result.success(carInfoVoList);
    }
}
