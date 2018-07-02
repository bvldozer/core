package com.cartenz.cartenztaxcore.feature.forgot;


import com.cartenz.core.BasePresenter;
import com.cartenz.core.BaseView;

public interface ForgotContract {
    interface View extends BaseView<PresenterInterface> {
        void forgotResult(String error);

    }

    interface PresenterInterface extends BasePresenter<View> {
        void callForgot(String email);
    }
}
