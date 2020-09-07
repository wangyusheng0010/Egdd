package com.example.egdd.ui.activity.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.egdd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class Play1Activity extends AppCompatActivity {


    @BindView(R.id.JCVideoPlayerStandard)
    JCVideoPlayerStandard videoplayer;
    private int firstVisible;//当前第一个可见的item
    private int visibleCount;//当前可见的item个数
    private AbsListView.OnScrollListener onScrollListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play1);
        ButterKnife.bind(this);
        initParlary();
    }

    private void initParlary() {
        String resource = getIntent().getStringExtra("resource");//视频路径
        String playname = getIntent().getStringExtra("playname");//视频路径
        videoplayer.setUp(resource, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, playname);
        videoplayer.thumbImageView.setImageURI(Uri.parse("http://video5lmv.ergedd.com/vsample/21098_20200616185636.jpg"));
        JCVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;  //横向
        JCVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;  //纵向
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}