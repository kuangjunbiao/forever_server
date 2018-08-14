package com.gaoan.forever.apiServer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by Tianho on 2016/7/28.
 */
public class ServerInterceptor extends HandlerInterceptorAdapter {

    /**
     * 初始日志类
     */
    private Logger log = LoggerFactory.getLogger(ServerInterceptor.class);

    // private ITbDynamicConfigInfoService dynamicConfigInfoService;

    public ServerInterceptor() {
    }

    // public ServerInterceptor(ITbDynamicConfigInfoService
    // dynamicConfigInfoService) {
    // this.dynamicConfigInfoService = dynamicConfigInfoService;
    // }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
	return true;
	// HttpSession session = request.getSession();
	// if (null == session.getAttribute(UserConstant.FORM_SUBMIT)) {
	// session.setAttribute(UserConstant.FORM_SUBMIT,
	// FormSubmitConstant.SUBMIT_IS_TRUE);
	// }
	// int nowHour = CalendarUtils.getHour(new Date());
	// String restUrl = "/api/serverStop";
	// // 当前时间不在系统服务开启时间内,禁止服务器
	// boolean isServerStop = dynamicConfigInfoService.getServerStop();
	// if (isServerStop) {
	// log.info("服务器已停止服务！");
	// request.getRequestDispatcher(restUrl).forward(request, response);
	// return false;
	// } else {
	// return true;
	// }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	    ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	    throws Exception {
    }

    // public ITbDynamicConfigInfoService getDynamicConfigInfoService() {
    // return dynamicConfigInfoService;
    // }
    //
    // public void setDynamicConfigInfoService(ITbDynamicConfigInfoService
    // dynamicConfigInfoService) {
    // this.dynamicConfigInfoService = dynamicConfigInfoService;
    // }
}
