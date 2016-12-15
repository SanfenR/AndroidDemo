package com.example.sanfen.dagger2demo.module;

import com.example.sanfen.dagger2demo.model.Poetry;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/30.
 */
@Module
public class MainModule {

    /**
     * @Provides 注解表示这个方法是用来创建某个实例对象的
     * 方法名随便，一般用provideXXX结构
     * @return 返回注入对象
     */
    @Provides
    public Gson provideGson(){
        return new Gson();
    }

}
