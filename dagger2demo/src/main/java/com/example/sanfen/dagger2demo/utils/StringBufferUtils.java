package com.example.sanfen.dagger2demo.utils;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/31.
 */
public class StringBufferUtils {

    public static String add(String... str){
        StringBuilder sb = new StringBuilder();
        for (String s : str){
            sb.append(s);
        }
        return sb.toString();
    }

}
