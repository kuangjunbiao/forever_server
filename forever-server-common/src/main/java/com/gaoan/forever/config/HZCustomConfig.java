package com.gaoan.forever.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 系统参数配置
 * Created by NO.9527 on 2017年7月20日
 */
@Component
@ConfigurationProperties(prefix = "hzconf")
public class HZCustomConfig {

	/**
	 * 邮箱配置
	 */
	private String phpMailServerAddr;
	
	/**
	 * 存放在fastdfs的文件访问 URL 前缀 如：protocol://host:port
	 */
	private String dfsFileAccessPrefix; 
	/**
	 * 后台用户默认密码
	 */
	private String userDefaultPwd;
	
	/**
	 * 互助交易系统 地址
	 */
	private String tradeSystemDomain;
	
	private String mailAppId;
	
	private String mailSecretkey;
	
	private String excludeCountURIs;
	
	/**
	 * 单个回话绑定安全中心最大次数
	 */
	private String bindMakeysCountMax;

	public String getPhpMailServerAddr() {
		return phpMailServerAddr;
	}

	public void setPhpMailServerAddr(String phpMailServerAddr) {
		this.phpMailServerAddr = phpMailServerAddr;
	}

	public String getDfsFileAccessPrefix() {
		return dfsFileAccessPrefix;
	}

	public void setDfsFileAccessPrefix(String dfsFileAccessPrefix) {
		this.dfsFileAccessPrefix = dfsFileAccessPrefix;
	}

	public String getUserDefaultPwd() {
		return userDefaultPwd;
	}

	public void setUserDefaultPwd(String userDefaultPwd) {
		this.userDefaultPwd = userDefaultPwd;
	}

	public String getTradeSystemDomain() {
		return tradeSystemDomain;
	}

	public void setTradeSystemDomain(String tradeSystemDomain) {
		this.tradeSystemDomain = tradeSystemDomain;
	}

	public String getMailAppId() {
		return mailAppId;
	}

	public void setMailAppId(String mailAppId) {
		this.mailAppId = mailAppId;
	}

	public String getMailSecretkey() {
		return mailSecretkey;
	}

	public void setMailSecretkey(String mailSecretkey) {
		this.mailSecretkey = mailSecretkey;
	}

	public String getExcludeCountURIs() {
		return excludeCountURIs;
	}

	public void setExcludeCountURIs(String excludeCountURIs) {
		this.excludeCountURIs = excludeCountURIs;
	}

	public String getBindMakeysCountMax() {
		return bindMakeysCountMax;
	}

	public void setBindMakeysCountMax(String bindMakeysCountMax) {
		this.bindMakeysCountMax = bindMakeysCountMax;
	}

	
}
