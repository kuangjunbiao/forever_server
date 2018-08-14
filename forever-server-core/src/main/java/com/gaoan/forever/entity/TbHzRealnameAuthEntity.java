package com.gaoan.forever.entity;

import java.io.Serializable;
import java.util.Date;

import com.gaoan.forever.base.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 名称: TbHzRealnameAuthEntity 描述: 实名认证 类型: JAVA
 * 
 * @since 2018-03-26
 * @author DELL
 */
@SuppressWarnings("serial")
@ApiModel(value = "TbHzRealnameAuthEntity", description = "实名认证请求")
public class TbHzRealnameAuthEntity extends BaseEntity implements Serializable {
    /** 编号 **/
    @ApiModelProperty("编号")
    private Long id;
    /** 用户编号 **/
    @ApiModelProperty("用户编号")
    private Long userId;
    /** 用户真实姓名 **/
    @ApiModelProperty("用户真实姓名")
    private String realName;
    /** 性别 1男性，0女性 **/
    @ApiModelProperty("性别,1:男性, 0:女性")
    private Integer sex;
    /** tb_auth_id_type 表的id **/
    @ApiModelProperty("tb_auth_id_type表的id")
    private Long idTypeId;
    /** 用户身份证号码 **/
    @ApiModelProperty("用户身份证号码")
    private String idNum;
    /** 身份证正面图片地址 **/
    @ApiModelProperty("身份证正面图片地址")
    private String idPositiveImg;
    /** 身份证背面图片地址 **/
    @ApiModelProperty("身份证背面图片地址")
    private String idReverseImg;
    /** 用户手持身份证图片 **/
    @ApiModelProperty("用户手持身份证图片地址")
    private String idOnHandImg;
    /** 手持证件和银行卡图片 **/
    @ApiModelProperty("手持证件和银行卡图片地址")
    private String idBankOnHandImg;
    /** 证件开始时间 **/
    @ApiModelProperty("证件开始时间")
    private Date validityStartDate;
    /** 证件失效时间 **/
    @ApiModelProperty("证件失效时间")
    private Date validityEndDate;
    /** 银行卡号 **/
    @ApiModelProperty("银行卡号")
    private String bankNum;
    /** 国家地区id，tb_mobile_area 的id字段 **/
    @ApiModelProperty("国家地区id, tb_mobile_area的id字段")
    private Long areaId;
    /** 状态, 0:安全中心未认证, 1:安全中心已认证, 2:安全中心认证失败, 3:银行卡未认证, 4:银行卡已认证, 5:银行卡认证失败 **/
    @ApiModelProperty("状态, 0:安全中心未认证, 1:安全中心已认证, 2:安全中心认证失败, 3:银行卡未认证, 4:银行卡已认证, 5:银行卡认证失败")
    private Integer status;
    /** 备注 **/
    @ApiModelProperty("备注")
    private String remark;
    /** 身份证审核时间 **/
    @ApiModelProperty("身份证审核时间")
    private Date idReviewTime;
    /** 银行卡审核时间 **/
    @ApiModelProperty("银行卡审核时间")
    private Date bankReviewTime;
    /** 创建时间 **/
    @ApiModelProperty("创建时间")
    private Date createTime;
    /** 修改时间 **/
    @ApiModelProperty("修改时间")
    private Date updateTime;

    /* 非表字段，页面查询条件 */

    /**
     * 无参构造
     */
    public TbHzRealnameAuthEntity() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getUserId() {
	return userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public String getRealName() {
	return realName;
    }

    public void setRealName(String realName) {
	this.realName = realName;
    }

    public Integer getSex() {
	return sex;
    }

    public void setSex(Integer sex) {
	this.sex = sex;
    }

    public Long getIdTypeId() {
	return idTypeId;
    }

    public void setIdTypeId(Long idTypeId) {
	this.idTypeId = idTypeId;
    }

    public String getIdNum() {
	return idNum;
    }

    public void setIdNum(String idNum) {
	this.idNum = idNum;
    }

    public String getIdPositiveImg() {
	return idPositiveImg;
    }

    public void setIdPositiveImg(String idPositiveImg) {
	this.idPositiveImg = idPositiveImg;
    }

    public String getIdReverseImg() {
	return idReverseImg;
    }

    public void setIdReverseImg(String idReverseImg) {
	this.idReverseImg = idReverseImg;
    }

    public String getIdOnHandImg() {
	return idOnHandImg;
    }

    public void setIdOnHandImg(String idOnHandImg) {
	this.idOnHandImg = idOnHandImg;
    }

    public String getIdBankOnHandImg() {
	return idBankOnHandImg;
    }

    public void setIdBankOnHandImg(String idBankOnHandImg) {
	this.idBankOnHandImg = idBankOnHandImg;
    }

    public Date getValidityStartDate() {
	return validityStartDate;
    }

    public void setValidityStartDate(Date validityStartDate) {
	this.validityStartDate = validityStartDate;
    }

    public Date getValidityEndDate() {
	return validityEndDate;
    }

    public void setValidityEndDate(Date validityEndDate) {
	this.validityEndDate = validityEndDate;
    }

    public String getBankNum() {
	return bankNum;
    }

    public void setBankNum(String bankNum) {
	this.bankNum = bankNum;
    }

    public Long getAreaId() {
	return areaId;
    }

    public void setAreaId(Long areaId) {
	this.areaId = areaId;
    }

    public Integer getStatus() {
	return status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
    }

    public Date getIdReviewTime() {
	return idReviewTime;
    }

    public void setIdReviewTime(Date idReviewTime) {
	this.idReviewTime = idReviewTime;
    }

    public Date getBankReviewTime() {
	return bankReviewTime;
    }

    public void setBankReviewTime(Date bankReviewTime) {
	this.bankReviewTime = bankReviewTime;
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