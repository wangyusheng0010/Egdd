package com.example.egdd.mvp.listenmvp.twomvp;

import com.example.egdd.http.listenhttp.Twohttp.TwoBean;
import com.example.mvplibrary.view.BaseView;

import java.util.ArrayList;

public interface TwoView extends BaseView {
    void getDemo(ArrayList<TwoBean> list);
}
