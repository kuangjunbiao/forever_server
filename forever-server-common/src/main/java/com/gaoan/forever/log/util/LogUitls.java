/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ketayao.ketacustom.log.LogUitl.java
 * Class:			LogUitl
 * Date:			2013-5-28
 * Author:			longshengtang
 * Version          2.1.0
 * Description:
 *
 * </pre>
 **/

package com.gaoan.forever.log.util;

import javax.servlet.http.HttpServletRequest;

import com.gaoan.forever.constant.SecurityConstants;
import com.gaoan.forever.log.LogMessageObject;

/**
 * 将request放入ThreadLocal用于LOG_ARGUMENTS注入。	
 * @author longshengtang
 * @since 20140417
 */

public abstract class LogUitls {
    // 用于存储每个线程的request请求
    private static final ThreadLocal<HttpServletRequest> LOCAL_REQUEST = new ThreadLocal<HttpServletRequest>();

    public static void putRequest(HttpServletRequest request) {
        LOCAL_REQUEST.set(request);
    }

    public static HttpServletRequest getRequest() {
        return LOCAL_REQUEST.get();
    }

    public static void removeRequest() {
        LOCAL_REQUEST.remove();
    }

    /**
     * 将LogMessageObject放入LOG_ARGUMENTS。
     * 描述
     * @param logMessageObject
     */	
    public static void putArgs(LogMessageObject logMessageObject) {
        HttpServletRequest request = getRequest();
        request.setAttribute(SecurityConstants.LOG_ARGUMENTS, logMessageObject);
    }

    /**
     * 得到LogMessageObject。
     * 描述
     */
    public static LogMessageObject getArgs() {
        HttpServletRequest request = getRequest();
        return (LogMessageObject) request.getAttribute(SecurityConstants.LOG_ARGUMENTS);
    }
}
