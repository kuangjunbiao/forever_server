package com.gaoan.forever.apiServer.controller.base;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gaoan.forever.base.AppException;
import com.gaoan.forever.constant.MessageInfoConstant;
import com.gaoan.forever.constant.RedisConstant;
import com.gaoan.forever.model.Message;
import com.gaoan.forever.model.weixin.TestMessage;
import com.gaoan.forever.util.MessageUtil;
import com.gaoan.forever.util.SHA1;
import com.gaoan.forever.utils.cache.CacheUtils;
import com.gaoan.forever.utils.file.FastDFSFileUtil;
import com.github.tobato.fastdfs.domain.StorePath;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by NO.9527 on 2017年7月15日
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "BaseController", description = "Base控制器")
public class BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private static final int banklist_page = 1;

	private static final int banklist_page_size = 100;

	@ApiOperation(value = "后台-未授权")
	@RequestMapping(value = "/unauthorized")
	@ApiIgnore
	@ResponseBody
	public Object unauthorized(HttpServletRequest request) throws Exception {
		logger.debug("URL请求未授权！");
		throw new AppException(MessageInfoConstant.URL_UNAUTHORIZED);
	}

	@ApiOperation(value = "后台-文件上传")
	@RequestMapping(value = "/uploadFile", produces = "application/json;charset=UTF-8", method = { RequestMethod.POST })
	@ResponseBody
	public Object uploadFile(HttpServletRequest request,
			@ApiParam("文件") @RequestParam(required = true) MultipartFile file) throws Exception {
		StorePath sp = FastDFSFileUtil.uploadFile(file);
		Message.Builder builder = Message.newBuilder();
		builder.put("url", FastDFSFileUtil.getResAccessUrl(sp));
		return builder.builldJson();
	}

	@ApiOperation(value = "后台-图片上传并创建缩略图")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "isThumbnails", value = "是否创建缩略图0:不创建，1：创建", paramType = "query", dataType = "int", required = false), })
	@RequestMapping(value = "/uploadImage", produces = "application/json;charset=UTF-8", method = {
			RequestMethod.POST })
	@ResponseBody
	public Object uploadImage(HttpServletRequest request,
			@ApiParam("文件") @RequestParam(required = true) MultipartFile file,
			@RequestParam(required = false, defaultValue = "") int isThumb) throws Exception {
		StorePath sp = isThumb == 0 ? FastDFSFileUtil.uploadFile(file)
				: FastDFSFileUtil.uploadImageAndCrtThumbImage(file);

		String extension = "." + FilenameUtils.getExtension(sp.getFullPath());
		String thumbnailsSize = "_" + FastDFSFileUtil.Thumbnails_width + "x" + FastDFSFileUtil.Thumbnails_height
				+ extension;
		String url = FastDFSFileUtil.getResAccessUrl(sp);
		String thumbnailsUrl = url.substring(0, url.lastIndexOf(extension)) + thumbnailsSize;

		Message.Builder builder = Message.newBuilder();
		builder.put("url", url);
		builder.put("thumbnailsUrl", thumbnailsUrl);
		return builder.builldJson();
	}

	@ApiOperation(value = "后台-获得省市县信息")
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "type", value = "类型：0：省(省级市)列表，1：获得市县列表", paramType = "query", dataType = "int", required = true),
			@ApiImplicitParam(name = "pid", value = "省份id,当type等于1时 pid不能为空", paramType = "query", dataType = "String", required = false), })
	@RequestMapping(value = "/getAreas", produces = "application/json;charset=UTF-8", method = { RequestMethod.POST })
	@ResponseBody
	public Object getAreas(HttpServletRequest request, @RequestParam(required = true) int type,
			@RequestParam(required = false, defaultValue = "") String pid) throws Exception {
		if (type != 0 && type != 1) {
			throw new AppException(MessageInfoConstant.WEBNOTIFY_TYPE_PARAM_ERROR);
		}
		// int level_country = 1;//国家
		int id_country = 1;
		int level_province = 2;// 省
		int level_city = 3;// 市
		//// 级别 1：国家 2:省和省级市 3：县市
		Integer level = level_province;
		if (type == 0) {
			level = level_province;
			pid = String.valueOf(id_country);
		} else if (type == 1) {
			level = level_city;
			if (StringUtils.isBlank(pid)) {
				throw new AppException(MessageInfoConstant.WEBNOTIFY_TYPE_PARAM_ERROR);
			}
		}
		;
		String key = MessageFormat.format(RedisConstant.KEY_HZ_CHINA_AREA_PREFIX + "{0}_{1}", level, pid);
		List<Object> areas = processAreas(key);
		Message.Builder builder = Message.newBuilder();
		builder.put("list", areas);
		return builder.builldJson();
	}

	@ApiOperation(value = "前台-获取银行类型列表")
	@RequestMapping(value = "/bank_list", produces = "application/json;charset=UTF-8", method = { RequestMethod.POST })
	@ResponseBody
	public Object list(HttpServletRequest request) throws Exception {
		// PageInfo<Map<String, Object>> pageInfo =
		// bankTypeService.selectByPage(null, banklist_page,
		// banklist_page_size);
		// return pageInfo.getList();
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<Object> processAreas(String key) {
		List<Object> result = new ArrayList<Object>();
		Map<String, Object> areas = (Map<String, Object>) CacheUtils.getHashOps(key);
		for (Map.Entry<String, Object> area : areas.entrySet()) {
			result.add(area.getValue());
		}
		return result;
	}

	@ApiOperation(value = "前台-服务暂停")
	@RequestMapping(value = "/serverStop", produces = "application/json;charset=UTF-8", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public Object serverStop(HttpServletRequest request) throws Exception {
		logger.info("服务暂停，升级或维护中");
		throw new AppException(MessageInfoConstant.STOP_SERVER);
	}

	@ApiOperation(value = "获得有效币种列表")
	@ApiImplicitParams(value = {})
	@RequestMapping(value = "/useingCoins", produces = "application/json;charset=UTF-8", method = {
			RequestMethod.POST })
	@ResponseBody
	public Object useingCoins(HttpServletRequest request) throws Exception {
		logger.info("start to search ... ");
		return null;
	}

	@ApiOperation(value = "公众号对接")
	@ApiImplicitParams(value = {})
	@RequestMapping(value = "/test", produces = "application/json;charset=UTF-8", method = { RequestMethod.POST })
	@ResponseBody
	public Object test(HttpServletRequest request) throws Exception {
		// String signature = request.getParameter("signature");
		// String echostr = request.getParameter("echostr");
		// String timestamp = request.getParameter("timestamp");
		// String nonce = request.getParameter("nonce");
		//
		// List<String> params = new ArrayList<String>();
		// params.add("forever2");
		// params.add(timestamp);
		// params.add(nonce);
		//
		// Collections.sort(params);
		//
		// StringBuffer content = new StringBuffer();
		// for (int i = 0; i < params.size(); i++) {
		// content.append(params.get(i));
		// }
		//
		// logger.info("str = " + content);
		//
		// String result = "";
		// if (SHA1.encode(content.toString()).equals(signature)) {
		// logger.info("校验成功");
		// result = echostr;
		// }
		//
		// return result;

		String str = null;
		try {
			// 将request请求，传到Message工具类的转换方法中，返回接收到的Map对象
			Map<String, String> map = MessageUtil.xmlToMap(request);
			// 从集合中，获取XML各个节点的内容

			String ToUserName = map.get("ToUserName");

			String FromUserName = map.get("FromUserName");

			String CreateTime = map.get("CreateTime");

			String MsgType = map.get("MsgType");

			String Content = map.get("Content");

			String MsgId = map.get("MsgId");

			if (MsgType.equals("text")) {// 判断消息类型是否是文本消息(text)

				TestMessage message = new TestMessage();

				message.setFromUserName(ToUserName);// 原来【接收消息用户】变为回复时【发送消息用户】

				message.setToUserName(FromUserName);

				message.setMsgType("text");

				message.setCreateTime(new Date().getTime());// 创建当前时间为消息时间

				message.setContent("您好，" + FromUserName + "\n我是：" + ToUserName

						+ "\n您发送的消息类型为：" + MsgType + "\n您发送的时间为" + CreateTime

						+ "\n我回复的时间为：" + message.getCreateTime() + "您发送的内容是" + Content);

				str = MessageUtil.objectToXml(message); // 调用Message工具类，将对象转为XML字符串

			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return str;
	}

}
