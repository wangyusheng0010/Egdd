package com.example.egdd.mvp.videomvp;

import com.example.egdd.http.choihttp.ChoiBottomDemo;
import com.example.egdd.http.videohttp.VideoBean;
import com.example.egdd.http.videohttp.VideoCallBack;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

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
public class VideoPresenter extends BasePresenter<VideoView> implements VideoCallBack {

    private VideoModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(VideoModel.class);
    }

    @Override
    public void showLog(String str) {
        mView.showLog(str);
    }

    @Override
    public void showToast(String str) {

    }

    @Override
    public void videoShowok(List<VideoBean> videoBeans) {
        mView.videoShowok(videoBeans);
    }



    public void getData(int id) {
        modle.getDatas(this,getLifeCycle(),id);
    }


}
