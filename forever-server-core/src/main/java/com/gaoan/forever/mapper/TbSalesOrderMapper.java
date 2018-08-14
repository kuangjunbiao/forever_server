package com.gaoan.forever.mapper;

import java.util.List;

import com.gaoan.forever.base.BaseMapper;
import com.gaoan.forever.entity.TbSalesOrderEntity;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.model.result.SalesOrderInfoModel;

/**
 * 名称: TbSalesOrderMapper 描述: 出货Mapper接口 类型: JAVA
 */
public interface TbSalesOrderMapper extends BaseMapper<TbSalesOrderEntity> {

    public List<SalesOrderInfoModel> querySalesOrder(OrderQueryConditionModel condition);

}