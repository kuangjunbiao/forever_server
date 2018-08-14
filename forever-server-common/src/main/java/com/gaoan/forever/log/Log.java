
package com.gaoan.forever.log;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.gaoan.forever.log.em.LogTypeEm;
import com.gaoan.forever.log.em.UserLogTypeEm;

/**
 * @author longshengtang
 * @since 20170417
 */
@Documented
@Target({METHOD})
@Retention(RUNTIME)
public @interface Log {
    /**
     * 日志信息
     *
     * @return
     */
    String message();

    /**
     * 日志记录等级
     *
     * @return
     */
    LogLevel level() default LogLevel.TRACE;

    /**
     * 是否覆盖包日志等级
     * 1.为false不会参考level属性。
     * 2.为true会参考level属性。
     *
     * @return
     */
    boolean override() default false;

    /**
     * 日志类型。当LogMessageObject中的logTypeEm值为空时有效
     *
     * @return
     */
    LogTypeEm logType() default LogTypeEm.UNKNOWN;

    /**
     * 用于指定用户类型：前端用户只记录前端日志；后端用户只记录后端日志。默认为后端用户
     *
     * @return
     */
    UserLogTypeEm userLogType() default UserLogTypeEm.BACK_END;
}
