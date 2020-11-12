package com.yajun.domain;

import com.yajun.config.Constants;
import com.yajun.utils.EncryptUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 汽车信息
 * @Description  
 * @Author  Hunter
 * @Date 2020-03-26 
 */

public class CarInfo implements Serializable {

	private static final long serialVersionUID =  380867866273672434L;

	private Long id;

	/**
	 * 品牌id
	 */
	private Long brandId;

	/**
	 * 车系Id
	 */
	private Long makeId;

	/**
	 * 用途ID
	 */
	private Long purposeId;

	/**
	 * 车型ID
	 */
	private Long carStyleId;

	/**
	 * 所在省份ID
	 */
	private Long provinceId;

	/**
	 * 所在省份
	 */
	private String province;

	/**
	 * 所在城市ID
	 */
	private Long cityId;

	/**
	 * 所在城市
	 */
	private String city;

	/**
	 * 上牌时间
	 */
	private Date formalitiesTime;

	/**
	 * 行驶里程
	 */
	private String mileage;

	/**
	 * 指导价格
	 */
	private BigDecimal price;

	/**
	 * 前照片
	 */
	private String photo1;

	/**
	 * 后照片
	 */
	private String photo2;

	/**
	 * 左侧45度照片
	 */
	private String photo3;

	/**
	 * 右侧45度照片
	 */
	private String photo4;

	/**
	 * 其它照片
	 */
	private String photo5;

	/**
	 * 发布userId
	 */
	private Long userId;

	/**
	 * 备注描述
	 */
	private String remak;

	/**
	 * 发布时间
	 */
	private Date releaseTime;

	/**
	 * 状态，0上架， 1下架
	 */
	private Integer status;

	/**
	 * 客户经理名称
	 */
	private String  managerName;

	/**
	 * 客户经理手机号
	 */
	private String managerMobile;

	/**
	 * 客户经理UserId
	 */
	private Long managerUserId;

	/**
	 * 加密ID
	 */
	private String sign;

	public String getSign() {
		return EncryptUtil.addSign(this.id, Constants.CAR_INFO_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Date getFormalitiesTime() {
		return formalitiesTime;
	}

	public void setFormalitiesTime(Date formalitiesTime) {
		this.formalitiesTime = formalitiesTime;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public String getPhoto4() {
		return photo4;
	}

	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	public String getPhoto5() {
		return photo5;
	}

	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRemak() {
		return remak;
	}

	public void setRemak(String remak) {
		this.remak = remak;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getMakeId() {
		return makeId;
	}

	public void setMakeId(Long makeId) {
		this.makeId = makeId;
	}

	public Long getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(Long purposeId) {
		this.purposeId = purposeId;
	}

	public Long getCarStyleId() {
		return carStyleId;
	}

	public void setCarStyleId(Long carStyleId) {
		this.carStyleId = carStyleId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerMobile() {
		return managerMobile;
	}

	public void setManagerMobile(String managerMobile) {
		this.managerMobile = managerMobile;
	}

	public Long getManagerUserId() {
		return managerUserId;
	}

	public void setManagerUserId(Long managerUserId) {
		this.managerUserId = managerUserId;
	}
}
