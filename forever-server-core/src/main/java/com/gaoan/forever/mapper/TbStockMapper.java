package com.gaoan.forever.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gaoan.forever.base.BaseMapper;
import com.gaoan.forever.entity.TbColorEntity;
import com.gaoan.forever.entity.TbSizeEntity;
import com.gaoan.forever.entity.TbStockEntity;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.vo.SalesOrderConditionReq;

/**
 * 名称: TbStockMapper 描述: 库存Mapper接口 类型: JAVA
 */
public interface TbStockMapper extends BaseMapper<TbStockEntity> {

	List<TbStockEntity> queryStockList(OrderQueryConditionModel conditionModel);

	List<String> queryPurchaseNameList();

	List<String> queryGoodsList(@Param("purchaseOrderName") String purchaseOrderName);

	List<TbColorEntity> queryGoodsColorList(SalesOrderConditionReq conditionReq);

	List<TbSizeEntity> queryGoodsSizeList(SalesOrderConditionReq conditionReq);

	BigDecimal queryGoodsTagPrice(SalesOrderConditionReq conditionReq);
	
	int subtractQty(@Param("id") Long id, @Param("qty") Long qty);

	int addQty(@Param("id") Long id, @Param("qty") Long qty);

}