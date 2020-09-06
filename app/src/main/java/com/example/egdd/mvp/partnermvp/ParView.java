package com.example.egdd.mvp.partnermvp;

import com.example.egdd.http.partnerhttp.PartnerDemo;
import com.example.mvplibrary.view.BaseView;

import java.util.List;

public interface ParView extends BaseView {
    void getDemo(List<PartnerDemo> list);
}
