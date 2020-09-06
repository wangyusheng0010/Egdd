package com.example.egdd.mvp.lookmvp;

import com.example.egdd.http.lookhttp.LookCollBack;
import com.example.egdd.http.lookhttp.LookDemo;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class LookPresenter extends BasePresenter<LookView> implements LookCollBack {

    private LookModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(LookModel.class);
    }

    public void getTab() {
        modle.getTab(getLifeCycle(),this);
    }

    @Override
    public void succeed(List<LookDemo> lookDemos) {
        mView.getTab(lookDemos);
    }

    @Override
    public void fild(String str) {
        mView.showLog(str);
    }
}
