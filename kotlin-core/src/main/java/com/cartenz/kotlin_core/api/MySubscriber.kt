package com.cartenz.kotlin_core.api

import android.util.Log
import rx.Subscriber

abstract class MySubscriber<T> : Subscriber<T>() {

    override fun onCompleted() {
        onComplete()
    }

    override fun onError(e: Throwable) {
        onError(e.message!!, "")
        onComplete()
    }

    override fun onNext(t: T) {
        onSuccess(t)
        onComplete()
    }

    abstract fun onError(message: String?, errorMessage: String?)

    abstract fun onSuccess(t: T)

    abstract fun onComplete()


}