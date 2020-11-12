package com.yajun.domain;

import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class CarType implements Serializable {

	private static final long serialVersionUID =  5992420662822677608L;

	private Long id;

	/**
	 * 品牌ID
	 */
	private Long brandId;

	/**
	 * 车系ID
	 */
	private Long systemId;

	/**
	 * 车型
	 */
	private String type;

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

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
