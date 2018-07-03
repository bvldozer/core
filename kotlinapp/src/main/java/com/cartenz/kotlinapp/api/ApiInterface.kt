package com.cartenz.kotlinapp.api

import com.cartenz.kotlinapp.api.dao.LoginDao
import com.cartenz.kotlinapp.api.dao.SimpleStringDao
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface ApiInterface {

    //post
    @POST("login")
    fun login(
            @Body body: RequestBody
    ): Observable<LoginDao>

    @POST("forgot")
    fun forgotpass(
            @Body body: RequestBody
    ): Observable<SimpleStringDao>

}
