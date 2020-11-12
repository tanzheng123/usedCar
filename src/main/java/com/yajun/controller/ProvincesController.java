package com.yajun.controller;

import com.yajun.config.Constants;
import com.yajun.domain.Citys;
import com.yajun.domain.Provinces;
import com.yajun.result.Result;
import com.yajun.service.CitysService;
import com.yajun.service.ProvincesService;
import com.yajun.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/region/")
public class ProvincesController {

    private static Logger logger = LoggerFactory.getLogger(ProvincesController.class);

    @Autowired
    private ProvincesService provincesService;

    @Autowired
    private CitysService citysService;

    @RequestMapping("getProvinces")
    @ResponseBody
    public Result getProvinces(HttpServletRequest request) {
        List<Provinces> provincesList = provincesService.getByStatus(0);
        return Result.success(provincesList);
    }

    @RequestMapping("getCitys")
    @ResponseBody
    public Result getCitys(HttpServletRequest request,String sign) {

        Result result = EncryptUtil.decodeSign(sign, Constants.PROVINCES_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long provinceId = Long.parseLong(result.getData().toString());
        List<Citys> citysList = citysService.getByProvinceId(provinceId);
        return Result.success(citysList);
    }
}
