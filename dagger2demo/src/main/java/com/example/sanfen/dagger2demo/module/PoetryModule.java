package com.example.sanfen.dagger2demo.module;

import com.example.sanfen.dagger2demo.model.Poetry;
import com.example.sanfen.dagger2demo.scope.PoetryScope;

import dagger.Module;
import dagger.Provides;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/31.
 */
@Module
public class PoetryModule {

    //    @Singleton
    @Provides
    @PoetryScope //单例
    public Poetry providePoetry(String poems){
        return new Poetry(poems);
    }

    @Provides
    public String providePoems(){
        return "一起哈皮！！！";
    }

//    @Provides
//    public String providePer(){
//        return "强，无敌！";
//    }

}
