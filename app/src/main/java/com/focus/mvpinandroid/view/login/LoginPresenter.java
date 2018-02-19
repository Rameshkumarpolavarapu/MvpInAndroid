package com.focus.mvpinandroid.view.login;

import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.view.base.BasePresenter;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    public LoginPresenter(DataManager mDataManager) {
        super(mDataManager);
    }

    @Override
    public void startLogin(String sEmailId) {
        getDataManager().saveEmailId(sEmailId);
        getDataManager().setLoggedIn();
        getMvpView().openMainActivity();
    }
}
