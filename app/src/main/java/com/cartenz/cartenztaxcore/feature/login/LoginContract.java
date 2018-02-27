package com.cartenz.cartenztaxcore.feature.login;


import com.cartenz.core.base.BasePresenter;
import com.cartenz.core.base.BaseView;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginResult(String error);

    }

    interface Presenter extends BasePresenter<View> {

        void callLogin(String username, String password);
    }
}
