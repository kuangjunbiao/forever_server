package com.gaoan.forever.constant;

/**
 * redis 相关静态变量 Created by NO.9527 on 2017年7月15日
 */
public class RedisConstant {

    /** 互助系统后台 系统配置 redis key **/
    public static final String KEY_HZ_HT_SYSTEMSET_KEY = "KEY_HZ_HT_SYSTEMSET_KEY";

    /** 互助系统后台 系统交易配置 redis key **/
    public static final String KEY_HZ_HT_SYSTEMSET_TRADE_KEY = "HZHST";

    /** 互助系统后台 系统配置 内容 redis key 前缀 **/
    public static final String KEY_HZ_HT_SYSTEMSET_PREFIX = "KEY_HZ_HT_SYSTEMSET_PREFIX_";

    /**
     * 比特币 btc 市场成交平均价 redis key
     */
    public static final String KEY_HZ_QT_BTCMARKET_AVGPRICE_KEY = "KEY_HZ_QT_BTCMARKET_AVGPRICE_KEY";

    public static final String KEY_HZ_TRADE_LOGIN_INFO = "TRADE_USER_SESSION";

    /**
     * 线下交易违规判断任务 redis key
     */
    public static final String TASK_KEY_TRADE_DOWNLINE_VIOLATION_JUDGMENT = "TASK_KEY_TRADE_DOWNLINE_VIOLATION_JUDGMENT";

    /**
     * 线下交易自动撤单任务 redis key
     */
    public static final String TASK_KEY_TRADE_DOWNLINE_AUTOMATIC_ROLLBACK_ORDER = "TASK_KEY_TRADE_DOWNLINE_AUTOMATIC_ROLLBACK_ORDER";

    /**
     * 线上交易自动撤单任务 redis key
     */
    public static final String TASK_KEY_TRADE_ONLINE_AUTOMATIC_ROLLBACK_ORDER = "TASK_KEY_TRADE_ONLINE_AUTOMATIC_ROLLBACK_ORDER";

    /**
     * 中国地区 redis key 前缀 配置格式 KEY_HZ_AREA_PREFIX_省_市
     */
    public static final String KEY_HZ_CHINA_AREA_PREFIX = "KEY_HZ_CHINA_AREA_PREFIX_";

    /**
     * 手机号地域信息 ，缓存key
     */
    public static final String KEY_HZ_MOBILE_AREA_LIST = "KEY_HZ_MOBILE_AREA_LIST";

    /**
     * 手机验证码reids key
     */
    public static final String KEY_HZ_MOBILE_CODE = "KEY_HZ_MOBILE_CODE:";

    /**
     * 邮件验证码redis key
     */
    public static final String KEY_HZ_EMAIL_CODE = "KEY_HZ_EMAIL_CODE:";

    /**
     * 验证码通过验证redis key
     */
    public static final String KEY_HZ_CODE_PASS = "KEY_HZ_CODE_PASS:";

    /**
     * 谷歌验证码验证redis key
     */
    public static final String KEY_HZ_GOOGLE_SECRET = "KEY_HZ_GOOGLE_SECRET:";

    /**
     * 用户保存语言 redis key
     */
    public static final String KEY_HZ_LANGUAGE_CODE = "KEY_HZ_LANGUAGE_CODE:";

    /**
     * 前台通知通告列表
     */
    public static final String KEY_HZ_WEBNOTIFY_LIST_PREFIX_ = "KEY_HZ_WEBNOTIFY_LIST_PREFIX_";

    /**
     * 前台通知通告详情
     */
    public static final String KEY_HZ_WEBNOTIFY_DETAIL = "KEY_HZ_WEBNOTIFY_DETAIL";

    /**
     * 线下交易 各币种统计面板缓存
     */
    public static final String KEY_HZ_TRADE_DOWNLINE_STATPANEL_ = "KEY_HZ_TRADE_DOWNLINE_STATPANEL_";

    /**
     * 线下交易 各币种统计面板缓存
     */
    public static final String KEY_HZ_TRADE_DOWNLINE_STATPANEL_ALL = "KEY_HZ_TRADE_DOWNLINE_STATPANEL_ALL";

    /**
     * 线下交易 各币种统计面板缓存
     */
    public static final String KEY_HZ_TRADE_DOWNLINE_STATPANEL_NEW_ = "KEY_HZ_TRADE_DOWNLINE_STATPANEL_NEW_";

    /**
     * 线上交易 各币种统计面板缓存
     */
    public static final String KEY_HZ_TRADE_ONLINE_STATPANEL_ = "KEY_HZ_TRADE_ONLINE_STATPANEL_";

