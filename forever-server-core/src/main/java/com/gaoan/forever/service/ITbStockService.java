package com.gaoan.forever.service;

import java.math.BigDecimal;
import java.util.List;

import com.gaoan.forever.base.IBaseService;
import com.gaoan.forever.entity.TbColorEntity;
import com.gaoan.forever.entity.TbSizeEntity;
import com.gaoan.forever.entity.TbStockEntity;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.vo.SalesOrderConditionReq;
import com.github.pagehelper.PageInfo;

/**
 * 名称: ITbStockService 描述: 库存信息Service接口 类型: JAVA
 * 
 */
public interface ITbStockService extends IBaseService<TbStockEntity> {

	PageInfo<TbStockEntity> getStockPageInfo(OrderQueryConditionModel conditionModel, int page, int pageSize);

	List<String> queryPurchaseNameList();

	List<String> queryGoodsList(String purchaseOrderName);

	/**
	 * 获取商品的吊牌价
	 * 
	 * @param conditionReq
	 * @return
	 */
	BigDecimal queryGoodsTagPrice(SalesOrderConditionReq conditionReq);

	/**
	 * 查询商品颜色信息
	 * 
	 * @param conditionReq
	 * @return
	 */
	List<TbColorEntity> queryGoodsColorList(SalesOrderConditionReq conditionReq);

	/**
	 * 查询商品尺寸信息
	 * 
	 * @param conditionReq
	 * @return
	 */
	List<TbSizeEntity> queryGoodsSizeList(SalesOrderConditionReq conditionReq);
}