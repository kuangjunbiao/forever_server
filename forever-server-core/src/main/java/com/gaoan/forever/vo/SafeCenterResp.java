package com.gaoan.forever.vo;

import com.alibaba.fastjson.JSONObject;
import com.gaoan.forever.constant.SafeCodeConstant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基本响应对象
 * Created by longshengtang on 2017/4/7.
 */
@ApiModel("基本响应信息")
public class SafeCenterResp<T> {
	
    @SuppressWarnings("unchecked")
	public static <U> SafeCenterResp<U> build(U data) {
        return new SafeCenterResp<>(data).setSuccess();
    }

    /**
     * 用于判定返回码是否为200
     *
     * @return 如果this.code值为200或者200返回true；反之返回false
     */
    @ApiModelProperty(value = "返回是否成功", dataType = "boolean", position = 3)
    public boolean isOk() {
        return SafeCodeConstant.COMMON_SUCCESS.getStatus().equals(this.code) || "200".equals(this.code) || "SUCCESS".equals(this.code);
    }

    public SafeCenterResp() {
        this(SafeCodeConstant.COMMON_SUCCESS);
    }

    public SafeCenterResp(SafeCodeConstant statusConstant) {
        this.setInfo(statusConstant);
    }

    /**
     * 构建成功时候返回的dto
     *
     * @return 返回Dto
     */
    @SuppressWarnings("rawtypes")
	public static SafeCenterResp buildSuccess() {
        SafeCenterResp dto = new SafeCenterResp();
        dto.setCode(SafeCodeConstant.COMMON_SUCCESS.getStatus());
        dto.setMsg(SafeCodeConstant.COMMON_SUCCESS.getDesc());
        return dto;
    }
    
    @SuppressWarnings("rawtypes")
	public static SafeCenterResp buildStatus(SafeCodeConstant code) {
        SafeCenterResp dto = new SafeCenterResp();
        dto.setCode(code.getStatus());
        dto.setMsg(code.getDesc());
        return dto;
    }
    
    @SuppressWarnings("rawtypes")
  	public static SafeCenterResp buildStatus(SafeCodeConstant code,String msg) {
          SafeCenterResp dto = new SafeCenterResp();
          dto.setCode(code.getStatus());
          dto.setMsg(msg);
          return dto;
      }
    

    /**
     * 构建失败时候返回的dto
     *
     * @return 返回Dto
     */
    @SuppressWarnings("rawtypes")
	public static SafeCenterResp buildFail() {
        SafeCenterResp dto = new SafeCenterResp();
        dto.setCode(SafeCodeConstant.COMMON_FAILED.getStatus());
        dto.setMsg(SafeCodeConstant.COMMON_FAILED.getDesc());
        return dto;
    }

    /**
     * 构建失败时候返回的dto
     *
     * @return 返回Dto
     */
    @SuppressWarnings("rawtypes")
	public static SafeCenterResp buildFail(String msg) {
        SafeCenterResp dto = new SafeCenterResp();
        dto.setCode(SafeCodeConstant.COMMON_FAILED.getStatus());
        dto.setMsg(msg);
        return dto;
    }

    /**
     * 设置成功
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	public SafeCenterResp setSuccess() {
        setInfo(SafeCodeConstant.COMMON_SUCCESS.getStatus(), SafeCodeConstant.COMMON_SUCCESS.getDesc());
        return this;
    }

    /**
     * 设置为失败
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
	public SafeCenterResp setFail() {
        setInfo(SafeCodeConstant.COMMON_FAILED);
        return this;
    }

    /**
     * @param success
     * @return
     */
    @SuppressWarnings("rawtypes")
	public SafeCenterResp setInfo(SafeCodeConstant success) {
        setInfo(success.getStatus(), success.getDesc());
        return this;
    }

    @SuppressWarnings("rawtypes")
	public SafeCenterResp setInfo(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }


    public SafeCenterResp(T data) {
        this(SafeCodeConstant.COMMON_SUCCESS.getStatus() + "", "成功", data);
    }

    public SafeCenterResp(String code, String msg) {
        this(code, msg, null);
    }

    public SafeCenterResp(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public SafeCenterResp<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    @SuppressWarnings("unchecked")
	public SafeCenterResp<T> setMsg(String msg) {
        this.msg = msg;
        this.data = (T) new JSONObject();
        return this;
    }

    public T getData() {
        return data;
    }

    public SafeCenterResp<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "SafeCenterResp{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 返回码
     */
    @ApiModelProperty(value = "返回码", dataType = "String", position = 1)
    private String code = "200";
    /**
     * 返回描述
     */
    @ApiModelProperty(value = "返回说明", dataType = "String", position = 2)
    private String msg;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", dataType = "Object", position = 3)
    private T data;
}
