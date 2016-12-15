package com.example.sanfen.dagger2demo.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/1.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME) // 单例
public @interface AScope {
}
