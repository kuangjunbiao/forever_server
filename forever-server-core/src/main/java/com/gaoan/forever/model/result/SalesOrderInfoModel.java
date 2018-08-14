package com.gaoan.forever.model.result;

import com.gaoan.forever.entity.TbSalesOrderEntity;

public class SalesOrderInfoModel extends TbSalesOrderEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1775949124325204299L;

    private String purchaseOrderName;
    private String goodsName;
    private String realName;

    public String getPurchaseOrderName() {
	return purchaseOrderName;
    }

    public void setPurchaseOrderName(String purchaseOrderName) {
	this.purchaseOrderName = purchaseOrderName;
    }

    public String getGoodsName() {
	return goodsName;
    }

    public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
    }

    public String getRealName() {
	return realName;
    }

    public void setRealName(String realName) {
	this.realName = realName;
    }

}