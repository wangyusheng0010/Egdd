package com.example.mvplibrary.base;

import com.example.mvplibrary.presenter.BasePresenter;
import com.example.mvplibrary.view.BaseView;

/**
 * 项目名：Shopping
 * 包名：  com.example.mvplibrary.base
 * 文件名：BaseMvpActivity
 * 创建者：liangxq
 * 创建时间：2020/8/5  15:23
 * 描述：TODO
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {
    public P mPresenter;
    @Override
    protected void initEvent() {
        mPresenter = initPresenter();
        initModel();
        if (mPresenter != null) {
            mPresenter.attacthView((V) this);
        }
    }

    protected abstract void initModel();

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.destoryView();
            mPresenter = null;
        }
    }
}
