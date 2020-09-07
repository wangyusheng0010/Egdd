package com.example.egdd.ui.activity.caches;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.egdd.R;
import com.example.egdd.utils.BottomDialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private Switch sw_splash;
    private ImageView iv_enter;
    private RelativeLayout rl_login;
    private LinearLayout ll_vip;
    private Button btn_vip;
    private RelativeLayout rl_play;
    private Switch sw_sleep;
    private RelativeLayout rl_rest;
    private RelativeLayout rl_renew;
    private RelativeLayout rl_record;
    private RelativeLayout rl_singer_wechat;
    private RelativeLayout rl_question;
    private RelativeLayout rl_advise;
    private RelativeLayout rl_comment;
    private RelativeLayout rl_share;
    private RelativeLayout rl_cooperation;
    private RelativeLayout rl_about;
    private TextView tv_release;
    private TextView tv_rest_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        EventBus.getDefault().register(this);
        initView();
        initListener();
    }

    private void initListener() {
        //返回上一个页面
        iv_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //点击播放设置
        rl_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //点击休息频率
        rl_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomDialog bottomDialog = new BottomDialog(SettingActivity.this);
                bottomDialog.show();
            }
        });
    }

    private void initView() {
        //启动音效
        sw_splash = (Switch) findViewById(R.id.sw_splash);
        //点击作息控制
        sw_sleep = (Switch) findViewById(R.id.sw_sleep);
        sw_splash.setChecked(true);
        //返回上一个页面
        iv_enter = (ImageView) findViewById(R.id.iv_enter);
        //点击登录
        rl_login = (RelativeLayout) findViewById(R.id.rl_login);
        rl_login.setOnClickListener(this);
        //点击会员权益
        ll_vip = (LinearLayout) findViewById(R.id.ll_vip);
        ll_vip.setOnClickListener(this);
        //点击开通
        btn_vip = (Button) findViewById(R.id.btn_vip);
        btn_vip.setOnClickListener(this);
        //点击播放
        rl_play = (RelativeLayout) findViewById(R.id.rl_play);
        //点击休息频率
        rl_rest = (RelativeLayout) findViewById(R.id.rl_rest);
        //作息时间
        tv_rest_time = (TextView) findViewById(R.id.tv_rest_time);
        //自动续费
        rl_renew = (RelativeLayout) findViewById(R.id.rl_renew);
        rl_renew.setOnClickListener(this);
        //交易记录
        rl_record = (RelativeLayout) findViewById(R.id.rl_record);
        rl_record.setOnClickListener(this);
        //微信公众号
        rl_singer_wechat = (RelativeLayout) findViewById(R.id.rl_singer_wechat);
        rl_singer_wechat.setOnClickListener(this);
        //常见问题
        rl_question = (RelativeLayout) findViewById(R.id.rl_question);
        rl_question.setOnClickListener(this);
        //建议反馈
        rl_advise = (RelativeLayout) findViewById(R.id.rl_advise);
        rl_advise.setOnClickListener(this);
        //评分支持
        rl_comment = (RelativeLayout) findViewById(R.id.rl_comment);
        rl_comment.setOnClickListener(this);
        //分享推荐
        rl_share = (RelativeLayout) findViewById(R.id.rl_share);
        rl_share.setOnClickListener(this);
        //内容合作
        rl_cooperation = (RelativeLayout) findViewById(R.id.rl_cooperation);
        rl_cooperation.setOnClickListener(this);
        //关于我们
        rl_about = (RelativeLayout) findViewById(R.id.rl_about);
        rl_about.setOnClickListener(this);
        //版本
        tv_release = (TextView) findViewById(R.id.tv_release);
        tv_release.setOnClickListener(this);

    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getRestTime(String s){
        if (s.equals("不休息")){
            tv_rest_time.setVisibility(View.GONE);
        }else {
            tv_rest_time.setText(s);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vip:

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}