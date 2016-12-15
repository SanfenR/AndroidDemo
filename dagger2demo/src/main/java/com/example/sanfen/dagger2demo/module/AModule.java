package com.example.sanfen.dagger2demo.module;

import com.example.sanfen.dagger2demo.model.Poetry;
import com.example.sanfen.dagger2demo.scope.AScope;
import com.example.sanfen.dagger2demo.scope.PoetryQualifier;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/1.
 */

@Module
public class AModule {

//    @PoetryQualifier("A")
    @Named("A") //与上面的用法一样 系统自带
    @AScope
    @Provides
    public Poetry providePoetry(){
        return new Poetry("一叶知秋！");
    }

//    @PoetryQualifier("B")
    @Named("B")
    @AScope
    @Provides
    public Poetry provideOtherPoetry(){
        return new Poetry("阴吹斯汀！");
    }

}
