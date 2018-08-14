package com.gaoan.forever.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.gaoan.forever.base.AppException;
import com.gaoan.forever.config.UserCenterApiConfig;
import com.gaoan.forever.constant.LanguageConstant;
import com.gaoan.forever.constant.MessageInfoConstant;
import com.gaoan.forever.constant.SafeCodeConstant;
import com.gaoan.forever.constant.ForeverConstant;
import com.gaoan.forever.model.safecenter.SafeApiLoginRespModel;
import com.gaoan.forever.utils.encryption.MD5Util;
import com.gaoan.forever.utils.http.HttpClient;

public class UserCenterApiUtil {

    private static final Logger logger = LoggerFactory.getLogger(UserCenterApiUtil.class);

    public static SafeApiLoginRespModel safeLogin(UserCenterApiConfig config, String username, String password,
	    String code) throws Exception {
	SafeApiLoginRespModel salr = loginByUserPass(config.getApiloginpass(), username.trim(), password.trim(),
		config.getSystemid());
	if (!salr.isStatus()) {
	    logger.error("安全中心密码登录失败！");
	    throw new AppException(MessageInfoConstant.THE_USER_PASSWORD_MISTAKE, salr.getMsg(), true);
	}

	Map<String, Object> verify = verifycode(config.getApiVerifycode(), username.trim(), code.trim(),
		config.getSystemid(), ForeverConstant.SAFECENTER_API_VERIFICATIONTYPE_LOGIN, "登录");
	if (!((boolean) verify.get("isok"))) {
	    logger.error(verify.get("msg").toString());
	    throw new AppException(MessageInfoConstant.SAVLE_VAR_CODE_NOT_PASS, verify.get("msg").toString(), true);
	}
	return salr;
    }

    public static SafeApiLoginRespModel loginByUserPass(String reqUrl, String username, String password,
	    String systemId) throws Exception {
	boolean bool = false;
	String nonce = RandomStringUtils.random(32, true, true);
	DSASignUtil dsaSignUtils = new DSASignUtil();
	Map<String, Object> map = new HashMap<>();
	password = MD5Util.getMD5(password.getBytes());
	map.put("nonce", nonce);
	map.put("password", password);
	map.put("username", username);
	map.put("systemId", systemId);
	String sign = dsaSignUtils.sign(map);
	String content = "{\"nonce\": \"" + nonce + "\",\"password\": \"" + password + "\",\"sign\": \"" + sign
		+ "\",\"systemId\": \"" + systemId + "\",\"username\": \"" + username + "\"}";
	logger.info(content);
	String resp = HttpClient.postJsonF(reqUrl, content);
	if (StringUtils.isBlank(resp)) {
	    return null;
	}
	logger.info(resp);
	JSONObject resultJson = JSONObject.parseObject(resp);
	String code = resultJson.getString("code");
	JSONObject data = resultJson.getJSONObject("data");
	bool = SafeCodeConstant.SAFE_CENTER_APICODE_SUCCESS.getStatus().equals(code);
	SafeApiLoginRespModel m = new SafeApiLoginRespModel();
	m.setStatus(bool);
	if (bool) {
	    m.setNationCode(data.getString("nationCode"));
	    m.setMobile(data.getString("mobile"));
	    m.setFlag(data.getString("flag"));
	}
	SafeCodeConstant scc = SafeCodeConstant.getCodeMsgByCode(code.trim());
	if (scc != null) {
	    LanguageConstant lc = LanguageConstant.getLanguageByCode(scc.name());
	    m.setMsg(lc != null ? lc.getMsg() : scc.getDesc());
	}
	return m;
    }

