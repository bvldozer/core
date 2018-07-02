package com.cartenz.cartenztaxcore.feature.login;


import com.cartenz.core.BasePresenter;
import com.cartenz.core.BaseView;

public interface LoginContract {
    interface View extends BaseView<PresenterInterface> {
        void loginResult(String error);

    }

    interface PresenterInterface extends BasePresenter<View> {

        void callLogin(String username, String password);
    }
}
