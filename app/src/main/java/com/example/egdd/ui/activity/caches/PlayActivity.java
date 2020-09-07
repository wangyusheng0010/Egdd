package com.example.egdd.ui.activity.caches;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.egdd.R;

public class PlayActivity extends AppCompatActivity {

    private ImageView iv_enter;
    private Switch sw_play;
    private Switch sw_cache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
        initListener();
    }

    private void initListener() {
        iv_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        iv_enter = (ImageView) findViewById(R.id.iv_enter);
        sw_play = (Switch) findViewById(R.id.sw_play);
        sw_cache = (Switch) findViewById(R.id.sw_cache);
    }
}