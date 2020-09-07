package com.example.egdd.ui.activity.video;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egdd.R;
import com.example.egdd.http.videohttp.VideoBean;
import com.example.egdd.mvp.videomvp.VideoPresenter;
import com.example.egdd.mvp.videomvp.VideoView;
import com.example.egdd.ui.adapter.VideoAdapter;
import com.example.mvplibrary.base.BaseMvpActivity;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TingVideoActivity extends BaseMvpActivity<VideoView, VideoPresenter> implements VideoView {

    @BindView(R.id.toolbar_img)
    ImageView toolbarImg;
    @BindView(R.id.toolbar_titname)
    TextView toolbarTitname;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.video_ting)
    RecyclerView videoTing;
    private ArrayList<VideoBean> videoBeans;
    private VideoAdapter adapter;


    @Override
    protected void initData() {
        initToolbar();
        initView();
        initDatas();
    }

    private void initView() {
        videoTing.setLayoutManager(new LinearLayoutManager(this));
        videoTing.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        videoBeans = new ArrayList<>();
        adapter = new VideoAdapter(R.layout.vedeio_item_rcy, videoBeans);
        videoTing.setAdapter(adapter);
    }

    private void initDatas() {
        String tingid = getIntent().getStringExtra("tingid");
        int id = Integer.valueOf(tingid).intValue();
        mPresenter.getData(id);
    }
    private void initToolbar() {
        setSupportActionBar(toolbar);
        toolbarImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_vedio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.vedio_menu_item1:

                break;
            case R.id.vedio_menu_item2:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_ting_video;
    }

    @Override
    protected VideoPresenter initPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void videoShowok(List<VideoBean> videoBeans) {
        videoBeans.addAll(videoBeans);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLog(String str) {
        Log.e("TAG", "showLog: "+str );
    }

    @Override
    public void showToast(String str) {

    }
}