package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class Citys implements Serializable {

	private static final long serialVersionUID =  1606696309077556319L;

	/**
	 * 地区ID
	 */
	private Long id;

	/**
	 * 省ID
	 */
	private Long provinceId;

	/**
	 * 城市名称
	 */
	private String name;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.CITYS_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
