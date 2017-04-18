package com.glovec.gcedit.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.glovec.gcedit.R;
import com.glovec.gcedit.bean.User;
import com.glovec.gcedit.ui.base.BaseActivity;

/**
 * Created by everyone on 2017/4/12.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View{

    private LoginContract.Presenter mLoginPersenter;
    private EditText usernameTv;
    private EditText passwordTv;
    private Button LoginBtn;
    private Button RegisterBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginBtn= (Button) findViewById(R.id.login_btn);
        usernameTv= (EditText) findViewById(R.id.username);
        passwordTv= (EditText) findViewById(R.id.password);
        RegisterBtn= (Button) findViewById(R.id.register);
        mLoginPersenter=new LoginPresenter(this);
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user.setUsername(usernameTv.getText().toString().trim());
                user.setUserpassword(passwordTv.getText().toString().trim());
                mLoginPersenter.UserLogin(user);
            }
        });
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void showLoginError() {
        Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginSuccess() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mLoginPersenter=presenter;
    }
}