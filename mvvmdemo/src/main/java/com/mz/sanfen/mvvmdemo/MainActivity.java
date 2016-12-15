package com.mz.sanfen.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mz.sanfen.mvvmdemo.databinding.ActivityMainBinding;
import com.mz.sanfen.mvvmdemo.entity.User;
import com.mz.sanfen.mvvmdemo.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {


    User user;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User("11", "22");
        presenter = new MainPresenter(this);

        binding.setUser(user);
        binding.setHandlers(this);
        binding.setPresenter(presenter);



    }

    public void onViewClick(View view) {
        Log.e("---->", "!!!!!!!!!!!!! 点击了" + view.getId());
        Toast.makeText(this, "点击了", Toast.LENGTH_LONG).show();
    }

}
