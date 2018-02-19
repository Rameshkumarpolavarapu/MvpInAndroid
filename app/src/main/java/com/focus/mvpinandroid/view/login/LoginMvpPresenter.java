package com.focus.mvpinandroid.view.login;

import com.focus.mvpinandroid.view.base.MvpPresenter;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void startLogin(String sEmailId);
}
