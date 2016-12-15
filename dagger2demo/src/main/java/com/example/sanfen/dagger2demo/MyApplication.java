package com.example.sanfen.dagger2demo;

import android.app.Application;

import com.example.sanfen.dagger2demo.component.AComponent;
import com.example.sanfen.dagger2demo.component.ApplicationComponent;
import com.example.sanfen.dagger2demo.component.DaggerApplicationComponent;
import com.example.sanfen.dagger2demo.module.AModule;


/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/30.
 */
public class MyApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    private AComponent mAComponent;
    private static MyApplication sApplication;

    public static MyApplication getInstance(){
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        mApplicationComponent = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    public AComponent getAComponent(){
        if (mAComponent == null){
            mAComponent = mApplicationComponent.plus(new AModule());
        }
        return mAComponent;
    }

}
