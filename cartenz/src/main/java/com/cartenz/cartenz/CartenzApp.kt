package com.cartenz.cartenz

import android.app.Application
import com.cartenz.kotlin_core.api.BaseApiClient

abstract class CartenzApp : Application() {

    companion object {
        private lateinit var instance: CartenzApp
        lateinit var apiInterface: Any
        fun getApi(): Any {
            return apiInterface
        }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        setApi()
        initBaseCreate()
    }


    fun setApi() {
        apiInterface = BaseApiClient.ApiClient(setApiInterface(), setBaseUrl(), 5, 5, isDebug())!!
    }


    protected abstract fun setApiInterface(): Class<*>

    protected abstract fun setBaseUrl(): String

    protected abstract fun isDebug(): Boolean

    protected abstract fun initBaseCreate()


}