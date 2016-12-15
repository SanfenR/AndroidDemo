package com.example.sanfen.dagger2demo.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class OtherActivity extends AppCompatActivity {

    @BindView(R.id.other_text_name)
    TextView mTextView;

    @BindView(R.id.other_btn_a)
    Button mButton;

    @Inject
    Poetry poetry;

    @Inject
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);

        MainComponent.getInstance().inject(this);

        initView();
    }

    private void initView() {
        mTextView.setText(StringBufferUtils.add(gson.toJson(poetry), poetry.toString()));
    }

    @OnClick({R.id.other_btn_a})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.other_btn_a:
                Intent intent = new Intent(this, AActivity.class);
                startActivity(intent);
                break;
        }

    }
}
