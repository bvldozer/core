package com.cartenz.kotlinapp.feature.forgot

import com.cartenz.kotlin_core.CartenzBasePresenter
import com.cartenz.kotlin_core.CartenzBaseView

interface ForgotContract {
    interface ViewCartenz : CartenzBaseView<PresenterInterfaceCartenz> {
        fun forgotResult(error: String)

    }

    interface PresenterInterfaceCartenz : CartenzBasePresenter<ViewCartenz> {
        fun callForgot(email: String)
    }
}
