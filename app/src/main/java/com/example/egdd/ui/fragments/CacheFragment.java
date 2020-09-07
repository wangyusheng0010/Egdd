package com.example.egdd.ui.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.egdd.R;
import com.example.egdd.ui.activity.caches.SettingActivity;
import com.example.egdd.ui.fragments.cachefragments.MusicFragment;
import com.example.egdd.ui.fragments.cachefragments.VideoFragment;
import com.example.egdd.ui.fragments.cachefragments.VideoalbumFragment;
import com.example.mvplibrary.base.BaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CacheFragment extends BaseFragment {


    @BindView(R.id.iv_setting)
    ImageView ivSetting;
    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.seek_bar)
    SeekBar seekBar;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.rl_WX)
    RelativeLayout rlWX;
    @BindView(R.id.tabs)
    TabLayout tabs;
    private ArrayList<Fragment> fragments;

    public CacheFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_cache, container, false);
//        initView(view);
//        return view;
//    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new VideoalbumFragment());
        fragments.add(new VideoFragment());
        fragments.add(new MusicFragment());
        vp.setAdapter(new FragmentStatePagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tabs.setupWithViewPager(vp);
        tabs.getTabAt(0).setText("视频专辑");
        tabs.getTabAt(1).setText("视频");
        tabs.getTabAt(2).setText("音频");
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (null !=customView&&customView instanceof TextView){
                    ((TextView) customView).setTextColor(R.drawable.select_cache_tabtextcolor);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //清理缓存监听
        tvCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tvCache.getText().toString();
                if (s.equals("清理缓存")){
                    tvCache.setText("取消");
                    rlWX.setVisibility(View.GONE);
                }
                if (s.equals("取消")){
                    tvCache.setText("清理缓存");
                    rlWX.setVisibility(View.VISIBLE);
                }
            }
        });

        //设置监听
        ivSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, SettingActivity.class);
                mActivity.startActivity(intent);
            }
        });
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_cache;
    }

}
