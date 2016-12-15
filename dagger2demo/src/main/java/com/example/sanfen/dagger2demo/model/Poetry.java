package com.example.sanfen.dagger2demo.model;

import javax.inject.Inject;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/30.
 */
public class Poetry {
    private String pemo;

    @Inject
    public Poetry() {
        pemo = "生活就像海洋。";
    }

    public Poetry(String pemo){
        this.pemo = pemo;
    }


    public String getPemo() {
        return pemo;
    }
}