    public static String getQRCode(String reqUrl, String reqSysId) throws Exception {
	String uuid = null;
	String nonce = RandomStringUtils.random(32, true, true);
	DSASignUtil dsaSignUtils = new DSASignUtil();
	Map<String, Object> map = new HashMap<>();
	map.put("nonce", nonce);
	map.put("reqSysId", reqSysId);
	String sign = dsaSignUtils.sign(map);
	String content = "{\"nonce\": \"" + nonce + "\",\"reqSysId\": \"" + reqSysId + "\",\"sign\": \"" + sign + "\"}";
	logger.info(content);
	String resp = HttpClient.postJsonF(reqUrl, content);
	logger.info(resp);
	if (StringUtils.isBlank(resp)) {
	    return uuid;
	}
	JSONObject resultJson = JSONObject.parseObject(resp);
	String respcode = resultJson.getString("code");
	if (StringUtils.isBlank(respcode)) {
	    return null;
	}
	if (respcode.trim().equals("20000")) {
	    uuid = resultJson.getJSONObject("data").getString("uuid");
	    if (StringUtils.isBlank(uuid)) {
		return null;
	    }
	}
	return uuid;
    }

    public static void main(String[] args) throws Exception {
	// String url =
	// "http://110.79.11.5:80/user-safe-api/user/loginByUserPass";
	// logger.info(UserCenterApiUtil.loginByUserPass(url,
	// "mail@qeveworld.com", MD5Util.getMD5("123456".getBytes()), "1011"));
	// String url2 = "http://110.79.11.5:80/user-safe-api/safe/getQRCode";
	// logger.info(UserCenterApiUtil.getQRCode(url2,"1011"));
    }

    /**
     * @param reqUrl
     * @param username
     * @param systemId
     * @return true: 已绑定 false:未绑定
     * @throws Exception
     */
    public static boolean hasBindMobile(String reqUrl, String username, String systemId) throws Exception {
	// 查询账号是否绑定了手机号(20005用户不存在|10508未绑定手机|20000已绑定手机
	boolean bool = false;
	String nonce = RandomStringUtils.random(32, true, true);
	DSASignUtil dsaSignUtils = new DSASignUtil();
	Map<String, Object> map = new HashMap<>();
	map.put("nonce", nonce);
	map.put("username", username);
	map.put("reqSysId", systemId);
	String sign = dsaSignUtils.sign(map);
	map.put("sign", sign);
	String content = "{\"nonce\": \"" + nonce + "\",\"sign\": \"" + sign + "\",\"reqSysId\": \"" + systemId
		+ "\",\"username\": \"" + username + "\"}";
	String resp = HttpClient.postJsonF(reqUrl, content);
	if (StringUtils.isBlank(resp)) {
	    return bool;
	}
	logger.info(resp);
	JSONObject resultJson = JSONObject.parseObject(resp);
	String code = resultJson.getString("code");
	if (StringUtils.isBlank(code)) {
	    return bool;
	}
	bool = code.trim().equals("20000");
	logger.info("校验账号是否绑定手机：请求参数" + content + "-->响应：" + code);
	return bool;
    }

    /**
     * 
     * @param reqUrl
     * @param username
     * @param mobile
     * @param systemId
     * @return 0:成功 1：手机号已被绑定 2：用户不存在 -1：异常
     * @throws Exception
     */
    public static int boundMobile(String reqUrl, String username, String prefix, String mobile, String systemId)
	    throws Exception {
	// 手机号已被绑定： 10511
	// 用户不存在： 20005
	// 修改成功： 20000
	int result = 0;
	String nonce = RandomStringUtils.random(32, true, true);
	DSASignUtil dsaSignUtils = new DSASignUtil();
	Map<String, Object> map = new HashMap<>();
	map.put("nonce", nonce.trim());
	map.put("username", username.trim());
	map.put("mobile", mobile.trim());
	map.put("reqSysId", systemId.trim());
	map.put("nationCode", prefix.trim());
	String sign = dsaSignUtils.sign(map);
	map.put("sign", sign);
	String content = "{\"nonce\": \"" + nonce + "\",\"nationCode\":\"" + prefix.trim() + "\",\"mobile\":\""
		+ mobile.trim() + "\",\"sign\": \"" + sign + "\",\"reqSysId\": \"" + systemId + "\",\"username\": \""
		+ username + "\"}";
	logger.info("账号执行绑定手机：请求参数" + content);
	String resp = HttpClient.postJsonF(reqUrl, content);
	if (StringUtils.isBlank(resp)) {
	    return -1;
	}
	logger.info(resp);
	JSONObject resultJson = JSONObject.parseObject(resp);
	String code = resultJson.getString("code");
	if (StringUtils.isBlank(code)) {
	    return -1;
	}
	if (code.trim().equals("20000"))
	    result = 0;
	if (code.trim().equals("10511"))
	    result = 1;
	if (code.trim().equals("20005"))
	    result = 2;
	if (!(code.trim().equals("20000") || code.trim().equals("10511") || code.trim().equals("20005")))
	    result = -1;
	logger.info("账号执行绑定手机：请求参数" + content + "-->响应：" + code);
	return result;
    }

