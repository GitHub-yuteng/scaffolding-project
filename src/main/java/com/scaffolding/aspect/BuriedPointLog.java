package com.scaffolding.aspect;

import java.lang.annotation.*;

/**
 * @author whh-yt
 * @Dese 埋点
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BuriedPointLog {

    String value() default "";

}