package com.example.egdd.ui.activity.video;

import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.egdd.R;
import com.example.egdd.http.choihttp.ChoiBottomDemo;
import com.example.egdd.http.videohttp.VideoBean;
import com.example.egdd.mvp.videomvp.VideoPresenter;
import com.example.egdd.mvp.videomvp.VideoView;
import com.example.egdd.ui.adapter.ChoiBottomAdapter;
import com.example.egdd.ui.adapter.VideoAdapter;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
    private int tingid;
    private ArrayList<ChoiBottomDemo> choiBottomDemos;


    @Override
    protected void initData() {
        initToolbar();
        initView();
        initDatas();

    }

    private void initView() {
        videoTing.setLayoutManager(new LinearLayoutManager(this));
        videoTing.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        videoBeans = new ArrayList<>();
        adapter = new VideoAdapter(R.layout.vedeio_item_rcy, videoBeans);
        videoTing.setAdapter(adapter);


        initListener();


    }

    private void initListener() {
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(TingVideoActivity.this, "播放视频", Toast.LENGTH_SHORT).show();
                String resource = videoBeans.get(i).getResource();//播放的视频路径
                String name = videoBeans.get(i).getName();
                Intent intent = new Intent(TingVideoActivity.this, Play1Activity.class);
                intent.putExtra("resource", resource);
                intent.putExtra("playname", name);
                startActivity(intent);
            }
        });
    }

    private void initDatas() {
        //传进id
        tingid = getIntent().getIntExtra("tingid", 0);
        String tingname = getIntent().getStringExtra("tingname");//标题字
        toolbarTitname.setText(tingname);//修改
        mPresenter.getData(tingid);//获取数据mvp
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
        getMenuInflater().inflate(R.menu.menu_vedio, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vedio_menu_item1:

                break;
            case R.id.vedio_menu_item2:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected int initLayoutId() {//布局
        return R.layout.activity_ting_video;
    }

    @Override
    protected VideoPresenter initPresenter() {
        return new VideoPresenter();
    }

    @Override
    public void videoShowok(List<VideoBean> videoBeans1) {
        videoBeans.addAll(videoBeans1);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showLog(String str) {
        LogUtils.e(str);
    }

    @Override
    public void showToast(String str) {

    }
}