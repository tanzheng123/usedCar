package com.yajun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="auth.wechat")
public class WxConfig {

    public static final String TRADE_TYPE_JSAPI = "JSAPI";

    public static final String PLATFORM_COMPANY_NAME = "雅俊商用车-预付定金";

    //微信支付API
    public static final String WX_PAY_UNIFIED_ORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    private String sessionHost;
    private String appId;
    private String secret;
    private String grantType;

    //小程序支付参数
    private String mchid;
    private String key;

    private String proServerDomain;





    public String getSessionHost() {
        return sessionHost;
    }

    public void setSessionHost(String sessionHost) {
        this.sessionHost = sessionHost;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProServerDomain() {
        return proServerDomain;
    }

    public void setProServerDomain(String proServerDomain) {
        this.proServerDomain = proServerDomain;
    }
}
