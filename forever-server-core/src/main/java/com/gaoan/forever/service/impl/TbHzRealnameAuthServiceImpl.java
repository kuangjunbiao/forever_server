package com.gaoan.forever.service.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gaoan.forever.base.BaseService;
import com.gaoan.forever.config.HZCustomConfig;
import com.gaoan.forever.dbmodel.HzRealnameAuthDbModel;
import com.gaoan.forever.entity.TbHzRealnameAuthEntity;
import com.gaoan.forever.mapper.TbHzRealnameAuthMapper;
import com.gaoan.forever.service.ITbHzRealnameAuthService;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * 名称: TbHzRealnameAuthServiceImpl 描述: 实名认证信息业务处理类 类型: JAVA
 * 
 * @since 2018-03-27
 * @author three
 */
@Service("tbHzRealnameAuthService")
public class TbHzRealnameAuthServiceImpl extends BaseService<TbHzRealnameAuthEntity>
	implements ITbHzRealnameAuthService {

    private final Logger logger = LoggerFactory.getLogger(TbHzRealnameAuthServiceImpl.class);

    @Autowired
    private TbHzRealnameAuthMapper hzRealnameAuthMapper;
    @Autowired
    public FastFileStorageClient fastFileStorageClient;

    @Autowired
    private ITbHzRealnameAuthService hzRealnameAuthService;

    @Autowired
    private HZCustomConfig config;

    private final int threadPoolMax = 10;
    private ExecutorService executorService = Executors.newFixedThreadPool(threadPoolMax);

    @Override
    public int updateUserAuthStatus(Long userId, int status, int lockStatus) {
	return hzRealnameAuthMapper.updateUserAuthStatus(userId, status, lockStatus);
    }

    @Override
    public TbHzRealnameAuthEntity getRealnameAuth(Long userId) {
	TbHzRealnameAuthEntity entity = new TbHzRealnameAuthEntity();
	entity.setUserId(userId);
	return hzRealnameAuthMapper.queryInfoByEntity(entity);
    }

    @Override
    public HzRealnameAuthDbModel queryByUserId(Long userId) {
	HzRealnameAuthDbModel model = hzRealnameAuthMapper.queryByUserId(userId);
	return model;
    }

    /**
     * 实名认证老数据升级
     */
    @Transactional
    @Override
    public void processRealNameAuth(MultipartFile file) {
	processInsideUser();
	// 护照实名认证的老数据,默认未认证
	// processPassportUser();

	executorService.execute(new Runnable() {
	    @Override
	    public void run() {
		try {
		    // importAuthResult(file);
		} catch (Exception e) {
		    logger.error(e.getMessage());
		}
	    }
	});
    }

    @Override
    public HzRealnameAuthDbModel queryInfoNew(TbHzRealnameAuthEntity realnameAuth) throws Exception {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void checkAuthInfo(TbHzRealnameAuthEntity realnameAuth, String operatorName, String operatorPhone) {
	// TODO Auto-generated method stub

    }

    @Override
    public void processInsideUser() {
	// TODO Auto-generated method stub

    }

    @Override
    public void processMakeysAuthResult(String[] arrs) {
	// TODO Auto-generated method stub

    }

    @Override
    public void processLostData(String[] arrs) {
	// TODO Auto-generated method stub

    }

    @Override
    public void syncMakeysAuthInfo(String hzUserName) {
	// TODO Auto-generated method stub

    }

    @Override
    public void processAuthInfo(String hzUserName) {
	// TODO Auto-generated method stub

    }

}