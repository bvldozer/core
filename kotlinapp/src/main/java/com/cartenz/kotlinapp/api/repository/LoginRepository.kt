package com.cartenz.kotlinapp.api.repository

import com.cartenz.kotlinapp.App
import com.cartenz.kotlinapp.api.dao.LoginDao
import com.google.gson.JsonObject
import okhttp3.MediaType
import okhttp3.RequestBody
import rx.Observable

class LoginRepository(private val username: String, private val password: String) {

    fun post(): Observable<LoginDao> {
        val jsonObject = JsonObject()
        jsonObject.addProperty("99010101", 2)
        jsonObject.addProperty("99020302", username)
        jsonObject.addProperty("99020402", password)
        return App.getApiInterface().login(RequestBody.create(MediaType.parse("application/json"), jsonObject.toString()))
    }

}
