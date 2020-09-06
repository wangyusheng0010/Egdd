package com.example.egdd.ui.fragments.lookfragment;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.egdd.R;
import com.example.egdd.http.choihttp.ChoiBottomDemo;
import com.example.egdd.http.choihttp.ChoiCenterDemo;
import com.example.egdd.mvp.choimvp.ChoiPresenter;
import com.example.egdd.mvp.choimvp.ChoiView;
import com.example.egdd.ui.adapter.ChoiBottomAdapter;
import com.example.egdd.ui.adapter.ChoiCenterRcyAdapter;
import com.example.httplibrary.utils.LogUtils;
import com.example.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiFragment extends BaseMvpFragment<ChoiView, ChoiPresenter> implements ChoiView {

    @BindView(R.id.center_rcy)
    RecyclerView centerRcy;
    @BindView(R.id.bottom_rcy)
    RecyclerView bottomRcy;
//    @BindView(R.id.choi_sm)
//    MRefreshHeader sm;
    private ArrayList<ChoiCenterDemo> list;
    private ChoiCenterRcyAdapter centerAdapter;
    private ArrayList<ChoiBottomDemo> list1;
    private ChoiBottomAdapter bottomAdapter;

    public ChoiFragment() {
        // Required empty public constructor
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_choi;
    }

    @Override
    protected void initModel() {
        mPresenter.initModel();
    }

    @Override
    protected void initView() {
        centerRcy.setLayoutManager(new GridLayoutManager(mActivity, 4));
        list = new ArrayList<>();
        centerAdapter = new ChoiCenterRcyAdapter(R.layout.choi_center_item, list);
        centerRcy.setAdapter(centerAdapter);
        bottomRcy.setLayoutManager(new LinearLayoutManager(mActivity));
        bottomRcy.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        list1 = new ArrayList<>();
        bottomAdapter = new ChoiBottomAdapter(R.layout.choi_bottom_item, list1);
        bottomRcy.setAdapter(bottomAdapter);
        mPresenter.getDemo();
    }

    @Override
    protected ChoiPresenter initPresenter() {
        return new ChoiPresenter();
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
    public void getDemo(List<ChoiCenterDemo> choiCenterDemos, List<ChoiBottomDemo> choiBottomDemos) {
        ArrayList<ChoiCenterDemo> list = new ArrayList<>();
        for (int i = 0; i < choiCenterDemos.size(); i++) {
            if (i < 8) {
                list.add(choiCenterDemos.get(i));
            }
        }
        this.list.addAll(list);
        list1.addAll(choiBottomDemos);
        centerAdapter.setNewData(this.list);
        bottomAdapter.setNewData(list1);
    }
}
