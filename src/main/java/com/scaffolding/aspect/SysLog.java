package com.scaffolding.aspect;

import java.lang.annotation.*;

/**
 * @author whh-yt
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";

}