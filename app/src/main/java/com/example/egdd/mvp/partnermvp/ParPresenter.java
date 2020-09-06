package com.example.egdd.mvp.partnermvp;

import com.example.egdd.http.partnerhttp.ParCollBack;
import com.example.egdd.http.partnerhttp.PartnerDemo;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class ParPresenter extends BasePresenter<ParView> implements ParCollBack {

    private ParModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(ParModel.class);
    }

    public void getDemo() {
        modle.getDemo(this,getLifeCycle());
    }

    @Override
    public void succeed(List<PartnerDemo> list) {
        mView.getDemo(list);
    }

    @Override
    public void fild(String str) {
        mView.showLog(str);
    }
}
