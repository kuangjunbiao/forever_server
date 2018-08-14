package com.gaoan.forever.service;

import com.gaoan.forever.base.IBaseService;
import com.gaoan.forever.entity.TbSalesOrderEntity;
import com.gaoan.forever.model.query.OrderQueryConditionModel;
import com.gaoan.forever.model.result.SalesOrderInfoModel;
import com.github.pagehelper.PageInfo;

/**
 * 名称: ITbSalesOrderService 描述: 出货信息Service接口 类型: JAVA
 * 
 */
public interface ITbSalesOrderService extends IBaseService<TbSalesOrderEntity> {

    public PageInfo<SalesOrderInfoModel> querySalesOrder(OrderQueryConditionModel condition, int page, int pageSize);

    public void insertSalesOrder(SalesOrderInfoModel order);

    public void updateSalesOrder(SalesOrderInfoModel order);

    public void delSalesOrder(Long orderId);
}