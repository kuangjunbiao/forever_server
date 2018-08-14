package com.gaoan.forever.log.spring;

import java.lang.annotation.*;

/**
 * Created by dotnar on 2017/5/23.
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FormSubmit {

    // 是否允许重复提交
    boolean isRepeatSubmit() default false;
}
