package com.focus.mvpinandroid.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class SharedPrefsHelper {

    private static final String MY_PREFERENCE = "MY_PREFERENCE";
    private static final String EMAIL = "EMAIL";
    private static final String LOGGED_IN = "IS_LOGGED_IN";

    private SharedPreferences mSharedPreferences = null;

    public SharedPrefsHelper(Context context) {
        mSharedPreferences = context.getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);
    }

    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

    public void setEmail(String sEmail) {
        mSharedPreferences.edit().putString(EMAIL, sEmail).apply();
    }

    public String getEmail() {
        return mSharedPreferences.getString(EMAIL, null);
    }

    public boolean getLoggedInMode() {
        return mSharedPreferences.getBoolean(LOGGED_IN, false);
    }

    public void setLoggedInMode(boolean bIsLoggedIn) {
        mSharedPreferences.edit().putBoolean(LOGGED_IN, bIsLoggedIn).apply();
    }
}