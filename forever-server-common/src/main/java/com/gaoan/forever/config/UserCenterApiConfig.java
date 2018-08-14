package com.gaoan.forever.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "usercenterapi")
public class UserCenterApiConfig {

    private String host;

    private String protocol;

    private String apiloginpass;

    private String systemid;

    private String apigetqrcode;

    private String safesystemId;

    private String apicheckMobile;

    private String apiboundMobile;

    private String apiVerifycode;

    private String makeysLogoPath;

    private String apiGetAuthInfo;

    /**
     * @return the host
     */
    public String getHost() {
	return host;
    }

    /**
     * @param host
     *            the host to set
     */
    public void setHost(String host) {
	this.host = host;
    }

    /**
     * @return the apiloginpass
     */
    public String getApiloginpass() {
	return bulidUrl(apiloginpass);
    }

    /**
     * @param apiloginpass
     *            the apiloginpass to set
     */
    public void setApiloginpass(String apiloginpass) {
	this.apiloginpass = apiloginpass;
    }

    /**
     * @return the protocol
     */
    public String getProtocol() {
	return protocol;
    }

    /**
     * @param protocol
     *            the protocol to set
     */
    public void setProtocol(String protocol) {
	this.protocol = protocol;
    }

    /**
     * @return the systemid
     */
    public String getSystemid() {
	return systemid;
    }

    /**
     * @param systemid
     *            the systemid to set
     */
    public void setSystemid(String systemid) {
	this.systemid = systemid;
    }

    /**
     * @return the apigetqrcode
     */
    public String getApigetqrcode() {
	return bulidUrl(apigetqrcode);
    }

    /**
     * @param apigetqrcode
     *            the apigetqrcode to set
     */
    public void setApigetqrcode(String apigetqrcode) {
	this.apigetqrcode = apigetqrcode;
    }

    private String bulidUrl(String url) {
	return this.getProtocol() + "://" + this.getHost() + url;
    }

    /**
     * @return the safesystemId
     */
    public String getSafesystemId() {
	return safesystemId;
    }

    /**
     * @param safesystemId
     *            the safesystemId to set
     */
    public void setSafesystemId(String safesystemId) {
	this.safesystemId = safesystemId;
    }

    /**
     * @return the apicheckMobile
     */
    public String getApicheckMobile() {
	return bulidUrl(apicheckMobile);
    }

    /**
     * @param apicheckMobile
     *            the apicheckMobile to set
     */
    public void setApicheckMobile(String apicheckMobile) {
	this.apicheckMobile = apicheckMobile;
    }

    /**
     * @return the apiboundMobile
     */
    public String getApiboundMobile() {
	return bulidUrl(apiboundMobile);
    }

    /**
     * @param apiboundMobile
     *            the apiboundMobile to set
     */
    public void setApiboundMobile(String apiboundMobile) {
	this.apiboundMobile = apiboundMobile;
    }

    public String getApiVerifycode() {
	return bulidUrl(apiVerifycode);
    }

    public void setApiVerifycode(String apiVerifycode) {
	this.apiVerifycode = apiVerifycode;
    }

    public String getMakeysLogoPath() {
	return makeysLogoPath;
    }

    public void setMakeysLogoPath(String makeysLogoPath) {
	this.makeysLogoPath = makeysLogoPath;
    }

    public String getApiGetAuthInfo() {
	return bulidUrl(apiGetAuthInfo);
    }

    public void setApiGetAuthInfo(String apiGetAuthInfo) {
	this.apiGetAuthInfo = apiGetAuthInfo;
    }

}
