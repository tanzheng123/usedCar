package com.yajun.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.yajun.config.Constants;
import com.yajun.domain.CarBrand;
import com.yajun.domain.CarMake;
import com.yajun.domain.CarPurpose;
import com.yajun.domain.CarStyle;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.service.*;
import com.yajun.utils.EncryptUtil;
import com.yajun.utils.HttpClientUtil;
import com.yajun.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/brand/")
public class BrandController {

    @Autowired
    CarBrandService carBrandService;

    @Autowired
    CarMakeService carMakeService;

    @Autowired
    CarPurposeService carPurposeService;

    @Autowired
    CarStyleService carStyleService;

    @RequestMapping(value = "/getAllBrand")
    @ResponseBody
    public Result getAllBrand(){
        List<CarBrand> carBrandList = carBrandService.getAll();
        return Result.success(carBrandList);
    }

    @RequestMapping(value = "/getMakeByBrandId")
    @ResponseBody
    public Result getMakeByBrandId(String sign){
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_BRAND_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long brandId = Long.parseLong(result.getData().toString());
        List<CarMake> carMakeList = carMakeService.getByBrandId(brandId);
        return Result.success(carMakeList);
    }

    @RequestMapping(value = "/getCarPurposeByMakeId")
    @ResponseBody
    public Result getCarPurposeByMakeId(String sign){
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_MAKE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long makeId = Long.parseLong(result.getData().toString());

        Map<String, Object> resultMap = new HashMap<>();

        List<Long> purposeIdList = carStyleService.getByMakeIdForPurposeId(makeId);
        if(purposeIdList != null){
            List<CarPurpose> purposeList = carPurposeService.getByPurposeIdList(purposeIdList);
            List<CarStyle> carStyleList = carStyleService.getByMakeId(makeId);
            Map<String, List<CarStyle>> carStyleMap = new HashMap<>();
            for (CarStyle carStyle:carStyleList){
                List<CarStyle> carStyles = carStyleMap.get(ObjectUtil.getString(carStyle.getStylePurposeId()));
                if (carStyles == null){
                    carStyles = new ArrayList<>();
                }
                carStyles.add(carStyle);
                carStyleMap.put(ObjectUtil.getString(carStyle.getStylePurposeId()), carStyles);
            }
            resultMap.put("carPurpose", purposeList);
            resultMap.put("style", carStyleMap);
        }

       // List<CarPurpose> carPurposeList = carPurposeService.getByMakeId(makeId);
        return Result.success(resultMap);
    }

