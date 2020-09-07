package com.example.egdd.ui.fragments.listenfragment;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egdd.R;
import com.example.egdd.http.listenhttp.Twohttp.TwoBean;
import com.example.egdd.mvp.listenmvp.twomvp.TwoPresenter;
import com.example.egdd.mvp.listenmvp.twomvp.TwoView;
import com.example.egdd.ui.adapter.TwoAdapter;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends BaseMvpFragment<TwoView, TwoPresenter> implements TwoView {
    @BindView(R.id.two_rcy)
    RecyclerView rcy;
    private int id;
    private ArrayList<TwoBean> list;
    private TwoAdapter adapter;

    public TwoFragment(int id) {
        // Required empty public constructor
        this.id = id;
    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new LinearLayoutManager(mActivity));
        rcy.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adapter = new TwoAdapter(R.layout.two_rcy_item, list);
        rcy.setAdapter(adapter);
        mPresenter.getDemo(id);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected TwoPresenter initPresenter() {
        return new TwoPresenter();
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
    public void getDemo(ArrayList<TwoBean> list) {
        this.list.addAll(list);
        adapter.setNewData(this.list);
    }
}
