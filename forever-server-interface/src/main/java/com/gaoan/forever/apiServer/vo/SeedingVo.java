package com.gaoan.forever.apiServer.vo;

/**
 * Created by dotnar on 2017/4/18.
 */
public class SeedingVo {

    private Long uid;
    private Integer number; // 种子规格
    private Integer num; // 数量

    public Long getUid() {
	return uid;
    }

    public void setUid(Long uid) {
	this.uid = uid;
    }

    public Integer getNumber() {
	return number;
    }

    public void setNumber(Integer number) {
	this.number = number;
    }

    public Integer getNum() {
	return num;
    }

    public void setNum(Integer num) {
	this.num = num;
    }
}
