package com.glovec.gcedit.ui.login;

import com.glovec.gcedit.bean.User;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View LoginView){
        this.mLoginView=LoginView;
        this.mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void UserLogin(User user) {
        if(user.getUsername().equals("zhangsan")&&user.getUserpassword().equals("123456")){
            mLoginView.showLoginSuccess();
        }else {
            mLoginView.showLoginError();
        }
    }
}
