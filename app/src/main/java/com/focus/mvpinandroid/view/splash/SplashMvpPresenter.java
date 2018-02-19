package com.focus.mvpinandroid.view.splash;

import com.focus.mvpinandroid.view.base.MvpPresenter;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void decideNextActivity();
}
