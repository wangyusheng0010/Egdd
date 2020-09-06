package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.partnerhttp.PartnerDemo;

import java.util.List;

public class ParRcyAdapter extends BaseQuickAdapter<PartnerDemo, BaseViewHolder> {
    public ParRcyAdapter(int layoutResId, @Nullable List<PartnerDemo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, PartnerDemo partnerDemo) {
        baseViewHolder.setText(R.id.par_name,partnerDemo.getTitle());
        Glide.with(mContext).load(partnerDemo.getImage_url()).into((ImageView) baseViewHolder.getView(R.id.par_iv));
    }
}