    public static Map<String, Object> verifycode(String reqUrl, String username, String code, String systemId,
	    Integer type, String desc) {
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("isok", false);
	result.put("msg", "校验安全锁动态码失败");
	boolean bool = false;
	String msg = "";
	try {
	    DSASignUtil dsaSignUtils = new DSASignUtil();
	    String nonce = RandomStringUtils.random(32, true, true);
	    Map<String, Object> map = new HashMap<>();
	    map.put("nonce", nonce.trim());
	    map.put("username", username.trim());
	    map.put("passcode", code.trim());
	    map.put("reqSysId", systemId.trim());
	    map.put("verificationType", type.toString());// 1为登录 2为支付
	    map.put("verificationDesc", desc.trim());
	    String sign = dsaSignUtils.sign(map);
	    map.put("sign", sign);
	    String content = JSONObject.toJSONString(map);
	    String resp = HttpClient.postJsonF(reqUrl, content);
	    logger.info("校验安全锁动态码返回：-->" + resp);
	    JSONObject resultJson = JSONObject.parseObject(resp);
	    String rescode = resultJson.getString("code");

	    if (SafeCodeConstant.SAFE_CENTER_APICODE_SUCCESS.getStatus().equals(rescode.trim()))
		bool = true;
	    SafeCodeConstant scc = SafeCodeConstant.getCodeMsgByCode(rescode.trim());
	    if (scc != null) {
		LanguageConstant lc = LanguageConstant.getLanguageByCode(scc.name());
		msg = lc != null ? lc.getMsg() : scc.getDesc();
	    }
	} catch (Exception e) {
	    logger.error("验证安全中心动态码异常！", e);
	}
	result.put("isok", bool);
	result.put("msg", msg);
	return result;
    }

    public static JSONObject getAuthInfo(String reqUrl, String username, String systemId) {
	JSONObject result = null;

	try {
	    DSASignUtil dsaSignUtils = new DSASignUtil();
	    String nonce = RandomStringUtils.random(32, true, true);
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("nonce", nonce.trim());
	    map.put("username", username.trim());
	    map.put("reqSysId", systemId.trim());
	    String sign = dsaSignUtils.sign(map);
	    map.put("sign", sign);
	    String content = JSONObject.toJSONString(map);

	    String resp = HttpClient.postJsonF(reqUrl, content);
	    logger.info("查询认证信息返回：-->" + resp);

	    JSONObject resultJson = JSONObject.parseObject(resp);
	    String rescode = resultJson.getString("code");

	    if (SafeCodeConstant.SAFE_CENTER_APICODE_SUCCESS.getStatus().equals(rescode.trim())) {
		result = resultJson.getJSONObject("data");
		// String status = data.getString("status");
		// 安全中心实名认证状态 （1已认证，2未认证，3已过期，4待审核，5认证失败)
		// if ("1".equals(status)) {
		// }
	    } else {
		SafeCodeConstant scc = SafeCodeConstant.getCodeMsgByCode(rescode);
		throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE, scc.getDesc());
	    }
	} catch (Exception e) {
	    logger.error("从安全锁获取认证信息异常", e);
	}

	return result;
    }
}
