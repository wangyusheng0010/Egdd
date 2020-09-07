package com.example.egdd.ui.activity.video;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.egdd.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class ChioVideoActivity extends AppCompatActivity {

    @BindView(R.id.JCVideoPlayer)
    JCVideoPlayerStandard JCVideoPlayer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chio_video);
        ButterKnife.bind(this);

        initParlary();
    }
    private void initParlary() {
        String resource = getIntent().getStringExtra("resource1");//视频路径
        String playname = getIntent().getStringExtra("name1");//视频路径
        JCVideoPlayer1.setUp(resource, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, playname);
        JCVideoPlayer1.thumbImageView.setImageURI(Uri.parse("http://video5lmv.ergedd.com/vsample/21098_20200616185636.jpg"));
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