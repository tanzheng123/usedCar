package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class Users implements Serializable {

	private static final long serialVersionUID =  3298533972936333791L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 真实两名
	 */
	private String trueName;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 类型,0:普通用户，1：客户经理
	 */
	private int type;

	/**
	 * 微信openId
	 */
	private String openId;

	/**
	 * 注册时间
	 */
	private Date registerTime;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.USER_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * 订单状态
	 * @description
	 */
	public enum UserStyle {

		GENERAL(0, "普通"),

		MANAGER(1,"客户经理"),
		;

		/** 状态 */
		public int code;

		/** 描述 */
		public String value;

		private UserStyle(int code, String value){
			this.code = code;
			this.value = value;
		}

		public static UserStyle getEnum(int code){
			UserStyle[] userStyles = UserStyle.values();
			for(UserStyle userStyle : userStyles){
				if(userStyle.code == code){

					return userStyle;
				}
			}
			return null;
		}
	}
}
