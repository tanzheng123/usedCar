package com.yajun.vo;

import com.yajun.domain.ApplyInfo;

public class ApplyInfoVo extends ApplyInfo{

    /**
     * 首字母
     */
    private String firstLetter;

    private String key;

    /**
     * 品牌名称
     */
    private String brandName;

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
