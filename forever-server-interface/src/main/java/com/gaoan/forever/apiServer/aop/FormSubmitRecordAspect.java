package com.gaoan.forever.apiServer.aop;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gaoan.forever.base.AppException;
import com.gaoan.forever.constant.FormSubmitConstant;
import com.gaoan.forever.constant.MessageInfoConstant;
import com.gaoan.forever.constant.UserConstant;

/**
 * Created by jiaobuchong on 12/23/15.
 */
@Aspect // 定义一个切面
@Configuration
public class FormSubmitRecordAspect {
    private static final Logger logger = LoggerFactory.getLogger(FormSubmitRecordAspect.class);

    public FormSubmitRecordAspect() {
    }

    // 定义切点Pointcut
    @Pointcut(
    // "execution(public * com.dotnar.trade.apiServer.*.*Controller.*(..)) and"
    // +
    " @annotation(com.gaoan.forever.log.spring.FormSubmit)")
    public void excudeService() {
    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
	Object result = null;
	RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	ServletRequestAttributes sra = (ServletRequestAttributes) ra;
	HttpSession session = sra.getRequest().getSession();
	String formKey = UserConstant.FORM_SUBMIT + "_" + pjp.getSignature().getName();
	Boolean isSubmit = (Boolean) session.getAttribute(formKey);
	isSubmit = null == isSubmit ? Boolean.TRUE : isSubmit;
	// 是否允许提交
	if (isSubmit) {
	    logger.info("业务正在处理：");

	    try {
		// 禁止提交
		session.setAttribute(formKey, FormSubmitConstant.SUBMIT_IS_FALSE);
		// 执行方法
		result = pjp.proceed();
		// 开启提交
	    } catch (Exception e) {
		session.setAttribute(formKey, FormSubmitConstant.SUBMIT_IS_TRUE);
		logger.error("目标方法抛出异常！", e);
		throw e;
	    } finally {
		session.setAttribute(formKey, FormSubmitConstant.SUBMIT_IS_TRUE);
	    }

	} else {
	    logger.info("业务正在处理,请不要重复提交");
	    throw new AppException(MessageInfoConstant.FORM_IS_HANDLING);
	}
	return result;
    }
}
