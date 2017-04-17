package com.glovec.gcedit.ui.login;

import com.glovec.gcedit.base.mvp.BasePresenter;
import com.glovec.gcedit.base.mvp.BaseView;
import com.glovec.gcedit.bean.User;

/**
 * Created by Administrator on 2017/4/15 0015.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showLoginError();
        void showLoginSuccess();
    }

    interface Presenter extends BasePresenter {
        void UserLogin(User user);
    }
}
