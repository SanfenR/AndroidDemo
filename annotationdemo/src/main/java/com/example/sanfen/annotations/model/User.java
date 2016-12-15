package com.example.sanfen.annotations.model;

import android.support.annotation.IntDef;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/9/2.
 */
public class User {

    public static final int MAN = 1;
    public static final int WOMEN = 0;

    private int sex;

    public String user;


    /**
     * 限制值得范围
     */
    @IntDef(flag = true, value = {MAN, WOMEN})
    public @interface Flavour{}



    @Flavour
    public int getSex() {
        return sex;
    }

    /*
    这个方法的参数只能传递User.MAN | User.WOMAN
     */
    public void setSex(@Flavour int sex) {
        this.sex = sex;
    }
}
