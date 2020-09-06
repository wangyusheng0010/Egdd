package com.example.egdd.ui.fragments;

import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.egdd.R;
import com.example.egdd.http.lookhttp.LookDemo;
import com.example.egdd.mvp.lookmvp.LookPresenter;
import com.example.egdd.mvp.lookmvp.LookView;
import com.example.egdd.ui.adapter.LookVpAdapter;
import com.example.egdd.ui.fragments.lookfragment.AllFragment;
import com.example.egdd.ui.fragments.lookfragment.ChoiFragment;
import com.example.egdd.ui.fragments.lookfragment.PartnerFragment;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyLookFragment extends BaseMvpFragment<LookView, LookPresenter>implements LookView {

    @BindView(R.id.look_tb)
    Toolbar tb;
    @BindView(R.id.look_tab)
    TabLayout tab;
    @BindView(R.id.look_vp)
    ViewPager vp;
    private ChoiFragment choiFragment;
//    private AnimationFragment animationFragment;
    private PartnerFragment partnerFragment;
    private ArrayList<Fragment> fragments;
    private LookVpAdapter adapter;
    List<LookDemo> lookDemos = new ArrayList<>();

    public BabyLookFragment() {
        // Required empty public constructor
    }


    @Override
    protected int initLayoutId() {
        return R.layout.fragment_baby_look;
    }

    private void initVp() {
        adapter = new LookVpAdapter(getChildFragmentManager(), 0, fragments);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        int i = 0;
        tab.getTabAt(i).setText("精选");
        i++;
        for (int i1 = 0; i1 < lookDemos.size(); i1++) {
            tab.getTabAt(i).setText(lookDemos.get(i1).getName());
            i++;
        }
        tab.getTabAt(i).setText("伙伴");
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        //精选
        choiFragment = new ChoiFragment();
        //伙伴
        partnerFragment = new PartnerFragment();
        fragments.add(choiFragment);
        for (int i = 0; i < lookDemos.size(); i++) {
            fragments.add(new AllFragment(lookDemos.get(i)));
        }
        fragments.add(partnerFragment);


    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected void initView() {
        mPresenter.getTab();
        initFragment();
        initVp();
    }

    @Override
    protected LookPresenter initPresenter() {
        return new LookPresenter();
    }

    @Override
    public void showLog(String str) {
        LogUtils.e(str);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(mActivity, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getTab(List<LookDemo> lookDemos) {
        this.lookDemos = lookDemos;
        initFragment();
        initVp();
    }
}
