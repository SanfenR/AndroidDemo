package com.example.sanfen.dagger2demo.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/31.
 */
@Scope//限制Component的作用域
@Retention(RetentionPolicy.RUNTIME)
public @interface PoetryScope {
}
