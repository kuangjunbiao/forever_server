package com.gaoan.forever.service;

import java.util.List;
import java.util.Map;

import com.gaoan.forever.base.IBaseService;
import com.gaoan.forever.entity.TbUserEntity;
import com.github.pagehelper.PageInfo;

/**
 * 名称: ITbUserService 描述: 用户信息Service接口 类型: JAVA
 * 
 */
public interface ITbUserService extends IBaseService<TbUserEntity> {

    public void registerUser(String userName, String password, String realName);

    public void login(String userName, String password);

    public List<Map<String, Object>> queryUserResources(String userName);

    public Map<String, Object> queryUserDetail(Long userId);

    public PageInfo<TbUserEntity> getUserPageInfo(int page, int pageSize);

    public void updateUserInfo(Map<String, Object> map);

    public void delUserInfo(Long userId);
}