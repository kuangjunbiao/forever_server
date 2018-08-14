package com.gaoan.forever.apiServer.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import com.alibaba.fastjson.JSONObject;
import com.gaoan.forever.constant.UserConstant;

/**
 * Created by dotnar on 2017/4/17.
 */
public class SubjectUtils {

    private static final Logger logger = Logger.getLogger(SubjectUtils.class);

    /*public static TbTradeUserEntity getLoginUser() {

	TbTradeUserEntity entity = (TbTradeUserEntity) SecurityUtils.getSubject().getSession()
		.getAttribute(UserConstant.SESSION_LOGIN_USER_KEY);
	logger.info("获取登录用户信息：" + JSONObject.toJSONString(entity));
	return entity;
    }

    public static long getLoginId() {
	long uid = 0;
	TbTradeUserEntity userEntity = (TbTradeUserEntity) SecurityUtils.getSubject().getSession()
		.getAttribute(UserConstant.SESSION_LOGIN_USER_KEY);
	if (null != userEntity) {
	    uid = userEntity.getId();
	}
	logger.info("获取登录用户信息：" + JSONObject.toJSONString(userEntity));
	return uid;
    }

    public static void updateLoginUser(TbTradeUserEntity user) {
	Long userId = getLoginId();
	if (null != userId) {
	    logger.info("重置登录用户信息：" + JSONObject.toJSONString(user));
	    SecurityUtils.getSubject().getSession().setAttribute(UserConstant.SESSION_LOGIN_USER_KEY, user);
	}
    }

    public static void setSafeString(String systemId, String uuid) {
	String safeString = "systemId=" + systemId + "&uuid=" + uuid.trim();
	SafeQrcodeModel model = new SafeQrcodeModel();
	model.setSafeStr(safeString);
	model.setSystemId(systemId);
	model.setUuid(uuid);
	SecurityUtils.getSubject().getSession().setAttribute(UserConstant.SESSION_LOGIN_USER_SAFE_UUID, model);
    }

    public static SafeQrcodeModel getSafeString() {
	Object obj = SecurityUtils.getSubject().getSession().getAttribute(UserConstant.SESSION_LOGIN_USER_SAFE_UUID);
	return obj == null ? null : (SafeQrcodeModel) obj;
    }*/
}
