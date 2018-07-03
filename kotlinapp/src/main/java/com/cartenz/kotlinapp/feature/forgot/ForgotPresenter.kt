package com.cartenz.kotlinapp.feature.forgot

import android.content.Context
import com.cartenz.kotlin_core.BaseSubscriber
import com.cartenz.kotlin_core.api.MySubscriber
import com.cartenz.kotlinapp.api.dao.SimpleStringDao
import com.cartenz.kotlinapp.api.repository.ForgotPassRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

internal class ForgotPresenter : BaseSubscriber(), ForgotContract.PresenterInterface {

    private var mForgotView: ForgotContract.View? = null
    private var context: Context? = null

    override fun setView(context: Context, view: ForgotContract.View) {
        this.context = context
        this.mForgotView = view
    }

    override fun callForgot(email: String) {
        val repo = ForgotPassRepository(email)
        addSubscription(repo.post().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : MySubscriber<SimpleStringDao>() {
                    override fun onComplete() {

                    }

                    override fun onError(message: String?, errorMessage: String?) {
                        mForgotView!!.forgotResult(errorMessage!!)
                    }

                    override fun onSuccess(string: SimpleStringDao) {
                        mForgotView!!.forgotResult("")
                    }

                }))

    }

    override fun dropView() {
        finishSubscriber()
        mForgotView = null
    }

}
