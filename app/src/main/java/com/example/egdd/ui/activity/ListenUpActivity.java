package com.example.egdd.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.egdd.R;
import com.example.egdd.http.listenhttp.Firsthttp.ListenImageBean;
import com.example.egdd.mvp.listenupmvp.UpPresenter;
import com.example.egdd.mvp.listenupmvp.UpView;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpActivity;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListenUpActivity extends BaseMvpActivity<UpView, UpPresenter>implements UpView {

    @BindView(R.id.up_fanhui)
    ImageView fanhui;
    @BindView(R.id.up_tolbar)
    TextView tb;
    @BindView(R.id.up_iv)
    ImageView iv;
    @BindView(R.id.up_title)
    TextView title;
    @BindView(R.id.up_desc)
    TextView desc;
    @BindView(R.id.up_play_all)
    LinearLayout playAll;
    @BindView(R.id.up_rcy)
    RecyclerView rcy;

    @Override
    protected void initView() {
        initFanHui();//返回
        initFuZhi(); //赋值

    }

    private void initFuZhi() {
        Intent intent = getIntent();
        ListenImageBean hali = (ListenImageBean) intent.getSerializableExtra("hali");
        tb.setText(hali.getTitle());
        Glide.with(this);/////////
    }

    private void initFanHui() {
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_listen_up;
    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected UpPresenter initPresenter() {
        return new UpPresenter();
    }

    @Override
    public void showLog(String str) {
        LogUtils.e(str);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}