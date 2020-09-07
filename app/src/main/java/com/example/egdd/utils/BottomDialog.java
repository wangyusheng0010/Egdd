package com.example.egdd.utils;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.egdd.R;
import com.example.egdd.ui.activity.caches.adapter.DiaLogAdpter;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class BottomDialog extends BottomSheetDialog {

    private Context context;
    private final RecyclerView rv;
    private final ArrayList<String> list;

    public BottomDialog(@NonNull Context context) {
        super(context);
        this.context=context;
        setContentView(R.layout.layout_dialog);
        rv = findViewById(R.id.rv);
        list = new ArrayList<>();

        list.add("不休息");
        list.add("15分钟");
        list.add("30分钟");
        list.add("45分钟");
        list.add("60分钟");
        rv.setLayoutManager(new LinearLayoutManager(context));
        DiaLogAdpter diaLogAdpter = new DiaLogAdpter(R.layout.layout_dialog_item, list);
        rv.setAdapter(diaLogAdpter);
        diaLogAdpter.notifyDataSetChanged();
        diaLogAdpter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String s = list.get(position);
                EventBus.getDefault().postSticky(s);
            }
        });
    }
}
