package com.gaoan.forever.log.spring;

import java.lang.annotation.*;

/**
 * Created by dotnar on 2017/5/23.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ParameterToVerifySign {
}