    /**
     * 线上交易全部币种统计面板缓存
     */
    public static final String KEY_HZ_TRADE_ONLINE_STATPANEL_ALL = "KEY_HZ_TRADE_ONLINE_STATPANEL_ALL";

    /***
     * 用户银行信息缓存
     */
    public static final String KEY_HZ_USERBANKINFO_USERID = "KEY_HZ_USERBANKINFO_";

    /**
     * 前台登录认证缓存
     */
    public static final String KEY_HZ_LOGIN_STATUS = "KEY_HZ_LOGIN_STATUS:";

    /**
     * 用户每天接口访问计数缓存
     */
    public static final String KEY_HZ_API_ACCESS_BYDATE_COUNT = "KEY_HZ_API_ACCESS_BYDATE_COUNT:";

    /**
     * 用户接口访问计数缓存
     */
    public static final String KEY_HZ_API_ACCESS_COUNT = "KEY_HZ_API_ACCESS_COUNT:";

    // ==============================================================================================================

    /**
     * 互助线下交易列表 格式 format ：KEY_HZ_DOWNLINE_TRADEORDER:{0}:{1}:{2} {0}:yyyy-MM-dd
     * {1}:币种id
     */
    public static final String KEY_HZ_DOWNLINE_TRADEORDER = "KEY_HZ_DOWNLINE_TRADEORDER:{0}:{1}";

    /**
     * 互助线下交易 订单当前最新 key 的存储key : 币种id 注：也就是说 交易最新key 存储在 当前key中
     */
    public static final String KEY_HZ_DOWNLINE_NEWKEY = "KEY_HZ_DOWNLINE_NEWKEY:";

    // =======================================================================================================================
    /**
     * 安全中心返回uuid redis key 前缀
     */
    public static final String REDIS_KEY_SAFE_UUID_PREFIX = "REDIS_KEY_SAFE_UUID_PREFIX:";

    /**
     * 安全中心 未绑定互助标记
     */
    public static final String REDIS_KEY_SAFE_NOTBAIND_FLAG_PREFIX = "REDIS_KEY_SAFE_NOTBAIND_FLAG_PREFIX:";

    /**
     * 互助 未绑定安全中心标记
     */
    public static final String REDIS_KEY_HZ_NOTBAIND_FLAG_PREFIX = "REDIS_KEY_HZ_NOTBAIND_FLAG_PREFIX:";

    // ============================================================================================================================
    public static final String REDIS_KEY_HZ_ORDERNUMBERMARK = "REDIS_KEY_HZ_ORDERNUMBERMARK";

    // ===================================================================================================
    /**
     * 限定过期时间内的 活跃用户redis key
     */
    public static final String REDIS_KEY_HZ_ACTIVITY_USERKEY = "REDIS_KEY_HZ_ACTIVITY_USERKEY";

    // =================================================================================================
    /**
     * 币币兑换交易配置 redis key
     */
    public static final String REDIS_KEY_HZ_COINTOCOINTRADE_CONF = "REDIS_KEY_HZ_COINTOCOINTRADE_CONF:";

    /**
     * 币币兑换交易配置 交易平台可用配置 redis key
     */
    public static final String REDIS_KEY_HZ_COINTOCOINTRADE_USEING_CONF = "REDIS_KEY_HZ_COINTOCOINTRADE_USEING_CONF:";

    /**
     * 平台兑换交易配置 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_CONF = "REDIS_KEY_HZ_PLATFORMEXCHANGE_CONF:";

    /**
     * 平台兑换交易配置 交易平台可用配置 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_USEING_CONF = "REDIS_KEY_HZ_PLATFORMEXCHANGE_USEING_CONF:";

    /**
     * 后台用户登录次数 redis key
     */
    public static final String REDIS_KEY_HZ_BG_LOGIN_WRONG_COUNT = "REDIS_KEY_HZ_BG_LOGIN_WRONG_COUNT:";

    /**
     * 平台兑换交易折算价配置 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_SNAPSHOT = "CTCSNAPSHOT_";

    /**
     * 平台兑换交易折算价配置 redis key
     */
    public static final String REDIS_KEY_HZ_DOWNLINE_STAT_PANE_SNAPSHOT = "SPD_";

    /**
     * 平台兑换交易折算价配置 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_STATPANEL_ = "CTCSTATPANEL_";

    /**
     * 平台兑换交易折算价配置 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_STATPANEL_ALL = "CTCSTATPANEL_ALL";

    /**
     * 平台兑换系统币信息集合 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_INFO_ALL = "CTCINFO_ALL";

    /**
     * 平台兑换系统币信息 redis key
     */
    public static final String REDIS_KEY_HZ_PLATFORMEXCHANGE_INFO = "CTCINFO_";
}
