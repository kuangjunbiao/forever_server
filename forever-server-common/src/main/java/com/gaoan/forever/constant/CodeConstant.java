package com.gaoan.forever.constant;

/**
 * 状态码常量
 * Created by three on 2017/4/12.
 */
public enum CodeConstant {
    SUCCESS("200","成功"),
    ERROR("400","失败");

    CodeConstant(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    private String status;//状态
    private String desc;//描述

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
