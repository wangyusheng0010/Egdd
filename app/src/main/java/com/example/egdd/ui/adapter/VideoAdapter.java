package com.example.egdd.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.egdd.R;
import com.example.egdd.http.videohttp.VideoBean;

import java.util.List;

/**
 * Created by ASUS
 * <p>
 * Date :2020/9/7
 * <p>
 * name :Fanyajun
 * <p>
 * Description :T0D0
 */
public class VideoAdapter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {
    public VideoAdapter(int layoutResId, @Nullable List<VideoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, VideoBean videoBean) {
        baseViewHolder.setText(R.id.vedio_rcy_name,videoBean.getName());
        Glide.with(mContext).load(videoBean.getImage()).into((ImageView) baseViewHolder.getView(R.id.vedio_rcy_img));
        if (videoBean.getDownload_type() == 1){
            Glide.with(mContext).load(R.drawable.ic_arrow_downward).into((ImageView) baseViewHolder.getView(R.id.vedio_rcy_load));
        }else {
            Glide.with(mContext).load(R.drawable.ic_close).into((ImageView) baseViewHolder.getView(R.id.vedio_rcy_load));
        }

    }
}
