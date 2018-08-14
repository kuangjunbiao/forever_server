package com.gaoan.forever.model;

import java.io.Serializable;

/**
 * 分页查询实体
 * @author three
 *
 */
public class PageReqVo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer page;
	
	private Integer pagesize;

	public Integer getPage() {
		if (null == page) {
			page = 1;
		}
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPagesize() {
		if (null == pagesize) {
			pagesize = 10;
		}
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	
	
}
