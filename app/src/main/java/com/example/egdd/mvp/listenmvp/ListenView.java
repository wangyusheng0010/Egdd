package com.example.egdd.mvp.listenmvp;

import com.example.egdd.http.listenhttp.ListenBean;
import com.example.mvplibrary.view.BaseView;

import java.util.List;

public interface ListenView extends BaseView {
    void getTab(List<ListenBean> listenBeans);
}
