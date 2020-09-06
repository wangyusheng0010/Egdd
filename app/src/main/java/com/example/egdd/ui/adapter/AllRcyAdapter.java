package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.lookhttp.LookDemo;

import java.util.List;

public class AllRcyAdapter extends BaseQuickAdapter<LookDemo.AlbumsBean, BaseViewHolder> {
    public AllRcyAdapter(int layoutResId, @Nullable List<LookDemo.AlbumsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, LookDemo.AlbumsBean albumsBean) {
        baseViewHolder.setText(R.id.all_name,albumsBean.getName())
                .setText(R.id.all_desc,albumsBean.getDescription())
                .setText(R.id.all_count,"共"+albumsBean.getVideo_count()+"集");
        Glide.with(mContext).load(albumsBean.getImage_url()).into((ImageView) baseViewHolder.getView(R.id.all_iv));
    }
}
