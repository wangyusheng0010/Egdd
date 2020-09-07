package com.example.egdd.mvp.listenmvp.firstmvp;

import com.example.mvplibrary.model.ModleFractory;
import com.example.mvplibrary.presenter.BasePresenter;

public class FirstPresenter extends BasePresenter<FirstView> {

    private FirstModel modle;

    public void initModel(){
        modle = ModleFractory.creatModle(FirstModel.class);
    }
}
