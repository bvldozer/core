package com.cartenz.kotlinapp.api.repository

import com.cartenz.kotlinapp.App
import com.cartenz.kotlinapp.api.dao.SimpleStringDao
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.RequestBody
import rx.Observable

class ForgotPassRepository(private val email: String) {

    fun post(): Observable<SimpleStringDao> {
        val jsonObject = JsonObject()
        jsonObject.addProperty("93010006", email)
        return App.getApiInterface().forgotpass(RequestBody.create(MediaType.parse("application/json"), jsonObject.toString()))
    }
}
