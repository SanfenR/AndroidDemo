package com.example.sanfen.dagger2demo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/8/30.
 */
public class ToastUtils {
    public static Toast sToast;

    public static void showToast(Context context, String str){
        if (sToast == null){
            sToast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        }
        sToast.setText(str);
        sToast.show();

    }
}
