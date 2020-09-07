package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.listenhttp.Twohttp.TwoBean;
import com.example.mvplibrary.view.BaseView;

import java.util.List;

public class TwoAdapter extends BaseQuickAdapter<TwoBean, BaseViewHolder> {
    public TwoAdapter(int layoutResId, @Nullable List<TwoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, TwoBean twoBean) {
        baseViewHolder.setText(R.id.two_title,twoBean.getName())
                .setText(R.id.two_desc,twoBean.getDescription());
        Glide.with(mContext).load(twoBean.getImage()).into((ImageView) baseViewHolder.getView(R.id.two_iv));
    }
}
