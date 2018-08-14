package com.gaoan.forever.apiServer.vo;

/**
 * Created by dotnar on 2017/4/18.
 */
public class InterfacePageVo {

    private long totalpage; // 总页数
    private long page; // 当前页
    private long pagenumber; // 每页条数
    private Object list; // 数据

    public long getTotalpage() {
	return totalpage;
    }

    public void setTotalpage(long totalpage) {
	this.totalpage = totalpage;
    }

    public long getPage() {
	return page;
    }

    public void setPage(long page) {
	this.page = page;
    }

    public long getPagenumber() {
	return pagenumber;
    }

    public void setPagenumber(long pagenumber) {
	this.pagenumber = pagenumber;
    }

    public Object getList() {
	return list;
    }

    public void setList(Object list) {
	this.list = list;
    }
}
