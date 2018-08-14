package com.gaoan.forever.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.gaoan.forever.base.IBaseService;
import com.gaoan.forever.dbmodel.HzRealnameAuthDbModel;
import com.gaoan.forever.entity.TbHzRealnameAuthEntity;
import com.github.pagehelper.PageInfo;

/**
 * 名称: ITbHzRealnameAuthService 描述: 实名认证信息Service接口 类型: JAVA
 * 
 * @since 2017-07-05 16:08:49
 * @author three
 */
public interface ITbHzRealnameAuthService extends IBaseService<TbHzRealnameAuthEntity> {

	HzRealnameAuthDbModel queryByUserId(Long userId);

	/**
	 * 用户获取最新实名请求
	 * 
	 * @param realnameAuth
	 * @return
	 * @throws Exception
	 */
	public HzRealnameAuthDbModel queryInfoNew(TbHzRealnameAuthEntity realnameAuth) throws Exception;

	/**
	 * 获取用户认证信息
	 * 
	 * @param userId
	 * @return
	 */
	public TbHzRealnameAuthEntity getRealnameAuth(Long userId);

	public void checkAuthInfo(TbHzRealnameAuthEntity realnameAuth, String operatorName, String operatorPhone);

	public void processRealNameAuth(MultipartFile file);
	
	public void processInsideUser();

	public void processMakeysAuthResult(String[] arrs);

	public void processLostData(String[] arrs);
	
	public void syncMakeysAuthInfo(String hzUserName);

	public void processAuthInfo(String hzUserName);

	public int updateUserAuthStatus(Long userId, int status, int lockStatus);
}