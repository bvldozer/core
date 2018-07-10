package com.cartenz.kotlinapp

import com.cartenz.cartenz.CartenzApp
import com.cartenz.kotlinapp.api.ApiInterface
import com.cartenz.kotlinapp.feature.utils.ApiConstant


class App : CartenzApp() {

    override fun initBaseCreate() {

    }


    companion object {
        fun getApiInterface(): ApiInterface {
            return setApi(ApiInterface::class.java, ApiConstant.BASEURL, true) as ApiInterface
        }
    }

}
