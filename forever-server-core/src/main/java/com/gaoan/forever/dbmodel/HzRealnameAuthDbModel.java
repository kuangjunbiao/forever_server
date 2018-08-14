package com.gaoan.forever.dbmodel;

import com.gaoan.forever.entity.TbHzRealnameAuthEntity;

import io.swagger.annotations.ApiModelProperty;

public class HzRealnameAuthDbModel extends TbHzRealnameAuthEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2938082448603790404L;

	
	/** 实名证件类型名称 **/
    @ApiModelProperty("实名证件类型名称")
	private String idTypeName;
    
    /** 国家/地区名称 **/
    @ApiModelProperty("国家/地区名称")
    private String country;


	public String getIdTypeName() {
		return idTypeName;
	}


	public void setIdTypeName(String idTypeName) {
		this.idTypeName = idTypeName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	} 
    
    
}
