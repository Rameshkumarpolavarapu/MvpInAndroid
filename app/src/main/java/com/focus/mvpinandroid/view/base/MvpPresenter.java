package com.focus.mvpinandroid.view.base;

import android.support.v7.view.menu.MenuView;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mMvpView);
}