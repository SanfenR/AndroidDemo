package com.example.sanfen.dagger2demo.component;

import com.example.sanfen.dagger2demo.module.AModule;
import com.example.sanfen.dagger2demo.scope.AScope;
import com.example.sanfen.dagger2demo.view.activity.AActivity;

import dagger.Subcomponent;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/1.
 */
@AScope
@Subcomponent(modules = AModule.class)
public interface AComponent {
    void inject(AActivity activity);
}
