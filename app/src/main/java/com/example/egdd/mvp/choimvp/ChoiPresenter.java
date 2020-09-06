package com.example.egdd.mvp.choimvp;

import com.example.egdd.http.choihttp.ChoiBottomDemo;
import com.example.egdd.http.choihttp.ChoiCenterDemo;
import com.example.egdd.http.choihttp.ChoiCollBack;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class ChoiPresenter extends BasePresenter<ChoiView>implements ChoiCollBack {

    private ChoiModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(ChoiModel.class);
    }

    public void getDemo() {
        modle.getDemo(this,getLifeCycle());
    }

    @Override
    public void succeed(List<ChoiCenterDemo> choiCenterDemos, List<ChoiBottomDemo> choiBottomDemos) {
        mView.getDemo(choiCenterDemos,choiBottomDemos);
    }

    @Override
    public void fild(String str) {
        mView.showLog(str);
    }
}
