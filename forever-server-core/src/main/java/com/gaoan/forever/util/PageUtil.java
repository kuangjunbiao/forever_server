package com.gaoan.forever.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.gaoan.forever.base.BaseEntity;
import com.github.pagehelper.PageInfo;

/**
 * 给分页信息提供方便
 *
 * @author longshengtang
 * @since 2017-04-15 0:00
 **/
public final class PageUtil {

    /**
     * 将list列表转换成包含的分页信息对象
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> PageInfo<T> toPageInfo(List<T> list) {
	if (list == null) {
	    return new PageInfo();
	}
	if (list instanceof PageInfo) {
	    return (PageInfo<T>) list;
	}
	return new PageInfo<>(list);
    }

    /**
     * 分页
     *
     * @param pageInfo
     * @param <T>
     */
    public static <T extends BaseEntity> void startPage(T pageInfo) {
	if (pageInfo == null) {
	    logger.error("pageInfo 分页对象为空！！！");
	    return;
	}
	// PageHelper.startPage(pageInfo.getPageNumber(),
	// pageInfo.getPageSize());
	// if (StringUtil.isNotEmpty(pageInfo.getOrderBy())) {
	// PageHelper.orderBy(pageInfo.getOrderBy());
	// }
    }

    /**
     * 分页
     *
     * @param pageInfo
     * @param <T>
     */
    public static <T extends BaseEntity> void startPageDefaultOrder(T pageInfo) {
	if (pageInfo == null) {
	    logger.error("pageInfo 分页对象为空！！！");
	    return;
	}
	// PageHelper.startPage(pageInfo.getPageNumber(),
	// pageInfo.getPageSize());
	// if (Strings.isNullOrEmpty(pageInfo.getOrderBy())) {
	// PageHelper.orderBy(DataBaseConstant.ORDER_STRATEGY);
	// } else {
	// PageHelper.orderBy(pageInfo.getOrderBy());
	// }
    }

    private static final Logger logger = Logger.getLogger(PageUtil.class);
}
