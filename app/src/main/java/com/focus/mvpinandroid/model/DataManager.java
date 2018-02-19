package com.focus.mvpinandroid.model;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class DataManager {

    private SharedPrefsHelper mSharedPrefsHelper = null;

    public DataManager(SharedPrefsHelper mSharedPrefsHelper) {
        this.mSharedPrefsHelper = mSharedPrefsHelper;
    }

    public void clear() {
        mSharedPrefsHelper.clear();
    }

    public void saveEmailId(String sEmail) {
        mSharedPrefsHelper.setEmail(sEmail);
    }

    public String getEmailId() {
        return mSharedPrefsHelper.getEmail();
    }

    public void setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    public boolean getLoggedInMode() {
        return mSharedPrefsHelper.getLoggedInMode();
    }

}
