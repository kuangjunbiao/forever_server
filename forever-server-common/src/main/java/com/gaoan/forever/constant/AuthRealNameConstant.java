package com.gaoan.forever.constant;

/**
 * 安全中心常量
 */
public interface AuthRealNameConstant {

	// 安全中心与互助比较结果
	/**
	 * 0:尚未处理结果
	 */
	public static final int MAKEYS_COMPARE_RESULT_ZERO = 0;

	/**
	 * 1:安全锁无(信息未被占用),互助正确
	 */
	public static final int MAKEYS_COMPARE_RESULT_ONE = 1;

	/**
	 * 2:安全锁无,互助错误
	 */
	public static final int MAKEYS_COMPARE_RESULT_TWO = 2;

	/**
	 * 3:安全锁有(审核通过),互助正确且相同
	 */
	public static final int MAKEYS_COMPARE_RESULT_THREE = 3;

	/**
	 * 4:安全锁有,互助正确且不同
	 */
	public static final int MAKEYS_COMPARE_RESULT_FOUR = 4;

	/**
	 * 5:安全锁有,互助错误
	 */
	public static final int MAKEYS_COMPARE_RESULT_FIVE = 5;

	/**
	 * 6:安全锁有(未审核通过),互助正确且相同
	 */
	public static final int MAKEYS_COMPARE_RESULT_SIX = 6;

	/**
	 * 7:安全锁无(信息被占用),互助正确
	 */
	public static final int MAKEYS_COMPARE_RESULT_SEVEN = 7;

	// 安全中心认证状态
	/**
	 * 1:已认证
	 */
	public static final int MAKEYS_AUTH_STATUS_AUTHED = 1;
	/**
	 * 2:未认证
	 */
	public static final int MAKEYS_AUTH_STATUS_NOT_AUTH = 2;
	/**
	 * 3:已过期
	 */
	public static final int MAKEYS_AUTH_STATUS_EXPIRED = 3;
	/**
	 * 4:待审核
	 */
	public static final int MAKEYS_AUTH_STATUS_WAIT_CHECK = 4;
	/**
	 * 5:认证失败
	 */
	public static final int MAKEYS_AUTH_STATUS_AUTH_FAIL = 5;

	// 安全中心性别
	/**
	 * 男性
	 */
	public static final int MAKEYS_SEX_MALE = 1;

	/**
	 * 女性
	 */
	public static final int MAKEYS_SEX_FEMALE = 2;

	/**
	 * 未知
	 */
	public static final int MAKEYS_SEX_UNKOWN = 0;

	// 安全中心证件类型
	/**
	 * 身份证
	 */
	public static final int MAKEYS_DOCUMENT_TYPE_ID_CARD = 0;
	/**
	 * 驾驶证
	 */
	public static final int MAKEYS_DOCUMENT_TYPE_DRIVER_LICENSE = 1;
	/**
	 * 护照
	 */
	public static final int MAKEYS_DOCUMENT_TYPE_PASSPORT = 2;

	// 互助实名认证状态
	/**
	 * 0:安全中心待认证
	 */
	public static final int HZ_REAL_NAME_AUTH_MEKEYS_NOT_CERTIFIED = 0;
	/**
	 * 1:安全中心已认证
	 */
	public static final int HZ_REAL_NAME_AUTH_MEKEYS_VERIFIED = 1;
	/**
	 * 2:安全中心认证失败
	 */
	public static final int HZ_REAL_NAME_AUTH_MEKEYS_VERIFIED_FAIL = 2;
	/**
	 * 3:互助待认证
	 */
	public static final int HZ_BANK_AUTH_NOT_CERTIFIED = 3;
	/**
	 * 4:互助已认证
	 */
	public static final int HZ_BANK_AUTH_VERIFIED = 4;
	/**
	 * 5:互助认证失败
	 */
	public static final int HZ_BANK_AUTH_VERIFIED_FAIL = 5;

	// 互助性别
	/**
	 * 男性
	 */
	public static final int HZ_SEX_MALE = 1;

	/**
	 * 女性
	 */
	public static final int HZ_SEX_FEMALE = 0;

	// 互助证件类型
	/**
	 * 1：中国身份证
	 */
	public static final int HZ_ID_CREDENTIALS_TYPE_CHINAID = 1;

	/**
	 * 2：护照
	 */
	public static final int HZ_ID_CREDENTIALS_TYPE_PASSPORT = 2;

	/**
	 * 3:驾驶证
	 */
	public static final int HZ_ID_CREDENTIALS_TYPE_DRIVER_LICENSE = 3;

}
