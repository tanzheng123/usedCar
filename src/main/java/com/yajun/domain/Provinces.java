package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class Provinces implements Serializable {

	private static final long serialVersionUID =  5020122452643945512L;

	/**
	 * 省id
	 */
	private Long id;

	/**
	 * 省名称
	 */
	private String name;

	/**
	 * 状态 0 正常; 1 不正常
	 */
	private Boolean status;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.PROVINCES_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
