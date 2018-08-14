package com.gaoan.forever.apiServer.controller.mobile;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaoan.forever.base.AppException;
import com.gaoan.forever.constant.MessageInfoConstant;
import com.gaoan.forever.model.Message;
import com.gaoan.forever.shiro.util.SmsUtil;
import com.gaoan.forever.utils.cache.CacheUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author three
 */
@RestController
@RequestMapping("/api/mobile")
@Api(value = "MobileSmsController", description = "前台-用户发送短信控制器")
public class MobileSmsController {

    private static final Logger logger = LoggerFactory.getLogger(MobileSmsController.class);

    /*@ApiOperation(value = "前端-手机发送短信（未登录）")
    @ApiImplicitParams(value = {
	    @ApiImplicitParam(name = "mobile", value = "用户手机号码", paramType = "query", dataType = "String"),
	    @ApiImplicitParam(name = "areatypeid", value = "手机归属地id", paramType = "query", dataType = "String"),
	    @ApiImplicitParam(name = "code", value = "静态验证码", paramType = "query", dataType = "String"),
	    @ApiImplicitParam(name = "sendtype", value = "发送类型(regist:注册，login:登录)", paramType = "query", dataType = "String") })
    @RequestMapping(value = "/sendsms", produces = "application/json;charset=UTF-8", method = { RequestMethod.POST })
    @ResponseBody
    public Object sendSms(HttpServletRequest request, String mobile, String areatypeid, String code, String sendtype)
	    throws Exception {

	// 是否启用短信
	if (tradeConfig.isSmsCode()) {
	    // 静态验证码判断
	    if (tradeConfig.isStaticCode()) {
		if (StringUtils.isEmpty(code)) {
		    throw new AppException(MessageInfoConstant.STATUS_CODE_CANT_BE_NULL);
		}
		// 忽略大小写
		if (!CacheUtils.validate(SecurityUtils.getSubject().getSession().getId().toString(),
			code.toLowerCase())) {
		    // 静态验证码错误
		    throw new AppException(MessageInfoConstant.STATUS_CODE_IS_ERROR);
		}
	    }
	}

	if (!StringUtils.isNum(areatypeid + "")) {
	    throw new AppException(MessageInfoConstant.PARAM_MUST_BE_MENBER);
	}

	// 判断地址编号是否存在
	TbMobileAreaEntity entity = mobileAreaService.queryByPrimaryKey(Long.parseLong(areatypeid));
	if (null == entity) {
	    throw new AppException(MessageInfoConstant.MOBILE_AREAS_IS_NOT_EXIST);
	}

	// 判断手机号码
	// 国内判断是否是手机号码
	if ("1".equals(areatypeid)) {
	    if (!StringUtils.isMobileNO(mobile)) {
		throw new AppException(MessageInfoConstant.DATAS_IS_NOT_MOBILE);
	    }
	} else {
	    // 国外判断是否是数字
	    if (!StringUtils.isNum(mobile)) {
		throw new AppException(MessageInfoConstant.DATAS_IS_NOT_MOBILE);
	    }
	}

	TbTradeUserEntity tradeUser = tradeUserService.queryInfoByUsername(mobile.trim());
	if (null == tradeUser) {
	    throw new AppException(MessageInfoConstant.ACCOUNT_OR_PASSWORD_IS_ERROR);
	}

	TbUserCenterBindEntity ucbe = new TbUserCenterBindEntity();
	ucbe.setUserId(tradeUser.getId());
	Long count = userCenterBindService.queryCount(ucbe);
	if (count > 0) {
	    throw new AppException(MessageInfoConstant.SAFE_CENTER_ISBANDMAKEYS);
	}

	// 开始发送短信
	String smscode = SmsUtil.getSmsCode();
	smsCodeService.sendSmsCode(sendtype, mobile, entity.getAreaCode(), smscode);

	logger.info("To send sms ... start ... ");
	Message.Builder builder = Message.newBuilder();

	logger.info("To send sms ... end ... ");
	return builder.builldJson();
    }*/

}
