package com.example.egdd.ui.activity.video;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.egdd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayActivity extends AppCompatActivity {


    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard videoplayer;
    private int firstVisible;//当前第一个可见的item
    private int visibleCount;//当前可见的item个数
    private AbsListView.OnScrollListener onScrollListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        ButterKnife.bind(this);

        initParlary();

    }

    private void initParlary() {
        String resource = getIntent().getStringExtra("resource");//视频路径
        String playname = getIntent().getStringExtra("playname");//视频路径
        videoplayer.setUp(resource, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, playname);
        videoplayer.thumbImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"));
        
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