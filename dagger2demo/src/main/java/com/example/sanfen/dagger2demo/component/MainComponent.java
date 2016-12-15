package com.example.sanfen.dagger2demo.component;

import com.example.sanfen.dagger2demo.MyApplication;
import com.example.sanfen.dagger2demo.module.MainModule;
import com.example.sanfen.dagger2demo.module.PoetryModule;
import com.example.sanfen.dagger2demo.scope.PoetryScope;
import com.example.sanfen.dagger2demo.view.activity.MainActivity;
import com.example.sanfen.dagger2demo.view.activity.OtherActivity;

import dagger.Component;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/30.
 */

/**
 * 连接器
 */
//@Singleton
@PoetryScope
@Component(dependencies = ApplicationComponent.class, modules = PoetryModule.class)
public abstract class MainComponent {

    public abstract void inject(MainActivity activity);

    public abstract void inject(OtherActivity activity);

    private static MainComponent sComponent;

    public static MainComponent getInstance(){
        if (sComponent == null){
            sComponent = DaggerMainComponent
                    .builder()
                    .applicationComponent(MyApplication.getInstance().getApplicationComponent())
                    .build();
        }
        return sComponent;
    }

}
