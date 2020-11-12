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

public class ApplyInfo implements Serializable {

	private static final long serialVersionUID =  4440601110613970122L;

	private Long id;

	/**
	 * 姓名
	 */
	private String userName;

	/**
	 * 所在省份ID
	 */
	private Long provinceId;

	/**
	 * 所在省份
	 */
	private String province;

	/**
	 * 所在城市Id
	 */
	private Long cityId;

	/**
	 * 所在城市
	 */
	private String city;

	/**
	 * 品牌车系
	 */
	private Long brandId;

	private Long makeId;

	/**
	 * 联系人手机号码
	 */
	private String contactMobile;

	/**
	 * 是否加急
	 */
	private Boolean isUrgent;

	/**
	 * 身份证正面照
	 */
	private String identityFrontImage;

	/**
	 * 身份证反面照
	 */
	private String identityReverseImage;

	/**
	 * 登记证1
	 */
	private String registrationImage1;

	/**
	 * 登记证2
	 */
	private String registrationImage2;

	/**
	 * 登记证3
	 */
	private String registrationImage3;

	/**
	 * 登记证4
	 */
	private String registrationImage4;

	/**
	 * 申请时间
	 */
	private Date applyTime;

	/**
	 * 用户Id
	 */
	private Long userId;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.APPLY_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public Boolean getUrgent() {
		return isUrgent;
	}

	public void setUrgent(Boolean urgent) {
		isUrgent = urgent;
	}

	public String getIdentityFrontImage() {
		return identityFrontImage;
	}

	public void setIdentityFrontImage(String identityFrontImage) {
		this.identityFrontImage = identityFrontImage;
	}

	public String getIdentityReverseImage() {
		return identityReverseImage;
	}

	public void setIdentityReverseImage(String identityReverseImage) {
		this.identityReverseImage = identityReverseImage;
	}

	public String getRegistrationImage1() {
		return registrationImage1;
	}

	public void setRegistrationImage1(String registrationImage1) {
		this.registrationImage1 = registrationImage1;
	}

	public String getRegistrationImage2() {
		return registrationImage2;
	}

	public void setRegistrationImage2(String registrationImage2) {
		this.registrationImage2 = registrationImage2;
	}

	public String getRegistrationImage3() {
		return registrationImage3;
	}

	public void setRegistrationImage3(String registrationImage3) {
		this.registrationImage3 = registrationImage3;
	}

	public String getRegistrationImage4() {
		return registrationImage4;
	}

	public void setRegistrationImage4(String registrationImage4) {
		this.registrationImage4 = registrationImage4;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}
}
