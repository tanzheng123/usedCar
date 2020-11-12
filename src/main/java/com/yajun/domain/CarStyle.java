package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class CarStyle implements Serializable {

	private static final long serialVersionUID =  5992420662822677608L;

	private Long id;

	/**
	 * 品牌ID
	 */
	private Long brandId;

	/**
	 * 车系ID
	 */
	private Long makeId;

	private String engineMaxHorsepower;

	private String styleBulletinModel;

	private String styleDriveMode;

	/**
	 *	类型显示名称
	 */
	private String styleDisname;

	/**
	 *	类型名称
	 */
	private String styleName;

	/**
	 * 用途ID
	 */
	private long stylePurposeId;

	/**
	 * 用户名称
	 */
	private String stylePurposeName;

	private Long emissionStandardId;

	private String engineBrand;

	private String gerrboxBrand;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.CAR_STYLE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}

	public String getStyleBulletinModel() {
		return styleBulletinModel;
	}

	public void setStyleBulletinModel(String styleBulletinModel) {
		this.styleBulletinModel = styleBulletinModel;
	}

	public String getStyleDriveMode() {
		return styleDriveMode;
	}

	public void setStyleDriveMode(String styleDriveMode) {
		this.styleDriveMode = styleDriveMode;
	}

	public String getStyleDisname() {
		return styleDisname;
	}

	public void setStyleDisname(String styleDisname) {
		this.styleDisname = styleDisname;
	}

	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public long getStylePurposeId() {
		return stylePurposeId;
	}

	public void setStylePurposeId(long stylePurposeId) {
		this.stylePurposeId = stylePurposeId;
	}

	public String getStylePurposeName() {
		return stylePurposeName;
	}

	public void setStylePurposeName(String stylePurposeName) {
		this.stylePurposeName = stylePurposeName;
	}

	public String getEngineMaxHorsepower() {
		return engineMaxHorsepower;
	}

	public void setEngineMaxHorsepower(String engineMaxHorsepower) {
		this.engineMaxHorsepower = engineMaxHorsepower;
	}

	public Long getEmissionStandardId() {
		return emissionStandardId;
	}

	public void setEmissionStandardId(Long emissionStandardId) {
		this.emissionStandardId = emissionStandardId;
	}

	public String getEngineBrand() {
		return engineBrand;
	}

	public void setEngineBrand(String engineBrand) {
		this.engineBrand = engineBrand;
	}

	public String getGerrboxBrand() {
		return gerrboxBrand;
	}

	public void setGerrboxBrand(String gerrboxBrand) {
		this.gerrboxBrand = gerrboxBrand;
	}
}
