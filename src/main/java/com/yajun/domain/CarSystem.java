package com.yajun.domain;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class CarSystem implements Serializable {

	private static final long serialVersionUID =  6640950621731669831L;

	private Long id;

	/**
	 * 品牌id
	 */
	private Long brandId;

	/**
	 * 车系名称
	 */
	private String systemName;

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

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}
