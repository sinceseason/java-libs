package com.xty.common;

/**
 * Created by Shadow on 2017/5/15.
 */

import java.lang.annotation.*;

/**
 *自定义注解 拦截service
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemServiceLog {
    String s_module()  default "";
    String s_type()  default "";
}
