package com.example.egdd.ui.fragments.lookfragment;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egdd.R;
import com.example.egdd.http.partnerhttp.PartnerDemo;
import com.example.egdd.mvp.partnermvp.ParPresenter;
import com.example.egdd.mvp.partnermvp.ParView;
import com.example.egdd.ui.adapter.ParRcyAdapter;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartnerFragment extends BaseMvpFragment<ParView, ParPresenter> implements ParView {

    @BindView(R.id.par_rcy)
    RecyclerView rcy;
    private ArrayList<PartnerDemo> list;
    private ParRcyAdapter adapter;

    public PartnerFragment() {
        // Required empty public constructor
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_partner;
    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected void initView() {
        rcy.setLayoutManager(new GridLayoutManager(mActivity,3));
        list = new ArrayList<>();
        adapter = new ParRcyAdapter(R.layout.par_rcy_item, list);
        rcy.setAdapter(adapter);
        mPresenter.getDemo();
    }

    @Override
    protected ParPresenter initPresenter() {
        return new ParPresenter();
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
    public void getDemo(List<PartnerDemo> list) {
        this.list.addAll(list);
        adapter.setNewData(this.list);
    }
}
