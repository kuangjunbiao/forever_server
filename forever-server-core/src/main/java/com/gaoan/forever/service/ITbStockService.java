package com.gaoan.forever.service;

import com.gaoan.forever.base.IBaseService;
import com.gaoan.forever.entity.TbStockEntity;
import com.github.pagehelper.PageInfo;

/**
 * 名称: ITbStockService 描述: 库存信息Service接口 类型: JAVA
 * 
 */
public interface ITbStockService extends IBaseService<TbStockEntity> {

    public PageInfo<TbStockEntity> getStockPageInfo(TbStockEntity queryEntity, int page, int pageSize);

    public PageInfo<String> queryPurchaseNameList(int page, int pageSize);

    public PageInfo<String> queryGoodsList(String purchaseOrderName, int page, int pageSize);

}