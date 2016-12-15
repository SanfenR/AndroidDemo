package com.example.sanfen.dagger2demo.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/1.
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PoetryQualifier {
    String value() default "";
}
