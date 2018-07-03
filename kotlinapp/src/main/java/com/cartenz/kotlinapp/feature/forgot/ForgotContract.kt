package com.cartenz.kotlinapp.feature.forgot

import com.cartenz.kotlin_core.BasePresenter
import com.cartenz.kotlin_core.BaseView

interface ForgotContract {
    interface View : BaseView<PresenterInterface> {
        fun forgotResult(error: String)

    }

    interface PresenterInterface : BasePresenter<View> {
        fun callForgot(email: String)
    }
}
