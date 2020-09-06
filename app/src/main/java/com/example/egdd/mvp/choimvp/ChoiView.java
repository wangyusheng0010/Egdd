package com.example.egdd.mvp.choimvp;

import com.example.egdd.http.choihttp.ChoiBottomDemo;
import com.example.egdd.http.choihttp.ChoiCenterDemo;
import com.example.mvplibrary.view.BaseView;

import java.util.List;

public interface ChoiView extends BaseView {
    void getDemo(List<ChoiCenterDemo> choiCenterDemos, List<ChoiBottomDemo> choiBottomDemos);
}
