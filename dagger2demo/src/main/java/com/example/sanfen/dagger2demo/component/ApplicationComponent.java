package com.example.sanfen.dagger2demo.component;

import com.example.sanfen.dagger2demo.module.AModule;
import com.example.sanfen.dagger2demo.module.ApplicationModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/31.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Gson getGson();
    AComponent plus(AModule module);
}
