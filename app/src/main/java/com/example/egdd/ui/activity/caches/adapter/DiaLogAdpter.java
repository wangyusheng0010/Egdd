package com.example.egdd.ui.activity.caches.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;

import java.util.List;

public class DiaLogAdpter extends BaseQuickAdapter<String, BaseViewHolder> {
    public DiaLogAdpter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        TextView tv_name = helper.getView(R.id.tv_name);
        tv_name.setText(item);
        int layoutPosition = helper.getLayoutPosition();
        helper.addOnClickListener(layoutPosition);
    }
}
