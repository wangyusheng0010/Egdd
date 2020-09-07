package com.example.egdd.http.videohttp;

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
public interface VideoCallBack {
    void showLog(String str);
    void showToast(String str);
    void videoShowok(List<VideoBean> videoBeans);
}
