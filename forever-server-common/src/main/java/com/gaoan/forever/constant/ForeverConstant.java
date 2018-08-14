package com.gaoan.forever.constant;

/**
 * 通用常量
 */
public class ForeverConstant {
    /**
     * 安全中心动态码交易类型 1：登录
     */
    public static final int SAFECENTER_API_VERIFICATIONTYPE_LOGIN = 1;

    /**
     * 安全中心动态码交易类型 2：支付
     */
    public static final int SAFECENTER_API_VERIFICATIONTYPE_PAY = 2;

    /**
     * 虚拟币 保留6位小数
     */
    public static final int VIRTUAL_CURRENCY_DECIMALCOUNT = 6;

    /**
     * 资源类型
     * 
     * @author Administrator
     *
     */
    public interface ResourcesStatus {
	public static final Integer MENU = 1;
	public static final Integer OPERATER = 2;
    }

}
