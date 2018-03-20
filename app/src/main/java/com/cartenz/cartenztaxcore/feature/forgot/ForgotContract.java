package com.cartenz.cartenztaxcore.feature.forgot;


import com.cartenz.core.base.BasePresenter;
import com.cartenz.core.base.BaseView;

public interface ForgotContract {
    interface View extends BaseView<PresenterInterface> {
        void forgotResult(String error);

    }

    interface PresenterInterface extends BasePresenter<View> {
        void callForgot(String email);
    }
}
