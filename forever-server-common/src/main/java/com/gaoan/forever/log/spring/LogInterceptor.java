//package com.dotnar.log.spring;
//
//import com.dotnar.log.Log;
//import com.dotnar.log.LogAPI;
//import com.dotnar.log.LogLevel;
//import com.dotnar.log.LogMessageObject;
//import com.dotnar.log.adpter.LogAdapter;
//import com.dotnar.log.util.LogUitls;
//import com.dotnar.utils.spring.SpringContextUtil;
//import com.dotnar.utils.character.WheatfieldStringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
///**
// * @author longshengtang
// * @since 20170417
// */
////@Component
//public class LogInterceptor extends HandlerInterceptorAdapter implements ApplicationListener<ContextRefreshedEvent> {
//    public LogInterceptor() {
//        System.out.println("LogInterceptor==================");
//    }
//
//    private final static Logger LOGGER = LoggerFactory.getLogger(LogInterceptor.class);
//
//    private LogAPI logAPI;
//
//    /**
//     * 将request存入LogUitl中的LOCAL_REQUEST。
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     * @see HandlerInterceptorAdapter#preHandle(HttpServletRequest, HttpServletResponse, Object)
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception {
//        LogUitls.putRequest(request);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//
//        if (!(handler instanceof HandlerMethod)) {
//            return;
//        }
//
//        final HandlerMethod handlerMethod = (HandlerMethod) handler;
//        Method method = handlerMethod.getMethod();
//
//        //先验证是否包含指定日志注解
//        final Log log = method.getAnnotation(Log.class);
//        if (log != null) {
//            // 得到LogMessageObject
//            final LogMessageObject logMessageObject = LogUitls.getArgs();
//            // 另起线程异步操作---后面会使用线程池进行操作--当前会
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        LogMessageObject defaultLogMessageObject = logMessageObject;
//                        if (defaultLogMessageObject == null) {
//                            defaultLogMessageObject = LogMessageObject.newWrite();
//                        }
//                        if (!defaultLogMessageObject.isWritten()) { // 判断是否写入log
//                            return;
//                        }
//                        defaultLogMessageObject.setMessage(log.message());
//                        //如果消息对象不为空，则不使用log的值
//                        if (defaultLogMessageObject.getLogTypeEm() == null) {
//                            defaultLogMessageObject.setLogTypeEm(log.logType());
//                        }
//
//                        //如果手动传递用户类型，则覆盖方法上的值，因为方法上的值有可以是默认的
//                        if (defaultLogMessageObject.getUserLogTypeEm() == null) {
//                            defaultLogMessageObject.setUserLogTypeEm(log.userLogType());
//                        }
//
//                        // 覆盖，直接写入日志
//                        if (log.override()) {
////                                logAPI.log(log.message(), defaultLogMessageObject.getObjects(), log.level());
//                            logAPI.log(defaultLogMessageObject, log.level());
//                        } else {
//                            LogLevel lastLogLevel = logAPI.getRootLogLevel();
//                            // 不覆盖，参考方法的日志等级是否大于等于最终的日志等级
//                            if (!log.override() && log.level().compareTo(lastLogLevel) >= 0) {
////                                    logAPI.log(log.message(), defaultLogMessageObject.getObjects(), log.level());
//                                logAPI.log(defaultLogMessageObject, log.level());
//                            }
//                        }
//                    } catch (Exception e) {
//                        LOGGER.error(WheatfieldStringUtils.getStackTraceAsString(e));
//                    }
//                }
//            }).start();
//
//        }
//
//    }
//
//    /**
//     * 清除LogUitl中的LOCAL_REQUEST。
//     *
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request,
//                                HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        LogUitls.removeRequest();
//    }
//
//    public void setLogAPI(LogAPI logAPI) {
//        this.logAPI = logAPI;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        if (event.getApplicationContext().getParent() == null)//root application context 没有parent，他就是老大.
//        {
//            System.out.println("onApplicationEvent==================");
//// 后续发现加上以上判断还是能执行两次，不加的话三次，最终研究结果使用以下判断更加准确：
//// event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")
//            LOGGER.info("已经开始初始化！！！日志对象");
//            LogAPI logAPIImpl = SpringContextUtil.getBean(LogAPI.class);
//            if (logAPIImpl != null) {
//                LOGGER.info("找到日志实现==" + logAPIImpl);
//                this.logAPI = logAPIImpl;
//            } else {
//                this.logAPI = new LogAdapter();
//            }
//        }
//
//    }
//}
