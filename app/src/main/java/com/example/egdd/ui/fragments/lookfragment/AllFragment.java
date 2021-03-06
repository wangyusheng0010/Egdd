package com.example.egdd.ui.fragments.lookfragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.egdd.R;
import com.example.egdd.http.lookhttp.LookDemo;
import com.example.egdd.ui.activity.MainActivity;
import com.example.egdd.ui.adapter.AllRcyAdapter;
import com.example.httplibrary.utils.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllFragment extends Fragment {

    LookDemo lookDemo;
    @BindView(R.id.all_rcy)
    RecyclerView rcy;
    private Unbinder bind;
    private List<LookDemo.AlbumsBean> list;
    private AllRcyAdapter adapter;
    private int pop;

    public AllFragment(LookDemo lookDemo) {
        this.lookDemo = lookDemo;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        bind = ButterKnife.bind(this, view);
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcy.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = lookDemo.getAlbums();
        adapter = new AllRcyAdapter(R.layout.all_rcy_item, list);
        rcy.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null){
            bind.unbind();
        }
    }
}
