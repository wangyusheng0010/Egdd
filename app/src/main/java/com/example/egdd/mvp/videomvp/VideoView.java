package com.example.egdd.mvp.videomvp;

import com.example.egdd.http.videohttp.VideoBean;
import com.example.mvplibrary.view.BaseView;

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
public interface VideoView extends BaseView {
    void videoShowok(List<VideoBean> videoBeans);

}
