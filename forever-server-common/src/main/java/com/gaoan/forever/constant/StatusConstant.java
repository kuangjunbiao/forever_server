package com.gaoan.forever.constant;

/**
 * 状态常量
 * Created by three on 2017/4/12.
 */
public enum StatusConstant {
    SERVER_STOP("-2","服务器已停止"),
    LOGIN_NO("-1", "用户未登录"),
    SUCCESS("0","成功"),
    FAILED("1","失败"),
    ERROR("2","失败"),
    REQ_SUCCESS("200","成功"),
    REQ_FAIL("400","失败"),
    AMOUNT_IS_LESS_THAN("10001", "账户金币不足"),
    TURN_OUT_FAIL("10002", "账户金币转出失败"),
    TURN_IN_FAIL("10003", "金币转入对方账户失败"),
    GT_MAX_FAIL("10004", "已超出限制，本档还可以购买：%s个"),
    LT_MAX_FAIL("10005", "本次购买种子额小于总投资额"),
    CURRENCY_LOW("10006", "游戏币余额不足"),
    PARAM_IS_NULL("10007", "参数为空"),   // 需要明确提示
    STARTSEND_ERROR("10008", "播种失败：插入数据错误"),
    VERIFICATION_ERROR("10009", "用户申请的邀请码个数已经超过"),
    FOODS_LOW("10010", "粮食余额不足"),
    PARAM_ERROR("10011", "参数错误"),
    UP_SEED_ZERO("10012", "上级在投种子总额为0"),
    USER_IS_LOCK("10013", "登录失败,账号已被锁定"),
    PASSWORD_IS_ERROR("10014", "账号或密码错误"),
    PAY_PWD_IS_ERROR("10016", "安全密码错误"),
    EMAI_CODE_ERROR("10017", "邮箱验证码错误"),
    VERIFICATION_NO_EXIST("10018", "邀请码不存在"),
    VERIFICATION_USED("10019", "邀请码已经被使用"),
    PWD_ATYPISM("10020", "密码与确认密码不一致"),
    EMAIL_EXIST("10021", "邮箱已存在"),
    USERNAME_EXIST("10022", "用户名已存在"),
    STATIC_CODE_ILLEGAL("10023", "输入静态验证码"),
    STATIC_CODE_ERROR("10024", "静态验证码错误"),
    OUD_PWD_ERROR("10025", "旧密码错误"),
    OUD_PWD2_ERROR("10026", "密码与确认密码不一致"),
    OUD_PAY_PWD_FAIL("10027", "支付密码不能与登录密码一致"),
    PAY_PWD_FAIL("10028", "支付密码非法"),
    PAY_PWD2_FAIL("10029", "重复支付密码非法"),
    EMAIL_FAIL("10030", "邮件地址不能为空"),
    LOGIN_PWD_NULL("10031", "密码不能为空"),
    TRANSIONADDR_ERROR("10032", "收款方账户地址有误"),
    TRANSIONADDR_IS_THIS("10033", "不能给自己转账"),
    USER_IS_NO_UP_AND_DOWN("10034", "您与该用户无上级关系无法转账"),
    SEED_SPEC_LT_COUNT("10035", "只能购买%s及以上的规格"),
    SEED_SPEC_LT_MIN("10036", "本次最少要购买%s种子"),
    SEED_SPEC_GT_MAX("10037", "不能小于当前已投总额：%s"),
    CURRENCY_NUM_ERROR("10038", "转账金额格式错误，请输入正整数或小数"),
    PAY_LENGTH_ERROR("10039", "支付密码不得小于6位"),
    SIGN_INFO_FAIL("10040", "验证签名信息失败"),
    INSERT_INFO_FAIL("10041", "插入信息失败"),
    UPDATE_INFO_FAIL("10042", "修改信息失败"),
    USER_NOT_EXIST("10043", "该对应用户信息不存在"),
    LINK_AURORA_FAIL("10044", "对接极光接口失败"),
    TRANSFORMART_FAIL("10045", "传输格式错误"),
    LOGIN_IS_ERROR("10046", "登录失败"),
    FILE_NO_UPLOAD("10047", "只支持png或jpg格式的图片"),
    SEED_NUM_ERROR("10048", "请选择要购买的种子数量或规格"),
    GET_LIVE_INFO_FAIL("10049", "绑定live跑步账号失败"),
    BOUND_INFO_IS_EXIST("10050", "该用户已经绑定"),
    EMAIL_ADDR_NOT_NULL("10051", "邮箱地址不能为空"),
    EMAIL_CODE_NOT_NULL("10052", "邮箱验证码不能为空"),
    CURRENT_USER_BOUND_INFO_IS_EXIST("10053", "当前登录用户已经绑定"),
    LIVE_USER_LIVE_BOUND("10054", "该LIVE账户已经被绑定"),
    HAVE_NOT_JIGUANG_ACCOUNT("10055", "该用户没有极光平台账号"),
    AMOUNT_FORMAT_IS_FAIL("10056", "金币格式错误"),
    USER_SEED_IS_ZERO("10057", "当前未播种，无法获取邀请码"),
    AURORA_CODE_REQ_FAIL("10058", "获取极光验证码错误"),
    AURORA_CHECK_SIGN_FAIL("10059", "极光验证签名失败"),
    AURORA_NOT_SUPPORT_CURRENCY_TYPE("10060", "极光平台暂不支持该货币类型，请联系管理员"),
    PAY_SYS_IS_MAINTAIN("10061","服务器维护中，无法进行此操作"),
    FORM_IS_HANDLING("10062","正在处理中，请不要重复提交"),
    LIVE_INFO_IS_NONEXISTENT("10063", "live跑步账号不存在，请先注册账号"),
    LIVE_INFO_GET_FAIL("10064", "live跑步账号信息获取失败"),
    LIVE_AND_WF_NOT_SIZE_UP("10065", "live跑步账号与麦田圈账号不符"),
    AURORA_ACCOUNT_HAD_BOUND("10066", "极光账号已经绑定"),
    LOGIN_CHECK_ONE_STEP("10067", "登录第一步成功"),
    LOGIN_CHECK_SECOND_STEP("10068", "登录第二步成功"),
    ;

    StatusConstant(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }
    private String status;//状态
    private String desc;//描述

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


    public  String toString(StatusConstant constant){
        String json = "[%s]";
        StringBuffer sbf = new StringBuffer();
        sbf.append("{\"code\":").append(constant.getStatus()).append(",\"msg\":\"").append(constant.getDesc()).append("\"},").append("\n");
        return String.format(json,sbf.substring(0,sbf.length()-1));
    }

    @Override
    public  String toString(){
        String json = "[%s]";
        StringBuffer sbf = new StringBuffer();
        for(StatusConstant constant:StatusConstant.values()){
            sbf.append("{\"code\":").append(constant.getStatus()).append(",\"msg\":\"").append(constant.getDesc()).append("\"},");
        }
        return String.format(json,sbf.substring(0,sbf.length()-1));
    }
}
