package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class CarBrand implements Serializable {

	private static final long serialVersionUID =  6261724283229569028L;

	private Long id;

	/**
	 * 首字母
	 */
	private String firstLetter;

	private String key;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.CAR_BRAND_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
