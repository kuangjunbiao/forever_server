package com.gaoan.forever.utils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gaoan.forever.constant.RedisConstant;
import com.gaoan.forever.utils.cache.CacheUtils;

/**
 * 生成订单编号帮助类 Created by NO.9527 on 2017年7月21日
 */
@Component
public class OrderNumberUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3067021997172289453L;

	/**
	 * {0}2位业务码 {1}yyMMdd 8位时间 {2}一位前随机数 {3}5 位 流水号 {4}一位后随机数
	 */
	private static final String noMode = "{0}{1}{2}{3}{4}";

	private static Long lasttime = 0l;

	private static int SEQ = 0;

	private static final int MAX = 1000;

	public static String SYSTEMMARK = "";

	/**
	 * 钱包对接接口,所获取的批次号
	 * 
	 * @return
	 */
	public static synchronized String buildBatchNo() {
		String str = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
		return MessageFormat.format("{0}{1}", str, getRandom(3));
	}

	public static synchronized String buildNo(String type, Long userId) {
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		return MessageFormat.format(noMode, type, date, getRandom(1), getRandom(6), getRandom(1));
	}

	public static String getRandom(int t) {
		Random rad = new Random();
		int num = Integer.valueOf(StringUtils.rightPad("1", t + 1, "0"));
		String result = String.valueOf(rad.nextInt(num));
		result = StringUtils.leftPad(result, t, "0");
		return result;
	}

	private static void buildMark() {
		String mark = getRandom(2);
		Object cacheObj = CacheUtils.getHashOpsByField(RedisConstant.REDIS_KEY_HZ_ORDERNUMBERMARK, mark);
		if (cacheObj == null) {
			SYSTEMMARK = mark;
			CacheUtils.putHashOps(RedisConstant.REDIS_KEY_HZ_ORDERNUMBERMARK, SYSTEMMARK, SYSTEMMARK);
		} else {
			// buildMark();
			SYSTEMMARK = (String) cacheObj;
		}
	}

	/**
	 * 创建流水号
	 * 
	 * @param flage
	 * @return
	 */
	public static synchronized String buildNo(String flage) {
		if (StringUtils.isBlank(SYSTEMMARK)) {
			buildMark();
		}
		long t = System.currentTimeMillis();
		if (lasttime == t) {
			if (SEQ > MAX) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				SEQ = 0;
			}
		}
		String date = new SimpleDateFormat("YYHHmmssSSS").format(new Date());
		SEQ++;
		lasttime = t;
		StringBuffer sb = new StringBuffer("");
		sb.append(flage.trim());
		if (StringUtils.isNotBlank(SYSTEMMARK))
			sb.append(SYSTEMMARK.trim());
		sb.append(date).append(SEQ);
		return sb.toString();
	}

	/**
	 * 构建交易订单号
	 * 
	 * @param coinType
	 * @param downOrOnlineTrade
	 *            0：线上 1：线下
	 * @return
	 */
	public static String buildTradeOrderNo(Long coinType, Integer downOrOnlineTrade) {
		String orderType = "";
		if (coinType != null && downOrOnlineTrade != null) {
			orderType = coinType.toString() + downOrOnlineTrade.toString();
		}
		if (StringUtils.isBlank(orderType)) {
			return null;
		}
		return OrderNumberUtil.buildNo(orderType);
	}
}
