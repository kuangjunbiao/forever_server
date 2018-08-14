package com.gaoan.forever.model.safecenter;

import java.io.Serializable;

public class SafeApiLoginRespModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8637673947498060725L;

    private boolean status;

    private String mobile;

    private String nationCode;

    private String msg;

    // 用户标志(1为正常用户，2为内部用户)
    private String flag;

    public boolean isStatus() {
	return status;
    }

    public void setStatus(boolean status) {
	this.status = status;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public String getNationCode() {
	return nationCode;
    }

    public void setNationCode(String nationCode) {
	this.nationCode = nationCode;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

    public String getFlag() {
	return flag;
    }

    public void setFlag(String flag) {
	this.flag = flag;
    }

}