   /* @RequestMapping(value = "/getCarStyleByPurposeId")
    @ResponseBody
    public Result getCarStyleByPurposeId(String sign){
        Result result = EncryptUtil.decodeSign(sign, Constants.CAR_PURPOSE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
        if (result.getCode() > 0){
            return result;
        }
        long stylePurposeId = Long.parseLong(result.getData().toString());
        List<CarStyle> carStyleList = carStyleService.getByPurposeId(stylePurposeId);
        return Result.success(carStyleList);
    }

    @RequestMapping(value = "/saveBrand")
    @ResponseBody
    public Result saveBrand(){
        List<CarBrand> carBrandList = carBrandService.getAll();
       for (CarBrand carBrand: carBrandList) {
           System.out.println(carBrand.getKey());
           Long carBrandId = carBrand.getId();
           String sss = HttpClientUtil.doGet("https://vehest.shiqiaoqiche.com/vehestweb/est/est/estresult/getModelByMakeId.do?makeId=" + carBrand.getKey());
           System.out.println("车系：" + sss);
           JSONObject jsonObject = JSONObject.parseObject(sss);
           Map<String, Object> stringObjectMap = WxService.parseJSON2Map(jsonObject);
           List list = (ArrayList)stringObjectMap.get("data");
           for (int i = 0; i < list.size(); i++){
               Map modelMap = (Map) list.get(i);
               String modelId = ObjectUtil.getString(modelMap.get("modelid"));
               String modelname = ObjectUtil.getString(modelMap.get("modelname"));
               CarMake carMake = new CarMake();
               carMake.setBrandId(carBrandId);
               carMake.setMakeName(modelname);
               carMake.setModelId(modelId);
               Long makeId = carMakeService.insertCarMake(carMake);
               makeId = carMake.getId();
               System.out.println("makeId = " + makeId);
               String two = HttpClientUtil.doGet("https://vehest.shiqiaoqiche.com/vehestweb/est/est/estresult/getCarTypeByModelId.do?modelId=" + modelId);

               JSONObject jsonObject2 = JSONObject.parseObject(two);
               Map<String, Object> stringObjectMap2 = WxService.parseJSON2Map(jsonObject2);
               Map<String, Object> dataMap = (Map)stringObjectMap2.get("data");
               List cartypeList = (List)dataMap.get("cartype");

               for (int k = 0; k < cartypeList.size(); k++) {
                   Map cartypeMap = (Map)cartypeList.get(k);
                   String id = ObjectUtil.getString(cartypeMap.get("id"));
                   String name = ObjectUtil.getString(cartypeMap.get("name"));
                   System.out.println("id = " + id + " , name = " + name);
                   CarPurpose carPurpose = new CarPurpose();
                   carPurpose.setId(ObjectUtil.getLong(id));
                   carPurpose.setPurpose(name);
                   CarPurpose old = carPurposeService.getById(ObjectUtil.getLong(id));
                   if (old == null){
                       Long purposeId = carPurposeService.insertCarPurpose(carPurpose);
                   }
                   Map styleIdMap = (Map)dataMap.get("style");

                   List styleList = (List)styleIdMap.get(id);
                   for (int j = 0; j < styleList.size(); j++) {
                       Map styleMap = (Map) styleList.get(j);
                       String emissionStandardId = ObjectUtil.getString(styleMap.get("emissionStandardId"));
                       String engineBrand = ObjectUtil.getString(styleMap.get("engineBrand"));
                       String engineMaxHorsepower = ObjectUtil.getString(styleMap.get("engineMaxHorsepower"));
                       String gerrboxBrand = ObjectUtil.getString(styleMap.get("gerrboxBrand"));
                       String styleId = ObjectUtil.getString(styleMap.get("id"));
                       String styleBulletinModel = ObjectUtil.getString(styleMap.get("styleBulletinModel"));
                       String styleDisname = ObjectUtil.getString(styleMap.get("styleDisname"));
                       String styleDriveMode = ObjectUtil.getString(styleMap.get("styleDriveMode"));
                       String styleName = ObjectUtil.getString(styleMap.get("styleName"));
                       String stylePurposeId = ObjectUtil.getString(styleMap.get("stylePurposeId"));
                       String stylePurposeName = ObjectUtil.getString(styleMap.get("stylePurposeName"));
                       System.out.println("stylePurposeId = " + stylePurposeId + " , stylePurposeName = " + stylePurposeName + ", styleDisname = " + styleDisname);
                       CarStyle carStyle = new CarStyle();
                       carStyle.setEmissionStandardId(ObjectUtil.getLong(emissionStandardId));
                       carStyle.setEngineBrand(engineBrand);
                       carStyle.setEngineMaxHorsepower(engineMaxHorsepower);
                       carStyle.setGerrboxBrand(gerrboxBrand);
                       carStyle.setStyleBulletinModel(styleBulletinModel);
                       carStyle.setStyleDisname(styleDisname);
                       carStyle.setStyleDriveMode(styleDriveMode);
                       carStyle.setStyleName(styleName);
                       carStyle.setStylePurposeId(ObjectUtil.getLong(stylePurposeId));
                       carStyle.setStylePurposeName(stylePurposeName);
                       carStyle.setBrandId(carBrandId);
                       carStyle.setMakeId(makeId);
                       Long carStyleId = carStyleService.insertCarStyle(carStyle);
                   }
               }
           }
        }

        return Result.success(carBrandList);
    }*/
}
