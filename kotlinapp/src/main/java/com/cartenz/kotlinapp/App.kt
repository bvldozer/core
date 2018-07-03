package com.cartenz.kotlinapp

import com.cartenz.cartenz.CartenzApp
import com.cartenz.kotlinapp.api.ApiInterface
import com.cartenz.kotlinapp.feature.utils.ApiConstant

class App : CartenzApp() {

    override fun initBaseCreate() {

    }

    override fun setApiInterface(): Class<*> {
        return ApiInterface::class.java
    }

    override fun setBaseUrl(): String {
        return ApiConstant.BASEURL
    }

    override fun isDebug(): Boolean {
        return true
    }

    companion object {
        fun getApiInterface(): ApiInterface {
            return CartenzApp.getApi() as ApiInterface
        }
    }

}
