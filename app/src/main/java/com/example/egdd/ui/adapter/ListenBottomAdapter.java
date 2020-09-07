package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.listenhttp.Firsthttp.ListenBottomBean;

import java.util.List;

public class ListenBottomAdapter extends BaseQuickAdapter<ListenBottomBean.PlaylistsBean, BaseViewHolder> {
    public ListenBottomAdapter(int layoutResId, @Nullable List<ListenBottomBean.PlaylistsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ListenBottomBean.PlaylistsBean bean) {
        baseViewHolder.setText(R.id.listen_bottom_title,bean.getName());
        Glide.with(mContext).load(bean.getImage()).into((ImageView) baseViewHolder.getView(R.id.listen_bottom_iv));
    }
}
