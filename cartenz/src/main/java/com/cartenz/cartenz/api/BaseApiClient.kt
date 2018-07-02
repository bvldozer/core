package com.cartenz.kotlin_core.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.LongSerializationPolicy
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

abstract class BaseApiClient {

    //    lateinit var apiInterface: Class<*>
    companion object {
        fun ApiClient(interfaceClass: Class<*>, baseUrl: String, readTimeOut: Long, connectTimeOut: Long, debug: Boolean): Any? {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.HEADERS
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val builder = UnsafeOkhttpClient.getUnsafeOkHttpBuilder()
            builder.readTimeout(readTimeOut, TimeUnit.SECONDS)
            builder.connectTimeout(connectTimeOut, TimeUnit.SECONDS)
            builder.addInterceptor(MyInterceptor())
            if (debug) {
                builder.addInterceptor(interceptor)
            }
            val client = builder.build()

            val gson = GsonBuilder()
                    .setLongSerializationPolicy(LongSerializationPolicy.STRING)
                    .create()
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .baseUrl(baseUrl)
                    .build()
            return retrofit.create(interfaceClass)
        }

        private class MyInterceptor : Interceptor {

            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val reqBuilder = original.newBuilder().header("Content-Type", "application/json")
                val request = reqBuilder.build()

                val response = chain.proceed(request)
                var rawJson = response.body()!!.string()
                if (response.headers().get("cti-auth-token") != null) {
                    val parser = JsonParser()
                    val parent = parser.parse(rawJson).asJsonObject
                    val member = parent.getAsJsonObject("data")
                    member.addProperty("token", response.headers().get("cti-auth-token"))
                    val gson = Gson()
                    rawJson = gson.toJson(parent)
                }
                return response.newBuilder().body(ResponseBody.create(response.body()!!.contentType(), rawJson)).build()
            }
        }

    }


}