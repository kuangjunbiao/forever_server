package com.gaoan.forever.vo;

import com.alibaba.fastjson.JSONObject;
import com.gaoan.forever.constant.CodeConstant;
import com.gaoan.forever.constant.StatusConstant;

/**
 * 基本响应对象
 * Created by longshengtang on 2017/4/7.
 */
public class BaseResp<T> {

    public static <U> BaseResp<U> build(U data) {
        return new BaseResp<>(data).setSuccess();
    }

    /**
     * 用于判定返回码是否为200
     *
     * @return 如果this.code值为200或者200返回true；反之返回false
     */
    public boolean isOk() {
        return StatusConstant.SUCCESS.getStatus().equals(this.code) || "200".equals(this.code) || "SUCCESS".equals(this.code);
    }

    public BaseResp() {
        this(StatusConstant.SUCCESS);
    }

    public BaseResp(StatusConstant statusConstant) {
        this.setInfo(statusConstant);
    }

    /**
     * 构建成功时候返回的dto
     *
     * @return 返回Dto
     */
    public static BaseResp buildSuccess() {
        BaseResp dto = new BaseResp();
        dto.setStatus(StatusConstant.SUCCESS.getStatus());
        dto.setCode(CodeConstant.SUCCESS.getStatus());
        dto.setMsg(CodeConstant.SUCCESS.getDesc());
        return dto;
    }


    /**
     * 构建失败时候返回的dto
     *
     * @return 返回Dto
     */
    public static BaseResp buildFail() {
        BaseResp dto = new BaseResp();
        dto.setStatus(StatusConstant.FAILED.getStatus());
        dto.setCode(StatusConstant.FAILED.getStatus());
        dto.setMsg(StatusConstant.FAILED.getDesc());
        return dto;
    }

    /**
     * 构建失败时候返回的dto
     *
     * @return 返回Dto
     */
    public static BaseResp buildFail(String msg) {
        BaseResp dto = new BaseResp();
        dto.setStatus(StatusConstant.FAILED.getStatus());
        dto.setCode(StatusConstant.FAILED.getStatus());
        dto.setMsg(msg);
        return dto;
    }

    /**
     * 设置成功
     *
     * @return
     */
    public BaseResp setSuccess() {
        setInfo(StatusConstant.SUCCESS.getStatus(), StatusConstant.SUCCESS.getStatus(), StatusConstant.SUCCESS.getDesc());
        return this;
    }

    /**
     * 设置为失败
     *
     * @return
     */
    public BaseResp setFail() {
        setInfo(StatusConstant.FAILED);
        return this;
    }

    /**
     * @param success
     * @return
     */
    public BaseResp setInfo(StatusConstant success) {
        setInfo(success.getStatus(), success.getStatus(), success.getDesc());
        return this;
    }

    public BaseResp setInfo(String status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
        return this;
    }


    public BaseResp(T data) {
        this(StatusConstant.SUCCESS.getStatus() + "", "成功", data);
    }

    public BaseResp(String code, String msg) {
        this(code, msg, null);
    }

    public BaseResp(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public BaseResp<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseResp<T> setMsg(String msg) {
        this.msg = msg;
        this.data = (T) new JSONObject();
        return this;
    }

    public T getData() {
        return data;
    }

    public BaseResp<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResp{" +
                "code='" + code + '\'' +
                ", status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public BaseResp setStatus(String status) {
        this.status = status;
        return this;
    }

    private String status = "0";
    /**
     * 返回码
     */
    private String code = "200";
    /**
     * 返回描述
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public static void main(String[] args) {
        BaseResp baseResp = new BaseResp();
        baseResp.setData(new JSONObject());
        System.out.println(JSONObject.toJSONString(baseResp));
    }
}
