package com.example.egdd.ui.fragments.listenfragment;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egdd.R;
import com.example.egdd.http.listenhttp.ListenBean;
import com.example.egdd.http.listenhttp.ListenBottomBean;
import com.example.egdd.http.listenhttp.ListenImageBean;
import com.example.egdd.http.listenhttp.ZhongBean;
import com.example.egdd.mvp.listenmvp.firstmvp.FirstPresenter;
import com.example.egdd.mvp.listenmvp.firstmvp.FirstView;
import com.example.egdd.ui.adapter.ListenChoiAdapter;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseMvpFragment<FirstView, FirstPresenter> implements FirstView {

    @BindView(R.id.first_rcy)
    RecyclerView rcy;
    private ArrayList<ListenBean> beans = new ArrayList<>();
    private ListenChoiAdapter adapter;

    public FirstFragment(List<ListenBean> listenBeans) {
        // Required empty public constructor
        beans.addAll(listenBeans);
    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(mActivity));
        ArrayList<ZhongBean> zhongBeans = new ArrayList<>();
        ArrayList<ListenBottomBean> bottomBeans = new ArrayList<>();
        ArrayList<ListenImageBean> iamgeBeans = new ArrayList<>();
        adapter = new ListenChoiAdapter(mActivity, zhongBeans, bottomBeans, iamgeBeans);
        rcy.setAdapter(adapter);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected FirstPresenter initPresenter() {
        return new FirstPresenter();
    }

    @Override
    public void showLog(String str) {
        LogUtils.e(str);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(mActivity, str, Toast.LENGTH_SHORT).show();
    }
}
