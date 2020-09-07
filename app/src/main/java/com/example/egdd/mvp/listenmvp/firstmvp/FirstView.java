package com.example.egdd.mvp.listenmvp.firstmvp;

import com.example.egdd.http.listenhttp.Firsthttp.ListenBottomBean;
import com.example.egdd.http.listenhttp.Firsthttp.ListenImageBean;
import com.example.egdd.http.listenhttp.Firsthttp.ZhongBean;
import com.example.mvplibrary.view.BaseView;

import java.util.ArrayList;

public interface FirstView extends BaseView {

    void getDemo(ArrayList<ZhongBean> list, ArrayList<ListenBottomBean> beans, ArrayList<ListenImageBean> imageBeans);
}
