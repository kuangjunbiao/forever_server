package com.gaoan.forever.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.gaoan.forever.base.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 名称: TbSalesOrderEntity 描述: 出货订单表 类型: JAVA
 */
@ApiModel(value = "TbSalesOrderEntity", description = "出货订单表")
public class TbSalesOrderEntity extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9215448973981331258L;

    /** 编号 **/
    @ApiModelProperty("编号")
    private Long id;
    /** 商品名称 **/
    @ApiModelProperty("商品编号")
    private Long goodsId;
    /** 销售价 **/
    @ApiModelProperty("销售价")
    private BigDecimal sellPrice;
    /** 数量 **/
    @ApiModelProperty("数量")
    private Long quantity;
    /** 销售总额 **/
    @ApiModelProperty("销售总额")
    private BigDecimal total;
    /** 用户编号 **/
    @ApiModelProperty("用户编号")
    private Long userId;
    /** 创建时间 **/
    @ApiModelProperty("创建时间")
    private Date createTime;
    /** 修改时间 **/
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /**
     * 无参构造
     */
    public TbSalesOrderEntity() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getGoodsId() {
	return goodsId;
    }

    public void setGoodsId(Long goodsId) {
	this.goodsId = goodsId;
    }

    public BigDecimal getSellPrice() {
	return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
	this.sellPrice = sellPrice;
    }

    public Long getQuantity() {
	return quantity;
    }

    public void setQuantity(Long quantity) {
	this.quantity = quantity;
    }

    public BigDecimal getTotal() {
	return total;
    }

    public void setTotal(BigDecimal total) {
	this.total = total;
    }

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public Date getCreateTime() {
	return createTime;
    }

    public void setCreateTime(Date createTime) {
	this.createTime = createTime;
    }

    public Date getUpdateTime() {
	return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
    }

}