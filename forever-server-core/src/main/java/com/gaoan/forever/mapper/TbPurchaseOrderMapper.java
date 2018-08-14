package com.gaoan.forever.mapper;

import java.util.List;

import com.gaoan.forever.base.BaseMapper;
import com.gaoan.forever.entity.TbPurchaseOrderEntity;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.model.result.PurchaseOrderInfoModel;

/**
 * 名称: TbPurchaseOrderMapper 描述: 进货Mapper接口 类型: JAVA
 */
public interface TbPurchaseOrderMapper extends BaseMapper<TbPurchaseOrderEntity> {

    public List<PurchaseOrderInfoModel> queryPurchaseOrder(OrderQueryConditionModel condition);
}