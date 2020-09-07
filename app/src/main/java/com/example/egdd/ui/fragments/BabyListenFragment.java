package com.example.egdd.ui.fragments;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.egdd.R;
import com.example.egdd.http.listenhttp.ListenBean;
import com.example.egdd.mvp.listenmvp.ListenPresenter;
import com.example.egdd.mvp.listenmvp.ListenView;
import com.example.egdd.ui.adapter.ListenVpAdapter;
import com.example.egdd.ui.fragments.listenfragment.FirstFragment;
import com.example.egdd.ui.fragments.listenfragment.TwoFragment;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BabyListenFragment extends BaseMvpFragment<ListenView, ListenPresenter> implements ListenView {

    @BindView(R.id.listen_tab)
    TabLayout tab;
    @BindView(R.id.listen_vp)
    ViewPager vp;
    private FragmentManager fragmentManager;
    private ListenVpAdapter adapter;

    public BabyListenFragment() {
    }

    @Override
    protected void initView() {
        //获取tablayout
        mPresenter.getTab();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_baby_listen;
    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected ListenPresenter initPresenter() {
        return new ListenPresenter();
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
    public void getTab(List<ListenBean> listenBeans) {
        initFragment(listenBeans);
    }

    private void initFragment(List<ListenBean> listenBeans) {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new FirstFragment(listenBeans));
        for (int i = 0; i < listenBeans.size(); i++) {
            if (!listenBeans.get(i).getName().equals("百科"))
                list.add(new TwoFragment(listenBeans.get(i)));
        }
        adapter = new ListenVpAdapter(getChildFragmentManager(), 0, list);
        vp.setAdapter(adapter);
        tab.setupWithViewPager(vp);
        int o = 0;
        tab.getTabAt(o).setText("精选");
        o++;
        for (int i = 0; i < listenBeans.size(); i++) {
            if (!listenBeans.get(i).getName().equals("百科")) {
                tab.getTabAt(o).setText(listenBeans.get(i).getName());
                o++;
            }
        }
    }


}
