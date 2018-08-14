package com.gaoan.forever.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoan.forever.base.AppException;
import com.gaoan.forever.base.BaseService;
import com.gaoan.forever.constant.MessageInfoConstant;
import com.gaoan.forever.entity.TbRoleEntity;
import com.gaoan.forever.entity.TbUserEntity;
import com.gaoan.forever.entity.TbUserRoleEntity;
import com.gaoan.forever.mapper.TbRoleMapper;
import com.gaoan.forever.mapper.TbUserMapper;
import com.gaoan.forever.mapper.TbUserRoleMapper;
import com.gaoan.forever.service.ITbUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 名称: TbUserServiceImpl 描述: 用户处理类 类型: JAVA
 * 
 */
@Service("TbUserServiceImpl")
public class TbUserServiceImpl extends BaseService<TbUserEntity> implements ITbUserService {

    private final Logger logger = LoggerFactory.getLogger(TbUserServiceImpl.class);

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbRoleMapper tbRoleMapper;

    @Autowired
    private TbUserRoleMapper tbUserRoleMapper;

    /**
     * 注册用户
     */
    @Override
    public void registerUser(String userName, String password, String realName) {
	if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
	    throw new AppException(MessageInfoConstant.LOGIN_USERNAME_PASSWORD_ISNULL);
	}

	if (StringUtils.isEmpty(realName)) {
	    throw new AppException(MessageInfoConstant.PLEASE_CHECK_PARAM);
	}

	userName = userName.trim();
	password = password.trim();
	realName = realName.trim();

	TbUserEntity queryUserEntity = new TbUserEntity();
	queryUserEntity.setUserName(userName);
	TbUserEntity userEntity = this.queryInfoByEntity(queryUserEntity);

	if (userEntity != null) {
	    throw new AppException(MessageInfoConstant.USERNAME_IS_EXIST);
	}

	if (password.length() < 6 || password.length() > 32) {
	    throw new AppException(MessageInfoConstant.THE_USER_PASSWORD_LENGTH);
	}

	userEntity = new TbUserEntity();
	userEntity.setUserName(userName);
	userEntity.setPassword(new Md5Hash(password, ByteSource.Util.bytes(userName)).toString());
	userEntity.setRealName(realName);

	// 新增用户
	int result = this.insertSelective(userEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

	// 新增默认角色
	TbUserRoleEntity userRoleEntity = new TbUserRoleEntity();
	userRoleEntity.setUserId(userEntity.getId());
	// TODO 默认角色
	userRoleEntity.setRoleId(1L);
	tbUserRoleMapper.insertSelective(userRoleEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}
    }

    /**
     * 用户登录
     */
    @Override
    public void login(String userName, String password) {
	if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)) {
	    throw new AppException(MessageInfoConstant.LOGIN_USERNAME_PASSWORD_ISNULL);
	}

	userName = userName.trim();
	password = password.trim();

	TbUserEntity queryUserEntity = new TbUserEntity();
	queryUserEntity.setUserName(userName);
	TbUserEntity userEntity = this.queryInfoByEntity(queryUserEntity);

	if (userEntity == null) {
	    throw new AppException(MessageInfoConstant.USER_INFO_IS_NOT_EXIST);
	}

	String mdPassword = new Md5Hash(password, ByteSource.Util.bytes(userName)).toString();
	if (!mdPassword.equals(userEntity.getPassword())) {
	    throw new AppException(MessageInfoConstant.USER_LOGIN_PASSWORD_CANNOT_BE_EMPTY);
	}
    }

    /**
     * 查询对应用户具有的权限
     */
    @Override
    public List<Map<String, Object>> queryUserResources(String userName) {
	List<Map<String, Object>> list = tbUserMapper.queryUserResources(userName);
	return list;
    }

    /**
     * 查询用户详情
     */
    @Override
    public Map<String, Object> queryUserDetail(Long userId) {
	Map<String, Object> map = tbUserMapper.queryUserDetail(userId);
	if(map == null || map.isEmpty()){
	    throw new AppException(MessageInfoConstant.UPDATE_INFO_DONT_EXIST);
	}
	return map;
    }

    @Override
    public PageInfo<TbUserEntity> getUserPageInfo(int page, int pageSize) {
	PageHelper.startPage(page, pageSize);
	List<TbUserEntity> list = tbUserMapper.queryAll(null);
	return new PageInfo<TbUserEntity>(list);
    }

    /**
     * 更新用户信息
     */
    @Transactional
    @Override
    public void updateUserInfo(Map<String, Object> map) {
	Integer id = (Integer) map.get("id");
	String userName = (String) map.get("userName");
	String password = (String) map.get("password");
	String realName = (String) map.get("realName");
	Integer status = (Integer) map.get("status");
	Integer roleId = (Integer) map.get("roleId");

	if (id == null || StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)
		|| StringUtils.isEmpty(realName) || status == null || roleId == null) {
	    throw new AppException(MessageInfoConstant.PLEASE_CHECK_PARAM);
	}

	userName = userName.trim();
	password = password.trim();
	realName = realName.trim();

	TbUserEntity queryUserEntity = new TbUserEntity();
	queryUserEntity.setUserName(userName);
	TbUserEntity userEntity = this.queryInfoByEntity(queryUserEntity);

	// 用户名已存在，且不是当前用户
	if (userEntity != null && userEntity.getId().longValue() != id.intValue()) {
	    throw new AppException(MessageInfoConstant.USERNAME_IS_EXIST);
	}

	if (password.length() < 6 || password.length() > 32) {
	    throw new AppException(MessageInfoConstant.THE_USER_PASSWORD_LENGTH);
	}

	// 修改用户信息
	userEntity = new TbUserEntity();
	userEntity.setId(Long.valueOf(id));
	userEntity.setUserName(userName);
	userEntity.setPassword(new Md5Hash(password, ByteSource.Util.bytes(userName)).toString());
	userEntity.setRealName(realName);
	userEntity.setStatus(status);
	int result = this.updateByPrimaryKeySelective(userEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

	TbRoleEntity roleEntity = tbRoleMapper.queryByPrimaryKey(Long.valueOf(roleId));
	if (roleEntity == null) {
	    throw new AppException(MessageInfoConstant.ROLE_INFO_IS_NOT_EXIST);
	}

	// 修改用户角色信息
	TbUserRoleEntity userRoleEntity = new TbUserRoleEntity();
	userRoleEntity.setUserId(Long.valueOf(id));
	userRoleEntity.setRoleId(Long.valueOf(roleId));
	result = tbUserRoleMapper.updateRoleByUserId(userRoleEntity);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}
    }

    /**
     * 删除用户信息
     */
    @Transactional
    @Override
    public void delUserInfo(Long userId) {
	// 删除用户信息
	int result = this.deleteByPrimaryKey(userId);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}

	// 删除用户角色信息
	result = tbUserRoleMapper.deleteByUserId(userId);
	if (result < 1) {
	    throw new AppException(MessageInfoConstant.COMMON_ERROR_CODE);
	}
    }

}