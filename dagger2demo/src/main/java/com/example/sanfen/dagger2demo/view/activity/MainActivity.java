package com.example.sanfen.dagger2demo.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sanfen.dagger2demo.R;
import com.example.sanfen.dagger2demo.component.MainComponent;
import com.example.sanfen.dagger2demo.model.Poetry;
import com.example.sanfen.dagger2demo.utils.StringBufferUtils;
import com.google.gson.Gson;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Inject
    Poetry poetry;

    @BindView(R.id.main_text_name)
    TextView mTextView;

    @BindView(R.id.main_btn_other)
    Button mButton;

    @Inject
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainComponent.getInstance().inject(this);
        initView();

    }

    private void initView() {
        mTextView.setText(StringBufferUtils.add(gson.toJson(poetry), poetry.toString()));
    }

    @OnClick({R.id.main_btn_other})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.main_btn_other:
                Intent intent = new Intent(this, OtherActivity.class);
                startActivity(intent);
                break;
        }
    }
}
