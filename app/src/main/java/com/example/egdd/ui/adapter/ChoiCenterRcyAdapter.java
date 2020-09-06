package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.choihttp.ChoiCenterDemo;

import java.util.List;

public class ChoiCenterRcyAdapter extends BaseQuickAdapter<ChoiCenterDemo, BaseViewHolder> {
    public ChoiCenterRcyAdapter(int layoutResId, @Nullable List<ChoiCenterDemo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ChoiCenterDemo choiDemo) {
        baseViewHolder.setText(R.id.center_name,choiDemo.getName());
        Glide.with(mContext).load(choiDemo.getIcon_url()).into((ImageView) baseViewHolder.getView(R.id.center_iv));
    }
}
