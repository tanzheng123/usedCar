package com.yajun.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yajun.domain.CarBrand;
import com.yajun.service.CarBrandService;
import com.yajun.service.WxService;
import com.yajun.utils.ObjectUtil;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class DemoApplicationTests {

	//@Autowired
	//private CarBrandService carBrandService;

	//@Test
	void contextLoads() {
		/*List<CarBrand> carBrands = carBrandService.getAll();

		for (CarBrand carBrand: carBrands) {
			System.out.println(carBrand.getKey());
		}*/
	}

	public static void main(String[] args) {
		//carssssss();

	}

    /*public static void carssssss(){
	    StringBuffer sb = new StringBuffer();
	    sb.append("{'data':{'cartype':[{'id':73,'name':'载货车'},{'id':71,'name':'自卸车'},{'id':63,'name':'牵引车'},{'id':239,'name':'城建渣土车'},{'id':22,'name':'混凝土搅拌车'}],'style':{'22':[{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':190621433017982,'styleBulletinModel':'BZ5254GJBNV4','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 12m³','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 12立方 混凝土搅拌车 (BZ5254GJBNV4)','stylePurposeId':22,'stylePurposeName':'混凝土搅拌车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':181221433010160,'styleBulletinModel':'ND5313GJBZ','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 16m³','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336N) (国三) (法士特) 8×4 16立方 混凝土搅拌车 (ND5313GJBZ)','stylePurposeId':22,'stylePurposeName':'混凝土搅拌车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'10','id':180322433032042,'styleBulletinModel':'ND5310GJBZ09','styleDisname':'336马力 8×4 潍柴 采埃孚 柴油 国四 16m³','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (采埃孚) 8×4 16立方 混凝土搅拌车 (ND5310GJBZ09)','stylePurposeId':22,'stylePurposeName':'混凝土搅拌车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'10','id':180322433032054,'styleBulletinModel':'ND5250GJBZ12','styleDisname':'350马力 6×4 潍柴 采埃孚 天然气(LNG/CNG) 国四 12m³','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E40) (国四) (采埃孚) 6×4 12立方 混凝土搅拌车 (ND5250GJBZ12)','stylePurposeId':22,'stylePurposeName':'混凝土搅拌车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'10','id':180322433032060,'styleBulletinModel':'ND5250GJBZ12','styleDisname':'380马力 6×4 潍柴 采埃孚 天然气(LNG/CNG) 国四 12m³','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E40) (国四) (采埃孚) 6×4 12立方 混凝土搅拌车 (ND5250GJBZ12)','stylePurposeId':22,'stylePurposeName':'混凝土搅拌车'}],'239':[{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433025337,'styleBulletinModel':'ND5250ZLJZ04','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 5.6米 后翻自卸式 城建渣土车 (ND5250ZLJZ04)','stylePurposeId':239,'stylePurposeName':'城建渣土车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029076,'styleBulletinModel':'ND33103D28J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国四 6.4米','styleDriveMode':'9','styleName':'北奔 NG80B重卡 336马力 8×4 6.4米新型环保渣土车(ND33103D28J)','stylePurposeId':239,'stylePurposeName':'城建渣土车'}],'71':[{'emissionStandardId':2,'engineBrand':'9','engineMaxHorsepower':240,'gerrboxBrand':'4','id':180322433029300,'styleBulletinModel':'ND33100D34J','styleDisname':'240马力 8×4 玉柴 法士特 柴油 国三 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (玉柴) 240马力 (YC6A240-33) (国三) (法士特) 8×4 6.8米 后翻自卸式 自卸车 (ND33100D34J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':260,'gerrboxBrand':'16','id':180322433029465,'styleBulletinModel':'ND3318D47J','styleDisname':'260马力 8×4 大柴 綦江 柴油 国三 9.42米','styleDriveMode':'9','styleName':'北奔NG80 (大柴) 260马力 (BF6M1013-26E3) (国三) (綦江) 8×4 9.4米 自卸式 自卸车 (ND3318D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433021837,'styleBulletinModel':'ND3253B31','styleDisname':'270马力 6×4 潍柴 法士特 柴油 国三 4.81米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270) (国三) (法士特) 6×4 4.8米 后翻自卸式 自卸车 (ND3253B31)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433021827,'styleBulletinModel':'ND5250ZLJZ03','styleDisname':'270马力 6×4 潍柴 法士特 柴油 国四 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (法士特) 6×4 5.8米 自卸式 自卸车 (ND5250ZLJZ03)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433029302,'styleBulletinModel':'ND32501B38','styleDisname':'270马力 6×4 潍柴 法士特 柴油 国四 5.17米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (法士特) 6×4 5.2米 自卸式 自卸车 (ND32501B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433029066,'styleBulletinModel':'ND33102D37J','styleDisname':'270马力 8×4 潍柴 法士特 柴油 国三 7.6米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E32) (国三) (法士特) 8×4 7.6米 后翻自卸式 自卸车 (ND33102D37J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433029283,'styleBulletinModel':'ND33100D31J','styleDisname':'270马力 8×4 潍柴 法士特 柴油 国四 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (法士特) 8×4 6.8米 自卸式 自卸车 (ND33100D31J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433029286,'styleBulletinModel':'ND33101D37J','styleDisname':'270马力 8×4 潍柴 法士特 柴油 国四 7.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (法士特) 8×4 7.4米 自卸式 自卸车 (ND33101D37J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':280,'gerrboxBrand':'16','id':180322433029294,'styleBulletinModel':'ND3318D47J','styleDisname':'280马力 8×4 大柴 綦江 柴油 国三 9.42米','styleDriveMode':'9','styleName':'北奔NG80 (大柴) 280马力 (BF6M1013-28E3) (国三) (綦江) 8×4 9.4米 自卸式 自卸车 (ND3318D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'49','id':180322433029457,'styleBulletinModel':'ND3250B34J','styleDisname':'290马力 6×4 潍柴 北奔 柴油 国三 4.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290E32) (国三) (北奔) 6×4 4.8米 后翻自卸式 自卸车 (ND3250B34J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433021840,'styleBulletinModel':'ND3255B38','styleDisname':'290马力 6×4 潍柴 法士特 柴油 国三 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290NE31) (国三) (法士特) 6×4 5.8米 后翻自卸式 自卸车 (ND3255B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':290,'gerrboxBrand':'49','id':180322433021819,'styleBulletinModel':'ND3250B31','styleDisname':'290马力 6×4 大柴 北奔 柴油 国三 4.8米','styleDriveMode':'5','styleName':'北奔NG80 (大柴) 290马力 (BF6M1013FC) (国三) (北奔) 6×4 4.8米 自卸式 自卸车 (ND3250B31)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':290,'gerrboxBrand':'49','id':180322433021828,'styleBulletinModel':'ND3250B38','styleDisname':'290马力 6×4 大柴 北奔 柴油 国三 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (大柴) 290马力 (BF6M1013FC) (国三) (北奔) 6×4 5.8米 自卸式 自卸车 (ND3250B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433025339,'styleBulletinModel':'ND3251B38J','styleDisname':'290马力 6×4 潍柴 法士特 柴油 国三 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 6×4 5.6米 后翻自卸式 自卸车 (ND3251B38J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433029074,'styleBulletinModel':'ND3311D41J','styleDisname':'290马力 8×4 潍柴 法士特 柴油 国三 7.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 8×4 7.5米 自卸式 自卸车 (ND3311D41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433029287,'styleBulletinModel':'ND3310D31J','styleDisname':'290马力 8×4 潍柴 法士特 柴油 国三 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 8×4 6.8米 后翻自卸式 自卸车 (ND3310D31J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433021822,'styleBulletinModel':'ND3251B41J','styleDisname':'300马力 6×4 潍柴 法士特 柴油 国三 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300N) (国三) (法士特) 6×4 5.6米 后翻自卸式 自卸车 (ND3251B41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433029077,'styleBulletinModel':'ND32501B38','styleDisname':'300马力 6×4 潍柴 法士特 柴油 国四 5.17米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 6×4 5.2米 自卸式 自卸车 (ND32501B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433025342,'styleBulletinModel':'ND5250ZLJZ03','styleDisname':'300马力 6×4 潍柴 法士特 柴油 国四 5.4米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 6×4 5.4米 自卸式 自卸车 (ND5250ZLJZ03)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433029296,'styleBulletinModel':'ND3251B35','styleDisname':'300马力 6×4 潍柴 法士特 柴油 国四 4.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 6×4 4.8米 自卸式 自卸车 (ND3251B35)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':300,'gerrboxBrand':'16','id':180322433029073,'styleBulletinModel':'ND3318D47J','styleDisname':'300马力 8×4 大柴 綦江 柴油 国三 9.42米','styleDriveMode':'9','styleName':'北奔NG80 (大柴) 300马力 (BF6M1013-30E3) (国三) (綦江) 8×4 9.4米 自卸式 自卸车 (ND3318D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433029298,'styleBulletinModel':'ND33101D37J','styleDisname':'300马力 8×4 潍柴 法士特 柴油 国四 7.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 8×4 7.4米 自卸式 自卸车 (ND33101D37J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433029281,'styleBulletinModel':'ND33100D31J','styleDisname':'300马力 8×4 潍柴 法士特 柴油 国四 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 8×4 6.8米 自卸式 自卸车 (ND33100D31J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433029471,'styleBulletinModel':'ND33101D37J','styleDisname':'300马力 8×4 潍柴 法士特 柴油 国四 7.6米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 8×4 7.6米 自卸式 自卸车 (ND33101D37J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':310,'gerrboxBrand':'4','id':180322433021821,'styleBulletinModel':'ND3251B44','styleDisname':'310马力 6×4 潍柴 法士特 柴油 国三 6.5米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 310马力 (WP10.310NE31) (国三) (法士特) 6×4 6.5米 后翻自卸式 自卸车 (ND3251B44)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':310,'gerrboxBrand':'4','id':180322433021832,'styleBulletinModel':'ND3314D29J','styleDisname':'310马力 6×4 潍柴 法士特 柴油 国三 6.2米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 310马力 (WP10.310NE31) (国三) (法士特) 6×4 6.2米 后翻自卸式 自卸车 (ND3314D29J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':310,'gerrboxBrand':'4','id':180322433029075,'styleBulletinModel':'ND3315D50J','styleDisname':'310马力 8×4 潍柴 法士特 柴油 国三 8.9米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 310马力 (WP10.310E32) (国三) (法士特) 8×4 8.9米 自卸式 自卸车 (ND3315D50J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433021818,'styleBulletinModel':'ND3252B38J','styleDisname':'325马力 6×4 上海日野 法士特 柴油 国三 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 6×4 5.6米 自卸式 自卸车 (ND3252B38J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433021835,'styleBulletinModel':'ND3251B34','styleDisname':'325马力 6×4 上海日野 法士特 柴油 国三 5.2米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 6×4 5.2米 自卸式 自卸车 (ND3251B34)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029290,'styleBulletinModel':'ND3311D29','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 6.4米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 6.4米 自卸式 自卸车 (ND3311D29)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029469,'styleBulletinModel':'ND3317D35J','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 6.8米 自卸式 自卸车 (ND3317D35J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029285,'styleBulletinModel':'ND3315D44J','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 8.1米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 8.1米 自卸式 自卸车 (ND3315D44J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029284,'styleBulletinModel':'ND3313D29J','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 6.2米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 6.2米 自卸式 自卸车 (ND3313D29J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029072,'styleBulletinModel':'ND3315D47J','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 8.5米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 8.5米 自卸式 自卸车 (ND3315D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029299,'styleBulletinModel':'ND3317D47J','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 9.42米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 9.4米 自卸式 自卸车 (ND3317D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433029291,'styleBulletinModel':'ND3311D35','styleDisname':'325马力 8×4 上海日野 法士特 柴油 国三 7米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 8×4 7.0米 自卸式 自卸车 (ND3311D35)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433025344,'styleBulletinModel':'ND3250B38J6Z00','styleDisname':'330马力 6×4 潍柴 法士特 液化天然气(LNG) 国四 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 330马力 (WP12NG330E40) (国四) (法士特) 6×4 5.6米 自卸式 自卸车 (ND3250B38J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433029466,'styleBulletinModel':'ND33103D46J','styleDisname':'330马力 8×4 潍柴 法士特 液化天然气(LNG) 国四 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 330马力 (WP12NG330E40) (国四) (法士特) 8×4 9.4米 侧翻自卸式 自卸车 (ND33103D46J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021838,'styleBulletinModel':'ND3251B47J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三 6.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336N) (国三) (法士特) 6×4 6.8米 后翻自卸式 自卸车 (ND3251B47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029456,'styleBulletinModel':'ND3254B50J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三 7.2米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 6×4 7.2米 后翻自卸式 自卸车 (ND3254B50J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021825,'styleBulletinModel':'ND3255B41J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三 6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336NE31) (国三) (法士特) 6×4 6.0米 后翻自卸式 自卸车 (ND3255B41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021829,'styleBulletinModel':'ND32502B38J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 5.4米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 5.4米 自卸式 自卸车 (ND32502B38J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021834,'styleBulletinModel':'ND32501B41','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 5.8米 自卸式 自卸车 (ND32501B41)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021817,'styleBulletinModel':'ND32500B45J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 6.5米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 6.5米 自卸式 自卸车 (ND32500B45J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':200401433032432,'styleBulletinModel':'ND5250ZLJZ04','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 5.6米 自卸式 自卸车 (ND5250ZLJZ04)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029282,'styleBulletinModel':'ND3319D35J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×4 6.8米 后翻自卸式 自卸车 (ND3319D35J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029288,'styleBulletinModel':'ND3310D46J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 8.6米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×4 8.6米 后翻自卸式 自卸车 (ND3310D46J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029472,'styleBulletinModel':'ND3311D41J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 7.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×4 7.5米 自卸式 自卸车 (ND3311D41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029467,'styleBulletinModel':'ND3315D44J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 8.1米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×4 8.1米 自卸式 自卸车 (ND3315D44J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029067,'styleBulletinModel':'ND33101D39J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国四 7.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 8×4 7.8米 自卸式 自卸车 (ND33101D39J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029065,'styleBulletinModel':'ND33101D31J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国四 6.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 8×4 6.8米 自卸式 自卸车 (ND33101D31J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433029303,'styleBulletinModel':'ND33103D28J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国四 6.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 8×4 6.4米 后翻自卸式 自卸车 (ND33103D28J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433025340,'styleBulletinModel':'2334 R','styleDisname':'340马力 6×4 潍柴 法士特 柴油 国三 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 340马力 (WP10.340E32) (国三) (法士特) 6×4 5.6米 自卸式 自卸车 (2334 R)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433025338,'styleBulletinModel':'ND3254B38','styleDisname':'340马力 6×4 潍柴 法士特 柴油 国三 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 340马力 (WP10.340E32) (国三) (法士特) 6×4 5.8米 自卸式 自卸车 (ND3254B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'88','engineMaxHorsepower':340,'gerrboxBrand':'49','id':180322433029070,'styleBulletinModel':'ND3311D29','styleDisname':'340马力 8×4 华柴 北奔 柴油 国三 6.4米','styleDriveMode':'9','styleName':'北奔NG80 (华柴) 340马力 (TCD2015V06) (国三) (北奔) 8×4 6.4米 自卸式 自卸车 (ND3311D29)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433029292,'styleBulletinModel':'ND33101D46J','styleDisname':'340马力 8×4 潍柴 法士特 柴油 国三 8.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 340马力 (WP10.340E32) (国三) (法士特) 8×4 8.5米 后翻自卸式 自卸车 (ND33101D46J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'88','engineMaxHorsepower':340,'gerrboxBrand':'49','id':180322433029462,'styleBulletinModel':'ND3317D47J','styleDisname':'340马力 8×4 华柴 北奔 柴油 国三 9.42米','styleDriveMode':'9','styleName':'北奔NG80 (华柴) 340马力 (TCD2015V06) (国三) (北奔) 8×4 9.4米 自卸式 自卸车 (ND3317D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'88','engineMaxHorsepower':340,'gerrboxBrand':'49','id':180322433029468,'styleBulletinModel':'ND3315D47J','styleDisname':'340马力 8×4 华柴 北奔 柴油 国三 8.2米','styleDriveMode':'9','styleName':'北奔NG80 (华柴) 340马力 (TCD2015V06) (国三) (北奔) 8×4 8.2米 自卸式 自卸车 (ND3315D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433029069,'styleBulletinModel':'ND33102D47J','styleDisname':'340马力 8×4 潍柴 法士特 柴油 国三 9.417米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 340马力 (WP10.340E32) (国三) (法士特) 8×4 9.4米 后翻自卸式 自卸车 (ND33102D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433021826,'styleBulletinModel':'ND3252B38J','styleDisname':'350马力 6×4 上海日野 法士特 柴油 国三 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 6×4 5.6米 自卸式 自卸车 (ND3252B38J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433021824,'styleBulletinModel':'ND3254B38','styleDisname':'350马力 6×4 上海日野 法士特 柴油 国三 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 6×4 5.8米 自卸式 自卸车 (ND3254B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433021823,'styleBulletinModel':'ND3251B34','styleDisname':'350马力 6×4 上海日野 法士特 柴油 国三 5.2米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 6×4 5.2米 自卸式 自卸车 (ND3251B34)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433025334,'styleBulletinModel':'ND3250BD5J6Z00','styleDisname':'350马力 6×4 潍柴 法士特 柴油 国五 5.4米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 6×4 5.4米 自卸式 自卸车 (ND3250BD5J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433025335,'styleBulletinModel':'ND3250BD5J6Z07','styleDisname':'350马力 6×4 潍柴 法士特 柴油 国五 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 6×4 5.6米 自卸式 自卸车 (ND3250BD5J6Z07)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433025333,'styleBulletinModel':'ND3250BD5J6Z08','styleDisname':'350马力 6×4 潍柴 法士特 柴油 国五 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 6×4 5.8米 自卸式 自卸车 (ND3250BD5J6Z08)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433021831,'styleBulletinModel':'ND3250B38J6Z00','styleDisname':'350马力 6×4 潍柴 法士特 液化天然气(LNG) 国四 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E40) (国四) (法士特) 6×4 5.6米 自卸式 自卸车 (ND3250B38J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029304,'styleBulletinModel':'ND3311D50J','styleDisname':'350马力 8×4 上海日野 法士特 柴油 国三 8.9米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 8×4 8.9米 自卸式 自卸车 (ND3311D50J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029297,'styleBulletinModel':'ND3314D41J','styleDisname':'350马力 8×4 上海日野 法士特 柴油 国三 7.5米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 8×4 7.5米 自卸式 自卸车 (ND3314D41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029293,'styleBulletinModel':'ND3317D35J','styleDisname':'350马力 8×4 上海日野 法士特 柴油 国三 7.2米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 8×4 7.2米 自卸式 自卸车 (ND3317D35J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029464,'styleBulletinModel':'ND3317D47J','styleDisname':'350马力 8×4 上海日野 法士特 柴油 国三 9.42米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 8×4 9.4米 自卸式 自卸车 (ND3317D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029470,'styleBulletinModel':'ND3313D29J','styleDisname':'350马力 8×4 上海日野 法士特 柴油 国三 6.2米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 8×4 6.2米 自卸式 自卸车 (ND3313D29J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029071,'styleBulletinModel':'ND3315D47J','styleDisname':'350马力 8×4 上海日野 法士特 柴油 国三 8.5米','styleDriveMode':'9','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 8×4 8.5米 自卸式 自卸车 (ND3315D47J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433025323,'styleBulletinModel':'ND3310DD5J6Z00','styleDisname':'350马力 8×4 潍柴 法士特 柴油 国五 6.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 8×4 6.5米 自卸式 自卸车 (ND3310DD5J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433025324,'styleBulletinModel':'ND3310DD5J6Z02','styleDisname':'350马力 8×4 潍柴 法士特 柴油 国五 7.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 8×4 7.4米 自卸式 自卸车 (ND3310DD5J6Z02)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433027432,'styleBulletinModel':'ND3310DD5J6Z04','styleDisname':'350马力 8×4 潍柴 法士特 柴油 国五 7.2米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 8×4 7.2米 自卸式 自卸车 (ND3310DD5J6Z04)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433029301,'styleBulletinModel':'ND33103D46J','styleDisname':'350马力 8×4 潍柴 法士特 液化天然气(LNG) 国四 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E40) (国四) (法士特) 8×4 9.4米 侧翻自卸式 自卸车 (ND33103D46J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433029458,'styleBulletinModel':'ND3253B44J','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国三 6.2米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP10.375) (国三) (法士特) 6×4 6.2米 后翻自卸式 自卸车 (ND3253B44J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433025330,'styleBulletinModel':'ND3250BD5J6Z00','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国五 5.4米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 6×4 5.4米 自卸式 自卸车 (ND3250BD5J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433025332,'styleBulletinModel':'ND5250ZLJZ13','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国五 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 6×4 5.6米 自卸式 自卸车 (ND5250ZLJZ13)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':191203433027698,'styleBulletinModel':'ND5250ZLJZ04','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国四 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×4 5.6米 自卸式 自卸车 (ND5250ZLJZ04)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433025343,'styleBulletinModel':'ND32501B41J','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国四 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×4 5.8米 自卸式 自卸车 (ND32501B41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433021830,'styleBulletinModel':'ND32502B38','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国四 5.4米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×4 5.4米 自卸式 自卸车 (ND32502B38)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433029078,'styleBulletinModel':'ND3314D41J','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国三 7.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP10.375) (国三) (法士特) 8×4 7.5米 自卸式 自卸车 (ND3314D41J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433025321,'styleBulletinModel':'ND3310DD5J6Z03','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国五 7.6米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 8×4 7.6米 自卸式 自卸车 (ND3310DD5J6Z03)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433027431,'styleBulletinModel':'ND3310DD5J6Z05','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国五 7.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 8×4 7.8米 自卸式 自卸车 (ND3310DD5J6Z05)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433025328,'styleBulletinModel':'ND3310DD5J6Z00','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国五 6.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 8×4 6.5米 自卸式 自卸车 (ND3310DD5J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':190228433011622,'styleBulletinModel':'ND3310DD5J6Z04','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国五 7.2米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 8×4 7.2米 自卸式 自卸车 (ND3310DD5J6Z04)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433027429,'styleBulletinModel':'ND3310DD5J6Z01','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国五 8.6米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 8×4 8.6米 自卸车 (ND3310DD5J6Z01)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433027430,'styleBulletinModel':'ND3310DD5J6Z02','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国五 7.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 8×4 7.4米 自卸式 自卸车 (ND3310DD5J6Z02)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433029289,'styleBulletinModel':'ND33104D46J','styleDisname':'375马力 8×4 潍柴 法士特 柴油 国四 8.6米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 8×4 8.6米 自卸式 自卸车 (ND33104D46J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433025331,'styleBulletinModel':'ND5250ZLJZ11','styleDisname':'380马力 6×4 潍柴 法士特 液化天然气(LNG) 国五 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E51) (国五) (法士特) 6×4 5.6米 自卸式 自卸车 (ND5250ZLJZ11)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':190326433012905,'styleBulletinModel':'ND5250ZLJZ11','styleDisname':'380马力 6×4 潍柴 法士特 液化天然气(LNG) 国五 5.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E51) (国五) (法士特) 6×4 5.8米 自卸式 自卸车 (ND5250ZLJZ11)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433029455,'styleBulletinModel':'ND3250B38J6Z00','styleDisname':'380马力 6×4 潍柴 法士特 液化天然气(LNG) 国四 5.6米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E40) (国四) (法士特) 6×4 5.6米 自卸式 自卸车 (ND3250B38J6Z00)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433029295,'styleBulletinModel':'ND33100D39J','styleDisname':'380马力 8×4 潍柴 法士特 柴油 国三 7.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 380马力 (WP10.380E32) (国三) (法士特) 8×4 7.8米 后翻自卸式 自卸车 (ND33100D39J)','stylePurposeId':71,'stylePurposeName':'自卸车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433029463,'styleBulletinModel':'ND33103D46J','styleDisname':'380马力 8×4 潍柴 法士特 液化天然气(LNG) 国四 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E40) (国四) (法士特) 8×4 9.4米 侧翻自卸式 自卸车 (ND33103D46J)','stylePurposeId':71,'stylePurposeName':'自卸车'}],'73':[{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':180,'gerrboxBrand':'7','id':180322433024339,'styleBulletinModel':'ND1160A41','styleDisname':'180马力 4×2 潍柴 大齿 柴油 国三 5.43米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 180马力 (WP6.180) (国三) (大齿) 4×2 5.4米 单排 栏板式 载货车 (ND1160A41)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':199,'gerrboxBrand':'4','id':180322433023248,'styleBulletinModel':'ND5313CXYZ','styleDisname':'199马力 8×2 潍柴 法士特 柴油 国三 9.417米','styleDriveMode':'7','styleName':'北奔NG80 (潍柴) 199马力 (WP7.240E30) (国三) (法士特) 8×2 9.4米 排半 仓栅式 载货车 (ND5313CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':210,'gerrboxBrand':'4','id':180322433024347,'styleBulletinModel':'ND5160XXYZ04','styleDisname':'210马力 4×2 潍柴 法士特 柴油 国三 7.45米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 210马力 (WP7.210E30) (国三) (法士特) 4×2 7.5米 单排 厢式 载货车 (ND5160XXYZ04)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':210,'gerrboxBrand':'10','id':180322433024350,'styleBulletinModel':'ND11600A41','styleDisname':'210马力 4×2 潍柴 采埃孚 柴油 国四 5.475米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 210马力 (WP7.210E40) (国四) (采埃孚) 4×2 5.5米 单排 栏板式 载货车 (ND11600A41)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'14','engineMaxHorsepower':220,'gerrboxBrand':'49','id':180322433024353,'styleBulletinModel':'ND12500L55J','styleDisname':'220马力 6×2 锡柴 北奔 柴油 国三 9.45米','styleDriveMode':'3','styleName':'北奔NG80 (锡柴) 220马力 (CA6DF3-22E3F) (国三) (北奔) 6×2 9.4米 排半 栏板式 载货车 (ND12500L55J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'14','engineMaxHorsepower':220,'gerrboxBrand':'49','id':180322433023246,'styleBulletinModel':'ND13100K44J','styleDisname':'220马力 8×2 锡柴 北奔 柴油 国三 9.45米','styleDriveMode':'7','styleName':'北奔NG80 (锡柴) 220马力 (CA6DF3-22E3F) (国三) (北奔) 8×2 9.4米 排半 栏板式 载货车 (ND13100K44J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'14','engineMaxHorsepower':220,'gerrboxBrand':'49','id':180322433023237,'styleBulletinModel':'ND13114D44J','styleDisname':'220马力 8×4 锡柴 北奔 柴油 国三 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (锡柴) 220马力 (CA6DF3-22E3F) (国三) (北奔) 8×4 9.4米 排半 栏板式 载货车 (ND13114D44J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':240,'gerrboxBrand':'4','id':180322433024356,'styleBulletinModel':'ND5245CXYZ','styleDisname':'240马力 6×2 潍柴 法士特 柴油 国三 9.417米','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 240马力 (WP7.240E30) (国三) (法士特) 6×2 9.4米 排半 仓栅式 载货车 (ND5245CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':240,'gerrboxBrand':'4','id':180322433024357,'styleBulletinModel':'ND5240XXYZ','styleDisname':'240马力 6×2 潍柴 法士特 柴油 国三 9.4米','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 240马力 (WP7.240E30) (国三) (法士特) 6×2 9.4米 排半 厢式 载货车 (ND5240XXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'14','engineMaxHorsepower':240,'gerrboxBrand':'4','id':180322433023249,'styleBulletinModel':'ND5310XXYZ01','styleDisname':'240马力 8×2 锡柴 法士特 柴油 国三 9.5米','styleDriveMode':'7','styleName':'北奔NG80 (锡柴) 240马力 (CA6DF3-24E3) (国三) (法士特) 8×2 9.5米 排半 厢式 载货车 (ND5310XXYZ01)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'14','engineMaxHorsepower':260,'gerrboxBrand':'49','id':180322433023235,'styleBulletinModel':'ND5311XXYZ','styleDisname':'260马力 8×4 锡柴 北奔 柴油 国三 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (锡柴) 260马力 (CA6DF3-26E3F) (国三) (北奔) 8×4 9.4米 排半 厢式 载货车 (ND5311XXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433024340,'styleBulletinModel':'ND1161A55J','styleDisname':'270马力 4×2 潍柴 法士特 柴油 国三 6.4米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270N) (国三) (法士特) 4×2 6.4米 排半 栏板式 载货车 (ND1161A55J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433024349,'styleBulletinModel':'ND1160A45J','styleDisname':'270马力 4×2 潍柴 法士特 柴油 国三 5.53米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270) (国三) (法士特) 4×2 5.5米 排半 栏板式 载货车 (ND1160A45J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433024351,'styleBulletinModel':'ND1165A48J','styleDisname':'270马力 4×2 潍柴 法士特 柴油 国四 5.5米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (法士特) 4×2 5.5米 排半 栏板式 载货车 (ND1165A48J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'10','id':180322433024344,'styleBulletinModel':'ND11602A48J','styleDisname':'270马力 4×2 潍柴 采埃孚 柴油 国四 6.27米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (采埃孚) 4×2 6.3米 排半 栏板式 载货车 (ND11602A48J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'49','id':180322433024355,'styleBulletinModel':'ND5247CXYZ','styleDisname':'270马力 6×2 潍柴 北奔 柴油 国三 9.417米','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270) (国三) (北奔) 6×2 9.4米 排半 仓栅式 载货车 (ND5247CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433021101,'styleBulletinModel':'ND1250B59J','styleDisname':'270马力 6×4 潍柴 法士特 柴油 国三 7.8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270) (国三) (法士特) 6×4 7.8米 排半 栏板式 载货车 (ND1250B59J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'49','id':180322433023242,'styleBulletinModel':'ND5317CXYZ','styleDisname':'270马力 8×4 潍柴 北奔 柴油 国三 9.417米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270) (国三) (北奔) 8×4 9.4米 排半 仓栅式 载货车 (ND5317CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'49','id':180322433023243,'styleBulletinModel':'ND5311XXYZ','styleDisname':'270马力 8×4 潍柴 北奔 柴油 国三 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP7.270E30) (国三) (北奔) 8×4 9.4米 排半 厢式 载货车 (ND5311XXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433023241,'styleBulletinModel':'ND1315D41J','styleDisname':'270马力 8×4 潍柴 法士特 柴油 国三 9.01米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270) (国三) (法士特) 8×4 9.0米 排半 栏板式 载货车 (ND1315D41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'10','id':180322433023245,'styleBulletinModel':'ND5310XXYZ07','styleDisname':'270马力 8×4 潍柴 采埃孚 柴油 国四 9.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (采埃孚) 8×4 9.5米 排半 厢式 载货车 (ND5310XXYZ07)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':280,'gerrboxBrand':'4','id':180322433021103,'styleBulletinModel':'ND1259B41J','styleDisname':'280马力 6×4 潍柴 法士特 天然气(LNG/CNG) 国四 6.5米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 280马力 (WP10NG280E40) (国四) (法士特) 6×4 6.5米 排半 栏板式 载货车 (ND1259B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':280,'gerrboxBrand':'4','id':180322433023252,'styleBulletinModel':'ND11602B41J','styleDisname':'280马力 6×4 潍柴 法士特 天然气(LNG/CNG) 国四 6.2米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 280马力 (WP10NG280E40) (国四) (法士特) 6×4 6.2米 排半 栏板式 载货车 (ND11602B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433024345,'styleBulletinModel':'ND11601A48J','styleDisname':'290马力 4×2 潍柴 法士特 柴油 国三 6.2米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290NE31) (国三) (法士特) 4×2 6.2米 排半 栏板式 载货车 (ND11601A48J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433024346,'styleBulletinModel':'ND1163A48J','styleDisname':'290马力 4×2 潍柴 法士特 柴油 国三 6.23米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 4×2 6.2米 排半 栏板式 载货车 (ND1163A48J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433023238,'styleBulletinModel':'ND5319CCYZ','styleDisname':'290马力 8×4 潍柴 法士特 柴油 国三 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 8×4 9.4米 排半 仓栅式 载货车 (ND5319CCYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433024352,'styleBulletinModel':'ND1167A48','styleDisname':'300马力 4×2 潍柴 法士特 柴油 国三 6.53米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300N) (国三) (法士特) 4×2 6.5米 单排 栏板式 载货车 (ND1167A48)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433024348,'styleBulletinModel':'ND1165A48J','styleDisname':'300马力 4×2 潍柴 法士特 柴油 国四 5.5米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 4×2 5.5米 排半 栏板式 载货车 (ND1165A48J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'10','id':180322433024343,'styleBulletinModel':'ND11602A48J','styleDisname':'300马力 4×2 潍柴 采埃孚 柴油 国四 6.27米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (采埃孚) 4×2 6.3米 排半 栏板式 载货车 (ND11602A48J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433023250,'styleBulletinModel':'ND1250BG5J6Z00','styleDisname':'300马力 6×4 潍柴 法士特 天然气(LNG/CNG) 国五 8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10NG300E50) (国五) (法士特) 6×4 8.0米 排半 底盘 载货车 (ND1250BG5J6Z00)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433023253,'styleBulletinModel':'ND1259B41J','styleDisname':'300马力 6×4 潍柴 法士特 天然气(LNG/CNG) 国四 6.5米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10NG300E40) (国四) (法士特) 6×4 6.5米 排半 栏板式 载货车 (ND1259B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433021105,'styleBulletinModel':'ND11602B41J','styleDisname':'300马力 6×4 潍柴 法士特 天然气(LNG/CNG) 国四 6.2米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 300马力 (WP10NG300E40) (国四) (法士特) 6×4 6.2米 排半 栏板式 载货车 (ND11602B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'49','id':180322433023236,'styleBulletinModel':'ND5311CXYZ','styleDisname':'300马力 8×4 潍柴 北奔 柴油 国三 9.417米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 300马力 (WP7.300E30) (国三) (北奔) 8×4 9.4米 排半 仓栅式 载货车 (ND5311CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'10','id':180322433024359,'styleBulletinModel':'ND5310XXYZ07','styleDisname':'300马力 8×4 潍柴 采埃孚 柴油 国四 9.5米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (采埃孚) 8×4 9.5米 排半 厢式 载货车 (ND5310XXYZ07)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':310,'gerrboxBrand':'4','id':180322433024360,'styleBulletinModel':'ND5314CXYZ','styleDisname':'310马力 8×4 潍柴 法士特 柴油 国三 9.4米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 310马力 (WP10.310E32) (国三) (法士特) 8×4 9.4米 排半 仓栅式 载货车 (ND5314CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':326,'gerrboxBrand':'4','id':180322433024342,'styleBulletinModel':'ND1160A55J','styleDisname':'326马力 4×2 上海日野 法士特 柴油 国三 6.4米','styleDriveMode':'1','styleName':'北奔NG80 (上海日野) 326马力 (P11C-UH) (国三) (法士特) 4×2 6.4米 排半 栏板式 载货车 (ND1160A55J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':326,'gerrboxBrand':'4','id':180322433023256,'styleBulletinModel':'ND1252B56J','styleDisname':'326马力 6×4 上海日野 法士特 柴油 国三 9米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 326马力 (P11C-UH) (国三) (法士特) 6×4 9.0米 排半 栏板式 载货车 (ND1252B56J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433024341,'styleBulletinModel':'ND1161A45J','styleDisname':'336马力 4×2 潍柴 法士特 柴油 国三 5.53米','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 4×2 5.5米 排半 栏板式 载货车 (ND1161A45J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433023255,'styleBulletinModel':'ND5254XXYZ','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三 6.9米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336N) (国三) (法士特) 6×4 6.9米 排半 厢式 载货车 (ND5254XXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433023251,'styleBulletinModel':'ND1258B38J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三 6.3米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 6×4 6.3米 排半 栏板式 载货车 (ND1258B38J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021100,'styleBulletinModel':'ND1255B50J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三 8米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336NE31) (国三) (法士特) 6×4 8.0米 排半 栏板式 载货车 (ND1255B50J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021104,'styleBulletinModel':'ND12502B41J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 6.5米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 6.5米 排半 栏板式 载货车 (ND12502B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021099,'styleBulletinModel':'ND11604B41J','styleDisname':'336马力 6×4 潍柴 法士特 天然气(LNG/CNG) 国四 6.2米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10NG336E40) (国四) (法士特) 6×4 6.2米 排半 栏板式 载货车 (ND11604B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433021097,'styleBulletinModel':'ND12505B38J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四 6.25米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 6.3米 排半 栏板式 载货车 (ND12505B38J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433023247,'styleBulletinModel':'ND5318CXYZ','styleDisname':'336马力 8×2 潍柴 法士特 柴油 国三 9.417米','styleDriveMode':'7','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×2 9.4米 排半 仓栅式 载货车 (ND5318CXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433023233,'styleBulletinModel':'ND13110D44J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 9.3米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×4 9.3米 排半 栏板式 载货车 (ND13110D44J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433023239,'styleBulletinModel':'ND13102D44J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国三 8.9米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 8×4 8.9米 排半 栏板式 载货车 (ND13102D44J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433024358,'styleBulletinModel':'ND1316D41J','styleDisname':'336马力 8×4 潍柴 法士特 柴油 国四 9米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 8×4 9.0米 单排 栏板式 载货车 (ND1316D41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433023254,'styleBulletinModel':'ND1252B44','styleDisname':'350马力 6×4 上海日野 法士特 柴油 国三 7.23米','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 6×4 7.2米 排半 栏板式 载货车 (ND1252B44)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433024337,'styleBulletinModel':'ND1250BD5J6Z01','styleDisname':'350马力 6×4 潍柴 法士特 柴油 国五 9.4米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 6×4 9.4米 排半 栏板式 载货车 (ND1250BD5J6Z01)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433021098,'styleBulletinModel':'ND12502B41J','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国四 6.5米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×4 6.5米 排半 栏板式 载货车 (ND12502B41J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433021102,'styleBulletinModel':'ND12505B38J','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国四 6.25米','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×4 6.3米 排半 栏板式 载货车 (ND12505B38J)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433023234,'styleBulletinModel':'ND5313XXYZ','styleDisname':'380马力 8×4 潍柴 法士特 柴油 国三 8.3米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 380马力 (WP10.380E32) (国三) (法士特) 8×4 8.3米 排半 厢式 载货车 (ND5313XXYZ)','stylePurposeId':73,'stylePurposeName':'载货车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433023244,'styleBulletinModel':'ND1312D41J','styleDisname':'380马力 8×4 潍柴 法士特 柴油 国三 8.8米','styleDriveMode':'9','styleName':'北奔NG80 (潍柴) 380马力 (WP10.380E32) (国三) (法士特) 8×4 8.8米 排半 栏板式 载货车 (ND1312D41J)','stylePurposeId':73,'stylePurposeName':'载货车'}],'63':[{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':260,'gerrboxBrand':'16','id':180322433008178,'styleBulletinModel':'ND4187A38J','styleDisname':'260马力 4×2 大柴 綦江 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (大柴) 260马力 (BF6M1013-26E3) (国三) (綦江) 4×2 排半 牵引车 (ND4187A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':260,'gerrboxBrand':'16','id':180322433007767,'styleBulletinModel':'ND4242L25J','styleDisname':'260马力 6×2 大柴 綦江 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (大柴) 260马力 (BF6M1013-26E3) (国三) (綦江) 6×2 排半 牵引车 (ND4242L25J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':270,'gerrboxBrand':'4','id':180322433008184,'styleBulletinModel':'ND41804A35J','styleDisname':'270马力 4×2 潍柴 法士特 柴油 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 270马力 (WP10.270E40) (国四) (法士特) 4×2 排半 牵引车 (ND41804A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':280,'gerrboxBrand':'16','id':180322433008179,'styleBulletinModel':'ND4187A38J','styleDisname':'280马力 4×2 大柴 綦江 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (大柴) 280马力 (BF6M1013-28E3) (国三) (綦江) 4×2 排半 牵引车 (ND4187A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':280,'gerrboxBrand':'16','id':180322433007765,'styleBulletinModel':'ND4242L25J','styleDisname':'280马力 6×2 大柴 綦江 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (大柴) 280马力 (BF6M1013-28E3) (国三) (綦江) 6×2 排半 牵引车 (ND4242L25J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433008177,'styleBulletinModel':'ND4182A35J','styleDisname':'290马力 4×2 潍柴 法士特 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 4×2 排半 牵引车 (ND4182A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':290,'gerrboxBrand':'4','id':180322433007770,'styleBulletinModel':'ND4242L25J','styleDisname':'290马力 6×2 潍柴 法士特 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 290马力 (WP10.290) (国三) (法士特) 6×2 排半 牵引车 (ND4242L25J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':300,'gerrboxBrand':'16','id':180322433008174,'styleBulletinModel':'ND4187A38J','styleDisname':'300马力 4×2 大柴 綦江 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (大柴) 300马力 (BF6M1013-30E3) (国三) (綦江) 4×2 排半 牵引车 (ND4187A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433007969,'styleBulletinModel':'ND41803A35J','styleDisname':'300马力 4×2 潍柴 法士特 柴油 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 300马力 (WP10.300E40) (国四) (法士特) 4×2 排半 牵引车 (ND41803A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433007970,'styleBulletinModel':'ND41800A38J','styleDisname':'300马力 4×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 300马力 (WP10NG300E40) (国四) (法士特) 4×2 排半 牵引车 (ND41800A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'11','engineMaxHorsepower':300,'gerrboxBrand':'16','id':180322433007768,'styleBulletinModel':'ND4242L25J','styleDisname':'300马力 6×2 大柴 綦江 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (大柴) 300马力 (BF6M1013-30E3) (国三) (綦江) 6×2 排半 牵引车 (ND4242L25J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':300,'gerrboxBrand':'4','id':180322433007773,'styleBulletinModel':'ND42400L27J','styleDisname':'300马力 6×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 300马力 (WP10NG300E40) (国四) (法士特) 6×2 排半 牵引车 (ND42400L27J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':310,'gerrboxBrand':'4','id':180322433007766,'styleBulletinModel':'ND4240L23J7Z00','styleDisname':'310马力 6×2 潍柴 法士特 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 310马力 (WP10.310E32) (国三) (法士特) 6×2 排半 牵引车 (ND4240L23J7Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'28','engineMaxHorsepower':320,'gerrboxBrand':'4','id':180322433007755,'styleBulletinModel':'ND4251B38J','styleDisname':'320马力 6×4 上柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (上柴) 320马力 (SC9DT320Q3) (国三) (法士特) 6×4 排半 牵引车 (ND4251B38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':325,'gerrboxBrand':'4','id':180322433008180,'styleBulletinModel':'ND4181A35J','styleDisname':'325马力 4×2 上海日野 法士特 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (上海日野) 325马力 (P11C-UH) (国三) (法士特) 4×2 排半 牵引车 (ND4181A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':326,'gerrboxBrand':'4','id':180322433007979,'styleBulletinModel':'ND4257B34J','styleDisname':'326马力 6×4 上海日野 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (上海日野) 326马力 (P11C-UH) (国三) (法士特) 6×4 排半 牵引车 (ND4257B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433007971,'styleBulletinModel':'ND41800A38J','styleDisname':'330马力 4×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 330马力 (WP12NG330E40) (国四) (法士特) 4×2 排半 牵引车 (ND41800A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433007774,'styleBulletinModel':'ND42400L27J','styleDisname':'330马力 6×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 330马力 (WP12NG330E40) (国四) (法士特) 6×2 排半 牵引车 (ND42400L27J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433007990,'styleBulletinModel':'ND42506B34J','styleDisname':'330马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 330马力 (WP12.330) (国三) (法士特) 6×4 排半 牵引车 (ND42506B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433008172,'styleBulletinModel':'ND4250B38J6Z00','styleDisname':'330马力 6×4 潍柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 330马力 (WP12NG330E50) (国五) (法士特) 6×4 排半 牵引车 (ND4250B38J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':330,'gerrboxBrand':'4','id':180322433007984,'styleBulletinModel':'ND42502B38J','styleDisname':'330马力 6×4 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 330马力 (WP12NG330E40) (国四) (法士特) 6×4 排半 牵引车 (ND42502B38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433008182,'styleBulletinModel':'ND4181A35J','styleDisname':'336马力 4×2 潍柴 法士特 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 4×2 排半 牵引车 (ND4181A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':200310433031394,'styleBulletinModel':'ND41804A35J','styleDisname':'336马力 4×2 潍柴 法士特 柴油 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 4×2 牵引车 (ND41804A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007972,'styleBulletinModel':'ND41800A38J','styleDisname':'336马力 4×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 336马力 (WP10NG336E40) (国四) (法士特) 4×2 排半 牵引车 (ND41800A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007763,'styleBulletinModel':'ND4243L25J','styleDisname':'336马力 6×2 潍柴 法士特 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336N) (国三) (法士特) 6×2 排半 牵引车 (ND4243L25J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007775,'styleBulletinModel':'ND42400L27J','styleDisname':'336马力 6×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 336马力 (WP10NG336E40) (国四) (法士特) 6×2 排半 牵引车 (ND42400L27J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007764,'styleBulletinModel':'ND42402L23J','styleDisname':'336马力 6×2 潍柴 法士特 柴油 国四','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×2 排半 牵引车 (ND42402L23J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007985,'styleBulletinModel':'ND4257B34J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336) (国三) (法士特) 6×4 排半 牵引车 (ND4257B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433008170,'styleBulletinModel':'ND4250B38J6Z00','styleDisname':'336马力 6×4 潍柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10NG336E50) (国五) (法士特) 6×4 排半 牵引车 (ND4250B38J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007975,'styleBulletinModel':'ND42507B32J','styleDisname':'336马力 6×4 潍柴 法士特 柴油 国四','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10.336E40) (国四) (法士特) 6×4 排半 牵引车 (ND42507B32J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':336,'gerrboxBrand':'4','id':180322433007987,'styleBulletinModel':'ND42502B38J','styleDisname':'336马力 6×4 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 336马力 (WP10NG336E40) (国四) (法士特) 6×4 排半 牵引车 (ND42502B38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'9','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433000863,'styleBulletinModel':'ND4180A38J6Z01','styleDisname':'340马力 4×2 玉柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'1','styleName':'北奔NG80 (玉柴) 340马力 (YC6MK340N-50) (国五) (法士特) 4×2 排半 牵引车 (ND4180A38J6Z01)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'9','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433008162,'styleBulletinModel':'ND4240L27J6Z00','styleDisname':'340马力 6×2 玉柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'3','styleName':'北奔NG80 (玉柴) 340马力 (YC6MK340N-50) (国五) (法士特) 6×2 排半 牵引车 (ND4240L27J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'88','engineMaxHorsepower':340,'gerrboxBrand':'49','id':180322433007976,'styleBulletinModel':'ND4257B34J','styleDisname':'340马力 6×4 华柴 北奔 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (华柴) 340马力 (TCD2015V06) (国三) (北奔) 6×4 排半 牵引车 (ND4257B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433007986,'styleBulletinModel':'ND42502B32J','styleDisname':'340马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 340马力 (WP10.340E32) (国三) (法士特) 6×4 排半 牵引车 (ND42502B32J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'9','engineMaxHorsepower':340,'gerrboxBrand':'4','id':180322433008173,'styleBulletinModel':'ND4250B38J6Z00','styleDisname':'340马力 6×4 玉柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'5','styleName':'北奔NG80 (玉柴) 340马力 (YC6MK340N-50) (国五) (法士特) 6×4 排半 牵引车 (ND4250B38J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433008181,'styleBulletinModel':'ND4181A35J','styleDisname':'350马力 4×2 上海日野 法士特 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 4×2 排半 牵引车 (ND4181A35J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433007973,'styleBulletinModel':'ND41800A38J','styleDisname':'350马力 4×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E40) (国四) (法士特) 4×2 排半 牵引车 (ND41800A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'42','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433007769,'styleBulletinModel':'ND4244L25J','styleDisname':'350马力 6×2 上海日野 法士特 柴油 国三','styleDriveMode':'3','styleName':'北奔NG80 (上海日野) 350马力 (P11C-UJ) (国三) (法士特) 6×2 排半 牵引车 (ND4244L25J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433007776,'styleBulletinModel':'ND42400L27J','styleDisname':'350马力 6×2 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E40) (国四) (法士特) 6×2 排半 牵引车 (ND42400L27J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433008171,'styleBulletinModel':'ND4250B38J6Z00','styleDisname':'350马力 6×4 潍柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E50) (国五) (法士特) 6×4 排半 牵引车 (ND4250B38J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433008166,'styleBulletinModel':'ND4250BD5J7Z05','styleDisname':'350马力 6×4 潍柴 法士特 柴油 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP10.350E53) (国五) (法士特) 6×4 排半 牵引车 (ND4250BD5J7Z05)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':350,'gerrboxBrand':'4','id':180322433007991,'styleBulletinModel':'ND42502B38J','styleDisname':'350马力 6×4 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 350马力 (WP12NG350E40) (国四) (法士特) 6×4 排半 牵引车 (ND42502B38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':360,'gerrboxBrand':'4','id':180322433008176,'styleBulletinModel':'ND4183A38J','styleDisname':'360马力 4×2 潍柴 法士特 柴油 国三','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 360马力 (WD615.46) (国三) (法士特) 4×2 排半 牵引车 (ND4183A38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'88','engineMaxHorsepower':370,'gerrboxBrand':'4','id':180322433007992,'styleBulletinModel':'ND4257B34J','styleDisname':'370马力 6×4 华柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (华柴) 370马力 (TCD2015V06) (国三) (法士特) 6×4 排半 牵引车 (ND4257B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'9','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433000864,'styleBulletinModel':'ND4180A38J6Z01','styleDisname':'375马力 4×2 玉柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'1','styleName':'北奔NG80 (玉柴) 375马力 (YC6MK375N-50) (国五) (法士特) 4×2 排半 牵引车 (ND4180A38J6Z01)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'9','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433008163,'styleBulletinModel':'ND4240L27J6Z00','styleDisname':'375马力 6×2 玉柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'3','styleName':'北奔NG80 (玉柴) 375马力 (YC6MK375N-50) (国五) (法士特) 6×2 排半 牵引车 (ND4240L27J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433007772,'styleBulletinModel':'ND42402L23J','styleDisname':'375马力 6×2 潍柴 法士特 柴油 国四','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×2 排半 牵引车 (ND42402L23J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433007753,'styleBulletinModel':'ND4250B31J','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP10.375) (国三) (法士特) 6×4 排半 牵引车 (ND4250B31J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'9','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433008167,'styleBulletinModel':'ND4250B38J6Z00','styleDisname':'375马力 6×4 玉柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'5','styleName':'北奔NG80 (玉柴) 375马力 (YC6MK375N-50) (国五) (法士特) 6×4 排半 牵引车 (ND4250B38J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433008165,'styleBulletinModel':'ND4250BD5J6Z01','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E50) (国五) (法士特) 6×4 排半 牵引车 (ND4250BD5J6Z01)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':375,'gerrboxBrand':'4','id':180322433007978,'styleBulletinModel':'ND42510B34J','styleDisname':'375马力 6×4 潍柴 法士特 柴油 国四','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 375马力 (WP12.375E40) (国四) (法士特) 6×4 排半 牵引车 (ND42510B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433000862,'styleBulletinModel':'ND4180A38J6Z01','styleDisname':'380马力 4×2 潍柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'1','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E50) (国五) (法士特) 4×2 排半 牵引车 (ND4180A38J6Z01)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433008161,'styleBulletinModel':'ND4240L27J6Z00','styleDisname':'380马力 6×2 潍柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'3','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E50) (国五) (法士特) 6×2 排半 牵引车 (ND4240L27J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433007977,'styleBulletinModel':'ND4250B32J','styleDisname':'380马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP10.380E32) (国三) (法士特) 6×4 单排 牵引车 (ND4250B32J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433008164,'styleBulletinModel':'ND4250B38J6Z00','styleDisname':'380马力 6×4 潍柴 法士特 液化天然气(LNG) 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E50) (国五) (法士特) 6×4 排半 牵引车 (ND4250B38J6Z00)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':3,'engineBrand':'6','engineMaxHorsepower':380,'gerrboxBrand':'4','id':180322433007982,'styleBulletinModel':'ND42502B38J','styleDisname':'380马力 6×4 潍柴 法士特 液化天然气(LNG) 国四','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 380马力 (WP12NG380E40) (国四) (法士特) 6×4 排半 牵引车 (ND42502B38J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':400,'gerrboxBrand':'4','id':180322433007981,'styleBulletinModel':'ND4253B34J','styleDisname':'400马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 400马力 (WP12.400E32) (国三) (法士特) 6×4 排半 牵引车 (ND4253B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'88','engineMaxHorsepower':408,'gerrboxBrand':'4','id':180322433007983,'styleBulletinModel':'ND4257B34J','styleDisname':'408马力 6×4 华柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (华柴) 408马力 (TCD2015V06) (国三) (法士特) 6×4 排半 牵引车 (ND4257B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':420,'gerrboxBrand':'4','id':180322433007989,'styleBulletinModel':'ND42509B32J','styleDisname':'420马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 420马力 (WP10.420E32) (国三) (法士特) 6×4 排半 牵引车 (ND42509B32J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':430,'gerrboxBrand':'4','id':180322433008169,'styleBulletinModel':'ND4250BD5J7Z06','styleDisname':'430马力 6×4 潍柴 法士特 柴油 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 430马力 (WP12.430E50) (国五) (法士特) 6×4 牵引车 (ND4250BD5J7Z06)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':2,'engineBrand':'6','engineMaxHorsepower':480,'gerrboxBrand':'4','id':180322433007980,'styleBulletinModel':'ND4253B34J','styleDisname':'480马力 6×4 潍柴 法士特 柴油 国三','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 480马力 (WP12.480) (国三) (法士特) 6×4 排半 牵引车 (ND4253B34J)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':480,'gerrboxBrand':'4','id':180322433008168,'styleBulletinModel':'ND4250BD5J7Z06','styleDisname':'480马力 6×4 潍柴 法士特 柴油 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 480马力 (WP13.480E501) (国五) (法士特) 6×4 牵引车 (ND4250BD5J7Z06)','stylePurposeId':63,'stylePurposeName':'牵引车'},{'emissionStandardId':4,'engineBrand':'6','engineMaxHorsepower':550,'gerrboxBrand':'4','id':180828433007104,'styleBulletinModel':'ND4250BD5J7Z06','styleDisname':'550马力 6×4 潍柴 法士特 柴油 国五','styleDriveMode':'5','styleName':'北奔NG80 (潍柴) 550马力 (WP13.550E501) (国五) (法士特) 6×4 牵引车 (ND4250BD5J7Z06)','stylePurposeId':63,'stylePurposeName':'牵引车'}]}},'info':'获取数据成功！','success':1}");
        JSONObject jsonObject = JSONObject.parseObject(sb.toString());
        Map<String, Object> stringObjectMap = WxService.parseJSON2Map(jsonObject);
        Map<String, Object> dataMap = (Map)stringObjectMap.get("data");
        List cartypeList = (List)dataMap.get("cartype");

        for (int i = 0; i < cartypeList.size(); i++) {
            Map cartypeMap = (Map)cartypeList.get(i);
            String id = ObjectUtil.getString(cartypeMap.get("id"));
            String name = ObjectUtil.getString(cartypeMap.get("name"));
            System.out.println("id = " + id + " , name = " + name);
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
            }
        }
    }*/


	public static void carMark(){
		String sql = "{\"data\":[{\"modelid\":180322434000008,\"modelname\":\"北奔NG80\"},{\"modelid\":180322434000009,\"modelname\":\"北奔V3\"},{\"modelid\":180322434000010,\"modelname\":\"北奔V3ET\"},{\"modelid\":180322434000011,\"modelname\":\"北奔V3M\"},{\"modelid\":180322434000012,\"modelname\":\"北奔V3MT\"},{\"modelid\":180322434000013,\"modelname\":\"北奔重卡\"}],\"info\":\"获取数据成功！\",\"success\":1}\n";
		JSONObject jsonObject = JSONObject.parseObject(sql);
		Map<String, Object> stringObjectMap = WxService.parseJSON2Map(jsonObject);
		List list = (ArrayList)stringObjectMap.get("data");
		for (int i = 0; i < list.size(); i++){
            Map modelMap = (Map) list.get(i);
            String modelId = ObjectUtil.getString(modelMap.get("modelid"));
            String modelname = ObjectUtil.getString(modelMap.get("modelname"));
            System.out.println("INSERT INTO car_make (brand_id, make_name, model_id) VALUES ('"+ modelname +"', " + modelId + ");");
        }

	}


	public static void carStyle(){
		String sql = "{\"style\":{\"22\":[{\"emissionStandardId\":4,\"engineBrand\":\"9\",\"engineMaxHorsepower\":185,\"gerrboxBrand\":\"4\",\"id\":191105433026362,\"styleBulletinModel\":\"AH5180GJB1L5\",\"styleDisname\":\"185马力 4×2 玉柴 法士特 柴油 国五 12m³\",\"styleDriveMode\":\"1\",\"styleName\":\"星马 (玉柴) 185马力 (YC4EG185-50) (国五) (法士特) 4×2 12立方 混凝土搅拌车 (AH5180GJB1L5)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"6\",\"engineMaxHorsepower\":290,\"gerrboxBrand\":\"39\",\"id\":180322433032108,\"styleBulletinModel\":\"AH5256GJB7\",\"styleDisname\":\"290马力 6×4 潍柴 汉马 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (潍柴) 290马力 (WP10.290) (国三) (汉马) 6×4 12立方 混凝土搅拌车 (AH5256GJB7)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"26\",\"engineMaxHorsepower\":290,\"gerrboxBrand\":\"39\",\"id\":180322433032109,\"styleBulletinModel\":\"AH5311GJB4\",\"styleDisname\":\"290马力 8×4 五十铃 汉马 柴油 国三 16m³\",\"styleDriveMode\":\"9\",\"styleName\":\"星马 (五十铃) 290马力 (6WF1D) (国三) (汉马) 8×4 16立方 混凝土搅拌车 (AH5311GJB4)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"4\",\"engineMaxHorsepower\":336,\"gerrboxBrand\":\"39\",\"id\":180322433032949,\"styleBulletinModel\":\"AH5256GJBB\",\"styleDisname\":\"336马力 6×4 中国重汽 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (中国重汽) 336马力 (WD615.95) (国三) 6×4 12立方 混凝土搅拌车 (AH5256GJBB)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"6\",\"engineMaxHorsepower\":336,\"gerrboxBrand\":\"4\",\"id\":180322433032859,\"styleBulletinModel\":\"AH5253GJB2\",\"styleDisname\":\"336马力 6×4 潍柴 法士特 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (潍柴) 336马力 (WP10.336) (国三) (法士特) 6×4 12立方 混凝土搅拌车 (AH5253GJB2)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":3,\"engineBrand\":\"6\",\"engineMaxHorsepower\":336,\"gerrboxBrand\":\"4\",\"id\":180322433032125,\"styleBulletinModel\":\"AH5253GJB3\",\"styleDisname\":\"336马力 6×4 潍柴 法士特 柴油 国四 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (潍柴) 336马力 (WP10.336N-40) (国四) (法士特) 6×4 12立方 混凝土搅拌车 (AH5253GJB3)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"18\",\"engineMaxHorsepower\":340,\"gerrboxBrand\":\"39\",\"id\":180322433032950,\"styleBulletinModel\":\"AH5250GJB7\",\"styleDisname\":\"340马力 6×4 东风康明斯 汉马 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (东风康明斯) 340马力 (ISLe340 30) (国三) (汉马) 6×4 12立方 混凝土搅拌车 (AH5250GJB7)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":3,\"engineBrand\":\"56\",\"engineMaxHorsepower\":345,\"gerrboxBrand\":\"39\",\"id\":181203433009688,\"styleBulletinModel\":\"AH5259GJB2L4B\",\"styleDisname\":\"345马力 6×4 汉马动力 汉马 柴油 国四 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (汉马动力) 345马力 (CM6D18.345 40) (国四) (汉马) 6×4 12立方 混凝土搅拌车 (AH5259GJB2L4B)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"42\",\"engineMaxHorsepower\":350,\"gerrboxBrand\":\"39\",\"id\":180322433032103,\"styleBulletinModel\":\"AH5253GJB3\",\"styleDisname\":\"350马力 6×4 上海日野 汉马 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (上海日野) 350马力 (P11C-UJ) (国三) (汉马) 6×4 12立方 混凝土搅拌车 (AH5253GJB3)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"42\",\"engineMaxHorsepower\":350,\"gerrboxBrand\":\"39\",\"id\":190117433010696,\"styleBulletinModel\":\"AH5311GJB4\",\"styleDisname\":\"350马力 8×4 上海日野 汉马 柴油 国三 16m³\",\"styleDriveMode\":\"9\",\"styleName\":\"星马 (上海日野) 350马力 (P11C-UJ) (国三) (汉马) 8×4 16立方 混凝土搅拌车 (AH5311GJB4)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"6\",\"engineMaxHorsepower\":375,\"gerrboxBrand\":\"4\",\"id\":180322433032863,\"styleBulletinModel\":\"AH5311GJB4\",\"styleDisname\":\"375马力 8×4 潍柴 法士特 柴油 国三 16m³\",\"styleDriveMode\":\"9\",\"styleName\":\"星马 (潍柴) 375马力 (WP12.375) (国三) (法士特) 8×4 16立方 混凝土搅拌车 (AH5311GJB4)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"10\",\"engineMaxHorsepower\":380,\"gerrboxBrand\":\"39\",\"id\":180322433032948,\"styleBulletinModel\":\"AH5257GJB2\",\"styleDisname\":\"380马力 6×4 三菱 汉马 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (三菱) 380马力 (6M70) (国三) (汉马) 6×4 12立方 混凝土搅拌车 (AH5257GJB2)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":1,\"engineBrand\":\"6\",\"engineMaxHorsepower\":380,\"gerrboxBrand\":\"4\",\"id\":180322433032876,\"styleBulletinModel\":\"AH5311GJB3\",\"styleDisname\":\"380马力 8×4 潍柴 法士特 柴油 国二 16m³\",\"styleDriveMode\":\"9\",\"styleName\":\"星马 (潍柴) 380马力 (WD615.38) (国二) (法士特) 8×4 16立方 混凝土搅拌车 (AH5311GJB3)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":3,\"engineBrand\":\"56\",\"engineMaxHorsepower\":380,\"gerrboxBrand\":\"39\",\"id\":180322433031907,\"styleBulletinModel\":\"AH5319GJB1L4A)\",\"styleDisname\":\"380马力 8×4 汉马动力 汉马 柴油 国四 16m³\",\"styleDriveMode\":\"9\",\"styleName\":\"星马 (汉马动力) 380马力 (CM6D28.380 40) (国四) (汉马) 8×4 16立方 混凝土搅拌车 (AH5319GJB1L4A))\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":3,\"engineBrand\":\"56\",\"engineMaxHorsepower\":380,\"gerrboxBrand\":\"68\",\"id\":180322433031910,\"styleBulletinModel\":\"AH5319GJB1L4A\",\"styleDisname\":\"380马力 8×4 汉马动力 索达 柴油 国四 16m³\",\"styleDriveMode\":\"9\",\"styleName\":\"星马 (汉马动力) 380马力 (CM6D28.380 40) (国四) (索达) 8×4 16立方 混凝土搅拌车 (AH5319GJB1L4A)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"},{\"emissionStandardId\":2,\"engineBrand\":\"42\",\"engineMaxHorsepower\":410,\"gerrboxBrand\":\"39\",\"id\":180322433032951,\"styleBulletinModel\":\"AH5257GJB2\",\"styleDisname\":\"410马力 6×4 上海日野 柴油 国三 12m³\",\"styleDriveMode\":\"5\",\"styleName\":\"星马 (上海日野) 410马力 (E13C TL) (国三) 6×4 12立方 混凝土搅拌车 (AH5257GJB2)\",\"stylePurposeId\":22,\"stylePurposeName\":\"混凝土搅拌车\"}]}}";

		JSONObject jsonObject = JSONObject.parseObject(sql);
		Map<String, Object> stringObjectMap = WxService.parseJSON2Map(jsonObject.getJSONObject("style"));
		for (String key : stringObjectMap.keySet()) {
			Object o = stringObjectMap.get(key);
			if (o instanceof String){
				System.out.println("eee");
			}
			if(o instanceof List){
				List<Object> list = (List<Object>) o;
				for (Object oo: list) {
					if (oo instanceof Map){
						Map<String, String> map = (Map)oo;

						String styleBulletinModel = "'" + map.get("styleBulletinModel") + "'";
						String styleDriveMode = "'" + map.get("styleDriveMode") + "'";
						String styleDisname = "'" + map.get("styleDisname") + "'";
						String styleName = "'" + map.get("styleName") + "'";
						String stylePurposeId = "'1'";
						String stylePurposeName = "'" + map.get("stylePurposeName") + "'";

						System.out.println("INSERT INTO `usedcar`.`car_style` (`brand_id`, `make_id`, `style_bulletin_model`, " +
								"`style_drive_mode`, `style_disname`, `style_name`, `style_purpose_id`, `style_purpose_name`) " +
								"VALUES (1, 1, 1, " +styleDriveMode+ ", "+styleDisname+", "+styleName+", "+stylePurposeId+", "+stylePurposeName+");");
					}
				}
			}
		}

	}

	public void fffff(){
		String sql = "{\n" +
				"\t\"data\": [\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"a\",\n" +
				"\t\t\t\"key\": \"180322537000002\",\n" +
				"\t\t\t\"value\": \"安徽星马\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"b\",\n" +
				"\t\t\t\"key\": \"180322537000004\",\n" +
				"\t\t\t\"value\": \"北奔重卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"b\",\n" +
				"\t\t\t\"key\": \"180322537000011\",\n" +
				"\t\t\t\"value\": \"北汽黑豹\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"b\",\n" +
				"\t\t\t\"key\": \"180322537000015\",\n" +
				"\t\t\t\"value\": \"奔驰\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"c\",\n" +
				"\t\t\t\"key\": \"180322537000019\",\n" +
				"\t\t\t\"value\": \"长安跨越\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"c\",\n" +
				"\t\t\t\"key\": \"180322537000022\",\n" +
				"\t\t\t\"value\": \"长春双龙\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"c\",\n" +
				"\t\t\t\"key\": \"180322537000029\",\n" +
				"\t\t\t\"value\": \"川交汽车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000031\",\n" +
				"\t\t\t\"value\": \"大运轻卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000032\",\n" +
				"\t\t\t\"value\": \"大运重卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000036\",\n" +
				"\t\t\t\"value\": \"东风多利卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000037\",\n" +
				"\t\t\t\"value\": \"东风福瑞卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000038\",\n" +
				"\t\t\t\"value\": \"东风股份\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000040\",\n" +
				"\t\t\t\"value\": \"东风华神\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000041\",\n" +
				"\t\t\t\"value\": \"东风凯普特\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000042\",\n" +
				"\t\t\t\"value\": \"东风力拓\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000043\",\n" +
				"\t\t\t\"value\": \"东风柳汽\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000044\",\n" +
				"\t\t\t\"value\": \"东风南充\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000045\",\n" +
				"\t\t\t\"value\": \"东风商用车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000048\",\n" +
				"\t\t\t\"value\": \"东风小霸王\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000050\",\n" +
				"\t\t\t\"value\": \"东风专底\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000052\",\n" +
				"\t\t\t\"value\": \"飞碟奥驰\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000053\",\n" +
				"\t\t\t\"value\": \"飞碟缔途\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000058\",\n" +
				"\t\t\t\"value\": \"福田奥铃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000061\",\n" +
				"\t\t\t\"value\": \"福田欧马可\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000062\",\n" +
				"\t\t\t\"value\": \"福田欧曼\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000064\",\n" +
				"\t\t\t\"value\": \"福田瑞沃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180322537000066\",\n" +
				"\t\t\t\"value\": \"福田时代\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"g\",\n" +
				"\t\t\t\"key\": \"180322537000067\",\n" +
				"\t\t\t\"value\": \"广汽日野\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000072\",\n" +
				"\t\t\t\"value\": \"航天晨光\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000073\",\n" +
				"\t\t\t\"value\": \"航天凌河\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000078\",\n" +
				"\t\t\t\"value\": \"湖北程力\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000079\",\n" +
				"\t\t\t\"value\": \"湖北楚胜\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000081\",\n" +
				"\t\t\t\"value\": \"湖北大运\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000082\",\n" +
				"\t\t\t\"value\": \"湖北航天双龙\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000083\",\n" +
				"\t\t\t\"value\": \"湖北合力\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000086\",\n" +
				"\t\t\t\"value\": \"湖北江山\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000089\",\n" +
				"\t\t\t\"value\": \"湖北新楚风\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000091\",\n" +
				"\t\t\t\"value\": \"华菱\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000094\",\n" +
				"\t\t\t\"value\": \"江淮格尔发\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000095\",\n" +
				"\t\t\t\"value\": \"江淮骏铃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000096\",\n" +
				"\t\t\t\"value\": \"江淮康铃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000099\",\n" +
				"\t\t\t\"value\": \"江淮帅铃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000101\",\n" +
				"\t\t\t\"value\": \"江铃集团轻汽\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000102\",\n" +
				"\t\t\t\"value\": \"江铃汽车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000103\",\n" +
				"\t\t\t\"value\": \"江铃重汽\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000105\",\n" +
				"\t\t\t\"value\": \"金杯\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"k\",\n" +
				"\t\t\t\"key\": \"180322537000111\",\n" +
				"\t\t\t\"value\": \"开瑞绿卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"k\",\n" +
				"\t\t\t\"key\": \"180322537000113\",\n" +
				"\t\t\t\"value\": \"凯马\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"l\",\n" +
				"\t\t\t\"key\": \"180322537000114\",\n" +
				"\t\t\t\"value\": \"雷诺\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"l\",\n" +
				"\t\t\t\"key\": \"180322537000115\",\n" +
				"\t\t\t\"value\": \"雷萨重机\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"l\",\n" +
				"\t\t\t\"key\": \"180322537000117\",\n" +
				"\t\t\t\"value\": \"力帆骏马\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"l\",\n" +
				"\t\t\t\"key\": \"180322537000119\",\n" +
				"\t\t\t\"value\": \"联合卡车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"m\",\n" +
				"\t\t\t\"key\": \"180322537000123\",\n" +
				"\t\t\t\"value\": \"曼\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"n\",\n" +
				"\t\t\t\"key\": \"180322537000126\",\n" +
				"\t\t\t\"value\": \"内蒙亿阳\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"n\",\n" +
				"\t\t\t\"key\": \"180322537000129\",\n" +
				"\t\t\t\"value\": \"南京依维柯\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"n\",\n" +
				"\t\t\t\"key\": \"180322537000130\",\n" +
				"\t\t\t\"value\": \"南骏汽车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"q\",\n" +
				"\t\t\t\"key\": \"180322537000135\",\n" +
				"\t\t\t\"value\": \"青岛解放\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"q\",\n" +
				"\t\t\t\"key\": \"180322537000137\",\n" +
				"\t\t\t\"value\": \"青岛重工\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"q\",\n" +
				"\t\t\t\"key\": \"180322537000138\",\n" +
				"\t\t\t\"value\": \"庆铃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000141\",\n" +
				"\t\t\t\"value\": \"三环十通\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000142\",\n" +
				"\t\t\t\"value\": \"三一重工\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000143\",\n" +
				"\t\t\t\"value\": \"山东东岳\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000146\",\n" +
				"\t\t\t\"value\": \"陕汽商用车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000150\",\n" +
				"\t\t\t\"value\": \"陕汽重卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000154\",\n" +
				"\t\t\t\"value\": \"上海华建\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000156\",\n" +
				"\t\t\t\"value\": \"上汽红岩\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000157\",\n" +
				"\t\t\t\"value\": \"上汽跃进\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000158\",\n" +
				"\t\t\t\"value\": \"韶起\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000160\",\n" +
				"\t\t\t\"value\": \"时风\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000161\",\n" +
				"\t\t\t\"value\": \"时骏\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000163\",\n" +
				"\t\t\t\"value\": \"斯堪尼亚\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"180322537000165\",\n" +
				"\t\t\t\"value\": \"四川现代\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"t\",\n" +
				"\t\t\t\"key\": \"180322537000168\",\n" +
				"\t\t\t\"value\": \"唐骏汽车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"t\",\n" +
				"\t\t\t\"key\": \"180322537000169\",\n" +
				"\t\t\t\"value\": \"唐山亚特\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"w\",\n" +
				"\t\t\t\"key\": \"180322537000172\",\n" +
				"\t\t\t\"value\": \"沃尔沃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"x\",\n" +
				"\t\t\t\"key\": \"180322537000182\",\n" +
				"\t\t\t\"value\": \"徐工重卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000185\",\n" +
				"\t\t\t\"value\": \"炎龙汽车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000186\",\n" +
				"\t\t\t\"value\": \"一汽红塔\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000188\",\n" +
				"\t\t\t\"value\": \"一汽解放\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"180322537000189\",\n" +
				"\t\t\t\"value\": \"解放轻卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000191\",\n" +
				"\t\t\t\"value\": \"一汽凌河\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000192\",\n" +
				"\t\t\t\"value\": \"一汽柳特\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000194\",\n" +
				"\t\t\t\"value\": \"一汽通用\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000195\",\n" +
				"\t\t\t\"value\": \"依维柯\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"y\",\n" +
				"\t\t\t\"key\": \"180322537000196\",\n" +
				"\t\t\t\"value\": \"宇通重工\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000204\",\n" +
				"\t\t\t\"value\": \"中国重汽\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000206\",\n" +
				"\t\t\t\"value\": \"中集\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000207\",\n" +
				"\t\t\t\"value\": \"中集凌宇\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000208\",\n" +
				"\t\t\t\"value\": \"中联重科\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000211\",\n" +
				"\t\t\t\"value\": \"重汽豪沃轻卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000212\",\n" +
				"\t\t\t\"value\": \"重汽豪瀚\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000213\",\n" +
				"\t\t\t\"value\": \"重汽豪曼\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000214\",\n" +
				"\t\t\t\"value\": \"重汽豪沃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000215\",\n" +
				"\t\t\t\"value\": \"重汽汕德卡\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000216\",\n" +
				"\t\t\t\"value\": \"重汽斯太尔\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"z\",\n" +
				"\t\t\t\"key\": \"180322537000217\",\n" +
				"\t\t\t\"value\": \"重汽王牌\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180322537000249\",\n" +
				"\t\t\t\"value\": \"航天万山\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"g\",\n" +
				"\t\t\t\"key\": \"180322537000261\",\n" +
				"\t\t\t\"value\": \"广汽吉奥\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000262\",\n" +
				"\t\t\t\"value\": \"大运(山西)\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000263\",\n" +
				"\t\t\t\"value\": \"东风创普\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"d\",\n" +
				"\t\t\t\"key\": \"180322537000274\",\n" +
				"\t\t\t\"value\": \"东沃\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180817537000101\",\n" +
				"\t\t\t\"value\": \"福达\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"h\",\n" +
				"\t\t\t\"key\": \"180827537000181\",\n" +
				"\t\t\t\"value\": \"恒曼\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"180914537000321\",\n" +
				"\t\t\t\"value\": \"福德\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"f\",\n" +
				"\t\t\t\"key\": \"181211537000761\",\n" +
				"\t\t\t\"value\": \"福田祥菱\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"j\",\n" +
				"\t\t\t\"key\": \"181211537000762\",\n" +
				"\t\t\t\"value\": \"金联达\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"190306537000822\",\n" +
				"\t\t\t\"value\": \"陕汽汽车\"\n" +
				"\t\t},\n" +
				"\t\t{\n" +
				"\t\t\t\"firstLetter\": \"s\",\n" +
				"\t\t\t\"key\": \"190314537000881\",\n" +
				"\t\t\t\"value\": \"三龙\"\n" +
				"\t\t}\n" +
				"\t],\n" +
				"\t\"info\": \"\",\n" +
				"\t\"success\": 1\n" +
				"}";
		JSONObject jsonObject = JSONObject.parseObject(sql);
		JSONArray dataJSONArray = jsonObject.getJSONArray("data");
		//System.out.println(jsonObject.get("data"));
		Map<String, Object> stringObjectMap = WxService.parseJSON2Map(jsonObject);
		for (String key : stringObjectMap.keySet()) {
			Object o = stringObjectMap.get(key);
			if(o instanceof List){
				List<Object> list = (List<Object>) o;
				for (Object oo: list) {
					if (oo instanceof Map){
						Map<String, String> map = (Map)oo;
                        /*System.out.println(map.get("value"));
                        System.out.println(map.get("firstLetter"));
                        System.out.println(map.get("key"));*/
						System.out.println("INSERT INTO car_brand (first_letter, key, brand_name) VALUES ('"+map.get("firstLetter")+"', '"+map.get("key")+"', '" + map.get("value") + "');");
					}
				}
			}

		}
	}
}
