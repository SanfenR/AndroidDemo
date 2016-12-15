package com.mz.sanfen.greendaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mz.sanfen.greendaodemo.db.DBManager;
import com.mz.sanfen.greendaodemo.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DBManager dbManager = DBManager.getInstance(this);
        List<User> userList = dbManager.queryUserList();

        for (User user : userList) {
            Log.e(TAG, "onCreate: " + "queryUserList--after--->" + user.getId() + "---" + user.getName()+"--"+user.getAge());
        }

    }
}
