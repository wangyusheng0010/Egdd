package com.example.egdd.mvp.listenmvp.twomvp;

import com.example.egdd.http.listenhttp.Twohttp.TwoBean;
import com.example.egdd.http.listenhttp.Twohttp.TwoCollback;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.ArrayList;

public class TwoPresenter extends BasePresenter<TwoView>implements TwoCollback {

    private TwoModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(TwoModel.class);
    }

    public void getDemo(int id) {
        modle.getDemo(id,this,getLifeCycle());
    }

    @Override
    public void succeed(ArrayList<TwoBean> list) {
        mView.getDemo(list);
    }

    @Override
    public void fild(String str) {
        mView.showLog(str);
    }
}
