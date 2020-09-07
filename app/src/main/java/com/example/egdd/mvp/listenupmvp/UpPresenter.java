package com.example.egdd.mvp.listenupmvp;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

public class UpPresenter extends BasePresenter<UpView> {

    private UpModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(UpModel.class);
    }
}
