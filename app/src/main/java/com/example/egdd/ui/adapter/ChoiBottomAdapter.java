package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.choihttp.ChoiBottomDemo;

import java.util.List;

public class ChoiBottomAdapter extends BaseQuickAdapter<ChoiBottomDemo, BaseViewHolder> {
    public ChoiBottomAdapter(int layoutResId, @Nullable List<ChoiBottomDemo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, ChoiBottomDemo choiBottomDemo) {
        baseViewHolder.addOnClickListener(R.id.rl);
        baseViewHolder.setText(R.id.bottom_name,choiBottomDemo.getItem().getName()).addOnLongClickListener(R.id.bottom_name);
        Glide.with(mContext).load(choiBottomDemo.getItem().getImage()).into((ImageView) baseViewHolder.getView(R.id.bottom_iv));
        if (choiBottomDemo.getItem().getDownload_type() == 1){
            Glide.with(mContext).load(R.drawable.ic_arrow_downward).into((ImageView) baseViewHolder.getView(R.id.bottom_load));
        }else {
            Glide.with(mContext).load(R.drawable.ic_close).into((ImageView) baseViewHolder.getView(R.id.bottom_load));
        }
    }
}
