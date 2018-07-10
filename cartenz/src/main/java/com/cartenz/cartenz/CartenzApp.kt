package com.cartenz.cartenz

import android.app.Application
import com.cartenz.kotlin_core.api.BaseApiClient

abstract class CartenzApp : Application() {

    companion object {
        private lateinit var instance: CartenzApp
        fun setApi(interfaceClass: Class<*>, baseUrl: String, isDebug: Boolean): Any {
            return BaseApiClient.ApiClient(interfaceClass, baseUrl, 5, 5, isDebug)!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initBaseCreate()
    }


    protected abstract fun initBaseCreate()


}