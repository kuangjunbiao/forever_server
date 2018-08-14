package com.gaoan.forever.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoan.forever.base.BaseService;
import com.gaoan.forever.entity.TbStockEntity;
import com.gaoan.forever.mapper.TbStockMapper;
import com.gaoan.forever.service.ITbStockService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 名称: TbStockServiceImpl 描述: 库存处理类 类型: JAVA
 * 
 */
@Service("TbStockServiceImpl")
public class TbStockServiceImpl extends BaseService<TbStockEntity> implements ITbStockService {

    private final Logger logger = LoggerFactory.getLogger(TbStockServiceImpl.class);

    @Autowired
    private TbStockMapper tbStockMapper;

    /**
     * 获取库存分页信息
     */
    @Override
    public PageInfo<TbStockEntity> getStockPageInfo(TbStockEntity queryEntity, int page, int pageSize) {
	PageHelper.startPage(page, pageSize);
	List<TbStockEntity> list = this.queryAll(queryEntity);
	return new PageInfo<TbStockEntity>(list);
    }

    @Override
    public PageInfo<String> queryPurchaseNameList(int page, int pageSize) {
	PageHelper.startPage(page, pageSize);
	List<String> list = tbStockMapper.queryPurchaseNameList();
	return new PageInfo<>(list);
    }

    @Override
    public PageInfo<String> queryGoodsList(String purchaseOrderName, int page, int pageSize) {
	PageHelper.startPage(page, pageSize);
	List<String> list = tbStockMapper.queryGoodsList(purchaseOrderName);
	return new PageInfo<>(list);
    }

}