package com.focus.mvpinandroid.view.main;

import com.focus.mvpinandroid.view.base.MvpPresenter;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    String getEmailId();
    void setUserLoggedOut();
}
