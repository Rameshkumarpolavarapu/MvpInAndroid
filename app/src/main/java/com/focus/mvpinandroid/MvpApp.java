package com.focus.mvpinandroid;

import android.app.Application;

import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.model.SharedPrefsHelper;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class MvpApp extends Application {
    DataManager dataManager = null;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
