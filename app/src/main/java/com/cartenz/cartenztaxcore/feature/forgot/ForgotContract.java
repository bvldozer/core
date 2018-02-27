package com.cartenz.cartenztaxcore.feature.forgot;


import com.cartenz.core.base.BasePresenter;
import com.cartenz.core.base.BaseView;

public interface ForgotContract {
    interface View extends BaseView<Presenter> {
        void forgotResult(String error);

    }

    interface Presenter extends BasePresenter<View> {
        void callForgot(String email);
    }
}
