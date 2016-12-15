package com.example.sanfen.dagger2demo.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sanfen.dagger2demo.MyApplication;
import com.example.sanfen.dagger2demo.R;
import com.example.sanfen.dagger2demo.model.Poetry;
import com.example.sanfen.dagger2demo.scope.PoetryQualifier;
import com.example.sanfen.dagger2demo.utils.StringBufferUtils;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AActivity extends AppCompatActivity {

    @BindView(R.id.a_text_name)
    TextView mTextView;

//    @PoetryQualifier("A")
    @Named("A")
    @Inject
    Poetry mPoetry;

//    @PoetryQualifier("B")
    @Named("B")
    @Inject
    Poetry mOtherPoetry;


    @Inject
    Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);
        MyApplication
                .getInstance()
                .getAComponent()
                .inject(this);

        initView();
    }

    private void initView() {
        mTextView.setText(StringBufferUtils.add("A=", mGson.toJson(mPoetry),
                "-",
                "B=", mGson.toJson(mOtherPoetry)));
    }
}
