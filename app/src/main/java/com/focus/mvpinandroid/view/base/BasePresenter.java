package com.focus.mvpinandroid.view.base;

import com.focus.mvpinandroid.model.DataManager;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView = null;
    private DataManager mDataManager = null;

    public BasePresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onAttach(V mMvpView) {
        this.mMvpView = mMvpView;
    }

    protected V getMvpView() {
        return mMvpView;
    }

    protected DataManager getDataManager() {
        return mDataManager;
    }
}