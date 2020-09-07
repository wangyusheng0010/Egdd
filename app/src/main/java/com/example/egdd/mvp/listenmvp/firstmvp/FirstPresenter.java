package com.example.egdd.mvp.listenmvp.firstmvp;

import com.example.egdd.http.listenhttp.Firsthttp.FirstCollBack;
import com.example.egdd.http.listenhttp.Firsthttp.ListenBottomBean;
import com.example.egdd.http.listenhttp.Firsthttp.ListenImageBean;
import com.example.egdd.http.listenhttp.Firsthttp.ZhongBean;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.ArrayList;

public class FirstPresenter extends BasePresenter<FirstView> implements FirstCollBack {

    private FirstModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(FirstModel.class);
    }

    public void getDemo() {
        modle.getDemo(this,getLifeCycle());
    }

    @Override
    public void succeed(ArrayList<ZhongBean> list, ArrayList<ListenBottomBean> beans, ArrayList<ListenImageBean> imageBeans) {
        mView.getDemo(list,beans,imageBeans);
    }

    @Override
    public void fild(String str) {
        mView.showLog(str);
    }
}
