package com.cartenz.kotlin_core.base

import android.content.Context

interface BasePresenter<T> {

    fun setView(context: Context, view: T)

    fun dropView()

}