package com.cartenz.kotlin_core

import android.content.Context

interface CartenzBasePresenter<T> {

    fun setView(context: Context, view: T)

    fun dropView()

}