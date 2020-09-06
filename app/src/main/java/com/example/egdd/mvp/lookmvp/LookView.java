package com.example.egdd.mvp.lookmvp;

import com.example.egdd.http.lookhttp.LookDemo;
import com.example.mvplibrary.view.BaseView;

import java.util.List;

public interface LookView extends BaseView {

    void getTab(List<LookDemo> lookDemos);
}
