package com.focus.mvpinandroid.view.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.airbnb.lottie.LottieAnimationView;
import com.focus.mvpinandroid.MvpApp;
import com.focus.mvpinandroid.R;
import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.view.base.BaseActivity;
import com.focus.mvpinandroid.view.login.LoginActivity;
import com.focus.mvpinandroid.view.main.MainActivity;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class SplashActivity extends BaseActivity implements SplashMvpView {

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        LinearLayout layout =   new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams params    =   new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity  = Gravity.CENTER;
        layout.setLayoutParams(params);

        LottieAnimationView animationView   =   new LottieAnimationView(getApplicationContext());
        animationView.setAnimation("an_endless_hike_on_a_tiny_world_.json");
        animationView.setLayoutParams(params);
        animationView.loop(true);
        animationView.playAnimation();
        layout.addView(animationView);
        /// METHOD 1

        setContentView(layout);


        DataManager dataManager = ((MvpApp) getApplicationContext()).getDataManager();
        final SplashPresenter mSplashPresenter = new SplashPresenter(dataManager);

        mSplashPresenter.onAttach(this);

        int TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSplashPresenter.decideNextActivity();
            }
        }, TIME_OUT);

    }

    @Override
    public void openMainActivity() {
        startActivity(MainActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }
}