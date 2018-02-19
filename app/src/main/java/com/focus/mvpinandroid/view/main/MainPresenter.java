package com.focus.mvpinandroid.view.main;

import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.view.base.BasePresenter;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class MainPresenter <V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V>{


    public MainPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public String getEmailId() {
        return getDataManager().getEmailId();
    }

    @Override
    public void setUserLoggedOut() {
        getDataManager().clear();
        getMvpView().openSplashActivity();
    }
}
