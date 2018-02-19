package com.focus.mvpinandroid.view.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.focus.mvpinandroid.MvpApp;
import com.focus.mvpinandroid.R;
import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.view.base.BaseActivity;
import com.focus.mvpinandroid.view.splash.SplashActivity;

public class MainActivity extends BaseActivity implements MainMvpView {

    private TextView textViewShow;
    private Button buttonLogout;
    private MainPresenter mainPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dataManager = ((MvpApp) getApplicationContext()).getDataManager();
        mainPresenter = new MainPresenter(dataManager);
        mainPresenter.onAttach(this);

        textViewShow = findViewById(R.id.textViewShow);
        buttonLogout = findViewById(R.id.buttonLogout);
        textViewShow.setText("" + mainPresenter.getEmailId());
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.setUserLoggedOut();
            }
        });

    }

    @Override
    public void openSplashActivity() {
        startActivity(SplashActivity.getStartIntent(this));
        finish();
    }
}