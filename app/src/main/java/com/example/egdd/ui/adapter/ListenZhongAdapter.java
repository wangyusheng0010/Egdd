package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.listenhttp.Firsthttp.ZhongBean;

import java.util.List;

public class ListenZhongAdapter extends BaseQuickAdapter<ZhongBean, BaseViewHolder> {
    public ListenZhongAdapter(int layoutResId, @Nullable List<ZhongBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ZhongBean zhongBean) {
        baseViewHolder.setText(R.id.listen_zhong_title,zhongBean.getName());
        Glide.with(mContext).load(zhongBean.getSquare_image_url()).into((ImageView) baseViewHolder.getView(R.id.listen_zhong_iv));
    }
}
