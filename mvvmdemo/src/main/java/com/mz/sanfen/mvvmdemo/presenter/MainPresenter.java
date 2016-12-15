package com.mz.sanfen.mvvmdemo.presenter;

import android.app.Activity;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import com.mz.sanfen.mvvmdemo.MainActivity;
import com.mz.sanfen.mvvmdemo.entity.User;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/10/17.
 */

public class MainPresenter {

    MainActivity c;

    public MainPresenter(Activity c) {
        this.c = (MainActivity) c;
    }

    public void onText2Click(View view, User user){
        Toast.makeText(c, user.firstName, Toast.LENGTH_LONG).show();
    }

    public void afterFirstNameChanged(Editable s) {

        Toast.makeText(c, s.toString(), Toast.LENGTH_LONG).show();

    }

    public void onLongClick(View view, User user){
        Toast.makeText(c, "Long", Toast.LENGTH_LONG).show();
    }


    public void onCompletedChanged(boolean completed){
        Toast.makeText(c, "checked" + completed, Toast.LENGTH_LONG).show();
    }


}
