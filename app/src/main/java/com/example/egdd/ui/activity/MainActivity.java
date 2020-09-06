package com.example.egdd.ui.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.egdd.R;
import com.example.egdd.ui.fragments.BabyListenFragment;
import com.example.egdd.ui.fragments.BabyLookFragment;
import com.example.egdd.ui.fragments.CacheFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnb)
    TabLayout bnb;
    private FragmentManager manager;
    private BabyLookFragment babyLookFragment;
    private BabyListenFragment babyListenFragment;
    private CacheFragment cacheFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment(); //设置主fragment
        Log.e("11", "onCreate: "+"上传" );
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        babyLookFragment = new BabyLookFragment();
        babyListenFragment = new BabyListenFragment();
        cacheFragment = new CacheFragment();
        manager.beginTransaction().add(R.id.my_activity_rl, babyLookFragment)
                .add(R.id.my_activity_rl, babyListenFragment)
                .add(R.id.my_activity_rl, cacheFragment)
                .show(babyLookFragment)
                .hide(babyListenFragment)
                .hide(cacheFragment)
                .commit();

        bnb.addTab(bnb.newTab().setText("宝宝看").setIcon(R.drawable.bnb_select_look));
        bnb.addTab(bnb.newTab().setText("宝宝听").setIcon(R.drawable.bnb_select_listen));
        bnb.addTab(bnb.newTab().setText("缓存").setIcon(R.drawable.bnb_select_cache));

        //对tablayout进行监听 进行切换Fragment
        bnb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        manager.beginTransaction()
                                .show(babyLookFragment)
                                .hide(babyListenFragment)
                                .hide(cacheFragment)
                                .commit();
//                        bnb.getTabAt(0).setIcon()
                        break;
                    case 1:
                        manager.beginTransaction()
                                .show(babyListenFragment)
                                .hide(babyLookFragment)
                                .hide(cacheFragment)
                                .commit();
                        break;
                    case 2:
                        manager.beginTransaction()
                                .show(cacheFragment)
                                .hide(babyLookFragment)
                                .hide(babyListenFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
