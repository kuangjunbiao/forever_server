package com.gaoan.forever.model.export;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.gaoan.forever.log.spring.ExportColComment;

public class ExportWithdrawalRecordModel implements Serializable {

    private static final long serialVersionUID = 5683909231758437624L;

    @ExportColComment("导出状态")
    private String exportDesc;
    private String realName;
    private String mobile;
    @ExportColComment("会员")
    private String userName;
    @ExportColComment("账户状态")
    private String userStatusDesc;
    @ExportColComment("流水号")
    private String flowNo;
    @ExportColComment("币种")
    private String coinType;
    @ExportColComment("出金类型")
    private String withdrawalDesc;
    @ExportColComment("出金地址")
    private String outAddr;

    @ExportColComment("出金数量")
    private BigDecimal amount;
    @ExportColComment("手续费")
    private BigDecimal poundage;
    @ExportColComment("实际到账")
    private BigDecimal realArrived;

    @ExportColComment("状态")
    private String statusDesc;

    @ExportColComment("申请时间")
    private Date createTime;
    @ExportColComment("处理时间")
    private Date updateTime;
    @ExportColComment("备注")
    private String remark;
    @ExportColComment("transactionId")
    private String transactionId;

    public ExportWithdrawalRecordModel() {
    }

    public String getExportDesc() {
	return exportDesc;
    }

    public void setExportDesc(String exportDesc) {
	this.exportDesc = exportDesc;
    }

    public String getRealName() {
	return realName;
    }

    public void setRealName(String realName) {
	this.realName = realName;
    }

    public String getUserStatusDesc() {
	return userStatusDesc;
    }

    public void setUserStatusDesc(String userStatusDesc) {
	this.userStatusDesc = userStatusDesc;
    }

    public String getFlowNo() {
	return flowNo;
    }

    public void setFlowNo(String flowNo) {
	this.flowNo = flowNo;
    }

    public String getCoinType() {
	return coinType;
    }

    public void setCoinType(String coinType) {
	this.coinType = coinType;
    }

    public String getWithdrawalDesc() {
	return withdrawalDesc;
    }

    public void setWithdrawalDesc(String withdrawalDesc) {
	this.withdrawalDesc = withdrawalDesc;
    }

    public String getOutAddr() {
	return outAddr;
    }

    public void setOutAddr(String outAddr) {
	this.outAddr = outAddr;
    }

    public BigDecimal getAmount() {
	return amount;
    }

    public void setAmount(BigDecimal amount) {
	this.amount = amount;
    }

    public BigDecimal getPoundage() {
	return poundage;
    }

    public void setPoundage(BigDecimal poundage) {
	this.poundage = poundage;
    }

    public String getStatusDesc() {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
	this.statusDesc = statusDesc;
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

    public String getRemark() {
	return remark;
    }

    public void setRemark(String remark) {
	this.remark = remark;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public String getUserName() {
	if (realName == null && mobile == null) {
	    return null;
	}
	userName = "";
	String name = realName;
	String userMobile = mobile;
	if (StringUtils.isNotEmpty(name)) {
	    userName += name;
	}
	if (StringUtils.isNotEmpty(userMobile)) {
	    userName += "(" + userMobile + ")";
	}
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public BigDecimal getRealArrived() {
	return realArrived;
    }

    public void setRealArrived(BigDecimal realArrived) {
	this.realArrived = realArrived;
    }

    public String getTransactionId() {
	return transactionId;
    }

    public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
    }
}