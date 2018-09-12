package com.gaoan.forever.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

/**
 * @author ym
 * @version Version 1.0
 */
@ApiModel(value = "SalesOrderConditionReq", description = "销售订单查询条件")
public class SalesOrderConditionReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1939263711338025263L;

	private String purchaseOrderName;
	private String goodsName;
	private Long colorId;
	private Long sizeId;

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

	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public void setSizeId(Long sizeId) {
		this.sizeId = sizeId;
	}

}
