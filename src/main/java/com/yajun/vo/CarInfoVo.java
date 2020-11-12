package com.yajun.vo;

import com.yajun.config.Constants;
import com.yajun.domain.CarInfo;
import com.yajun.utils.EncryptUtil;

public class CarInfoVo extends CarInfo {

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     *车系名称
     */
    private String makeName;

    /**
     *用途
     */
    private String purpose;

    /**
     * 类型显示名称
     */
    private String styleDisname;

    /**
     *类型名称
     */
    private String styleName;

    /**
     * 关注userId
     */
    private Integer attentionUserId;

    /**
     * 关注状态
     */
    private Integer attentionStatus;

    /**
     * 加密ID
     */
    private String carStyleSign;

    public String getCarStyleSign() {
        return EncryptUtil.addSign(this.getCarStyleId(), Constants.CAR_STYLE_ID_SIGN, Constants.ENCRYPTION_KEY_DES);
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public Integer getAttentionUserId() {
        return attentionUserId;
    }

    public void setAttentionUserId(Integer attentionUserId) {
        this.attentionUserId = attentionUserId;
    }

    public Integer getAttentionStatus() {
        return attentionStatus;
    }

    public void setAttentionStatus(Integer attentionStatus) {
        this.attentionStatus = attentionStatus;
    }
}
