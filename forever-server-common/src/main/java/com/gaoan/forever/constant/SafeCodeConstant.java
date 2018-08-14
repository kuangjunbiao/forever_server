package com.gaoan.forever.constant;

public enum SafeCodeConstant {

    COMMON_ERROR("-1", "操作失败"), FORM_IS_HANDLING("-2", "正在处理中,请不要重复提交"),

    COMMON_SUCCESS("0", "成功"), COMMON_FAILED("1", "失败"),

    SAFE_CENTER_APICODE_SUCCESS("20000", "成功"), SAFE_CENTER_APICODE_FAIL("20001",
	    "失败"), SAFE_CENTER_APICODE_ERROR("20002", "错误"), SAFE_CENTER_APICODE_VERIFYSIGNFAIL("10025", "验签失败"),

    SAFE_CENTER_PARAM_ERRER("10011", "参数错误"), SAFE_CENTER_SGINFAIL("10502",
	    "加签失败"), SAFE_CENTER_SECRETKEYNOTEXIST("10522", "没有密钥，请重新登录makes"), SAFE_CENTER_ACCOUNTDISABLED("10525",
		    "用户被禁止使用该系统"), SAFE_CENTER_REQUSTEXCEEDSLIMIT("10537",
			    "超出请求频率限制"), SAFE_CENTER_POPENSYSPROTECTION("10524", "请先开启系统保护"),

    SAFE_CENTER_PLATFORMNOTAUTHORIZED("10535", "该平台尚未被授权"), SAFE_CENTER_systemisbusy("10529",
	    "系统很忙碌，请稍后再试！"), SAFE_CENTER_SYSTEMLOGINBUSY("10530", "系统登录繁忙"), SAFE_CENTER_PAYMENTISBUSY("10531",
		    "系统支付繁忙"), SAFE_CENTER_USERTEMPORARILYLOCKED("10037", "用户被临时锁定"), SAFE_CENTER_USERLOCKEDBYADMIN(
			    "10526", "用户被管理员锁定"), SAFE_CENTER_PWDERRORLOCKED("10527",
				    "密码错误次数太多，永久锁定"), SAFE_CENTER_INVALIDUSERSTATUS("10528", "用户状态无效"),

    SAFE_CENTER_PAYMENTRIGHTSLOCKED("10532", "支付权限被锁定"), SAFE_CENTER_DYNAMICCODEERROR("10520",
	    "动态密码错误"), SAFE_CENTER_DYNAMICCODTRYAGIN("10536",
		    "动态密码长度不正确，请重新输入或者重新登录makeys"), SAFE_CENTER_TOTPCAPTCHACANUSEONE("10521", "TOTP验证码只能被使用一次"),;

    SafeCodeConstant(String status, String desc) {
	this.status = status;
	this.desc = desc;
    }

    private String status;// 状态
    private String desc;// 描述

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getDesc() {
	return desc;
    }

    public void setDesc(String desc) {
	this.desc = desc;
    }

    public static SafeCodeConstant getCodeMsgByCode(String code) {
	for (SafeCodeConstant sc : SafeCodeConstant.values()) {
	    if (sc.getStatus().equals(code.trim())) {
		return sc;
	    }
	}
	return null;
    }
}
