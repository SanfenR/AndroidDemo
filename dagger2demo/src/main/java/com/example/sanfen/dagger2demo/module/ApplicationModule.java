package com.example.sanfen.dagger2demo.module;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/31.
 */
@Module
public class ApplicationModule {

    /**
     * @Provides 注解表示这个方法是用来创建某个实例对象的
     * 方法名随便，一般用provideXXX结构
     * @return 返回注入对象
     */
    @Singleton
    @Provides
    public Gson provideGson(){
        return new Gson();
    }
}
