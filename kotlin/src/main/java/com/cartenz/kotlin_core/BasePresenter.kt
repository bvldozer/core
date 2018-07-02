package com.cartenz.kotlin_core

import android.content.Context

interface BasePresenter<T> {

    fun setView(context: Context, view: T)

    fun dropView()

}