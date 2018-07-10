package com.cartenz.kotlinapp.feature.login

import com.cartenz.kotlin_core.CartenzBasePresenter
import com.cartenz.kotlin_core.CartenzBaseView

interface LoginContract {
    interface ViewCartenz : CartenzBaseView<PresenterInterfaceCartenz> {
        fun loginResult(error: String)
    }

    interface PresenterInterfaceCartenz : CartenzBasePresenter<ViewCartenz> {
        fun callLogin(username: String, password: String)
    }

}
