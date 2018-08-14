package com.gaoan.forever.apiServer.vo;

/**
 * Created by dotnar on 2017/4/18.
 */
public class UserVo {

    private String id; // 会员id
    private String username; // 会员昵称
    private String email; // 会员邮箱
    private String real_name; // 会员真实姓名
    private int sex; // 会员性别值(0女，1男)
    private String sexstr; // 会员性别(女，男)
    private String address; // 地址
    private String transion_addr; // 账号地址
    private String picture; // 会员头像
    private String mobile; // 会员电话
    private String level; // 会员等级
    private String status; // 会员状态 (0未激活，1激活)
    private String crt_time; // 创建时间
    private String act_time; // 激活时间
    private String last_time; // 最近操作
    private String total_seeds; // 种子总额
    private String total_investment; // 投资总额
    private String total_foods; // 粮食总额
    private String total_currency; // 游戏币总额
    private String total_income; // 今天收益
    private String ip_addr; // 登录的ip地址
    private String login_addr; // 登录地址
    private String pay_pwd; // 支付密码
    private String password; // 密码

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getReal_name() {
	return real_name;
    }

    public void setReal_name(String real_name) {
	this.real_name = real_name;
    }

    public int getSex() {
	return sex;
    }

    public void setSex(int sex) {
	this.sex = sex;
    }

    public String getSexstr() {
	return sexstr;
    }

    public void setSexstr(String sexstr) {
	this.sexstr = sexstr;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getTransion_addr() {
	return transion_addr;
    }

    public void setTransion_addr(String transion_addr) {
	this.transion_addr = transion_addr;
    }

    public String getPicture() {
	return picture;
    }

    public void setPicture(String picture) {
	this.picture = picture;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public String getLevel() {
	return level;
    }

    public void setLevel(String level) {
	this.level = level;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getCrt_time() {
	return crt_time;
    }

    public void setCrt_time(String crt_time) {
	this.crt_time = crt_time;
    }

    public String getAct_time() {
	return act_time;
    }

    public void setAct_time(String act_time) {
	this.act_time = act_time;
    }

    public String getLast_time() {
	return last_time;
    }

    public void setLast_time(String last_time) {
	this.last_time = last_time;
    }

    public String getTotal_seeds() {
	return total_seeds;
    }

    public void setTotal_seeds(String total_seeds) {
	this.total_seeds = total_seeds;
    }

    public String getTotal_investment() {
	return total_investment;
    }

    public void setTotal_investment(String total_investment) {
	this.total_investment = total_investment;
    }

    public String getTotal_foods() {
	return total_foods;
    }

    public void setTotal_foods(String total_foods) {
	this.total_foods = total_foods;
    }

    public String getTotal_currency() {
	return total_currency;
    }

    public void setTotal_currency(String total_currency) {
	this.total_currency = total_currency;
    }

    public String getTotal_income() {
	return total_income;
    }

    public void setTotal_income(String total_income) {
	this.total_income = total_income;
    }

    public String getIp_addr() {
	return ip_addr;
    }

    public void setIp_addr(String ip_addr) {
	this.ip_addr = ip_addr;
    }

    public String getLogin_addr() {
	return login_addr;
    }

    public void setLogin_addr(String login_addr) {
	this.login_addr = login_addr;
    }

    public String getPay_pwd() {
	return pay_pwd;
    }

    public void setPay_pwd(String pay_pwd) {
	this.pay_pwd = pay_pwd;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}
