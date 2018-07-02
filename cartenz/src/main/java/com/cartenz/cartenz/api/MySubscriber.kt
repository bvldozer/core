package com.cartenz.kotlin_core.api

import android.text.TextUtils
import com.cartenz.cartenz.Dictionary
import com.google.gson.Gson
import rx.Subscriber
import java.util.*

abstract class MySubscriber<T> : Subscriber<T>() {

    override fun onCompleted() {
        onComplete()
    }

    override fun onError(e: Throwable) {
        onError(e.message!!, "")
        onComplete()
    }

    override fun onNext(t: T) {
        val gson = Gson()
        val json = gson.toJson(t)
        val baseApiDao = gson.fromJson(json, BaseApiDao::class.java)
        var message: String? = null

        if (!TextUtils.isEmpty(baseApiDao.message)) {
            message = baseApiDao.message
        }

        var errorMessage: String? = null
        if (baseApiDao.errors != null) {
            val baseErrorDaoList = baseApiDao.errors
            val error = ArrayList<String>()
            for (i in baseErrorDaoList?.indices!!) {
                error.add(baseErrorDaoList?.get(i).itemCode.toString() + "")
            }
            errorMessage = Dictionary.getValueByKey(error)
        }
        if (!TextUtils.isEmpty(message) || !TextUtils.isEmpty(errorMessage) || baseApiDao.data == null || baseApiDao.errors != null && baseApiDao.errors!!.size > 0) {
            if (TextUtils.isEmpty(message)) {
                message = ""
            }
            if (TextUtils.isEmpty(errorMessage)) {
                errorMessage = ""
            }
            onError(message, errorMessage)
        } else {
            onSuccess(t)
        }

        onComplete()
    }

    abstract fun onError(message: String?, errorMessage: String?)

    abstract fun onSuccess(t: T)

    abstract fun onComplete()


}