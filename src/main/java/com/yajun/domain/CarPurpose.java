package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;

/**
 *
 * 汽车用途
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class CarPurpose implements Serializable {

	private static final long serialVersionUID =  7190110894542840633L;

	/**
	 * 用途ID
	 */
	private Long id;

	/**
	 * 车系Id
	 */
	private Long makeId;

	/**
	 * 用途
	 */
	private String purpose;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.CAR_PURPOSE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}
}
