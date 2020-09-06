package com.example.egdd.mvp.listenmvp;

import com.example.egdd.http.listenhttp.ListenBean;
import com.example.egdd.http.listenhttp.ListenCollBack;
import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

import java.util.List;

public class ListenPresenter extends BasePresenter<ListenView> implements ListenCollBack {

    private ListenModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(ListenModel.class);
    }

    public void getTab() {
        modle.getTab(this,getLifeCycle());
    }

    @Override
    public void succeed(List<ListenBean> listenBeans) {
        mView.getTab(listenBeans);
    }

    @Override
    public void fild(String str) {
        mView.showLog(str);
    }
}
