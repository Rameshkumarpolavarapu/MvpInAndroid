package com.focus.mvpinandroid.view.splash;

import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.view.base.BasePresenter;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class SplashPresenter <V extends SplashMvpView> extends BasePresenter <V> implements SplashMvpPresenter <V> {

    public SplashPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    public void decideNextActivity() {

        if (getDataManager().getLoggedInMode()) {
            getMvpView().openMainActivity();
        } else {
            getMvpView().openLoginActivity();
        }
    }
}
