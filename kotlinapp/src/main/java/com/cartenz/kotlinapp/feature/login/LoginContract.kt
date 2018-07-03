package com.cartenz.kotlinapp.feature.login

import com.cartenz.kotlin_core.BasePresenter
import com.cartenz.kotlin_core.BaseView

interface LoginContract {
    interface View : BaseView<PresenterInterface> {
        fun loginResult(error: String)
    }

    interface PresenterInterface : BasePresenter<View> {
        fun callLogin(username: String, password: String)
    }

}
