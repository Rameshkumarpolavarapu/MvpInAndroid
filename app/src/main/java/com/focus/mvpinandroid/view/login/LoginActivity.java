package com.focus.mvpinandroid.view.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.focus.mvpinandroid.MvpApp;
import com.focus.mvpinandroid.R;
import com.focus.mvpinandroid.model.DataManager;
import com.focus.mvpinandroid.utils.CommonUtils;
import com.focus.mvpinandroid.view.base.BaseActivity;
import com.focus.mvpinandroid.view.main.MainActivity;

/**
 * Created by P Ramesh Kumar on 19-02-2018.
 */

public class LoginActivity extends BaseActivity implements LoginMvpView {

    private LoginPresenter loginPresenter;
    private EditText editTextEmail, editTextPassword;
    private Button button;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        DataManager dataManager = ((MvpApp) getApplicationContext()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager);

        loginPresenter.onAttach(this);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginButtonClick();
            }
        });


    }

    @Override
    public void openMainActivity() {
        startActivity(new Intent(MainActivity.getStartIntent(this)));
        finish();
    }

    @Override
    public void onLoginButtonClick() {
        String sEmailId =   editTextEmail.getText().toString().trim();
        String sPassword =   editTextPassword.getText().toString().trim();

        if (!CommonUtils.isEmailValid(sEmailId)){
            Toast.makeText(this, "Enter Correct EmailId", Toast.LENGTH_SHORT).show();
            return;
        }
        if (sPassword==null||sPassword.isEmpty()||sPassword.equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        loginPresenter.startLogin(sEmailId);
    }
}
