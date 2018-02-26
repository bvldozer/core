package com.cartenz.core.api;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiClient<T> {
    T mApiInterface;

    public ApiClient(String baseUrl, long readTimeOut, long connectTimeOut, boolean debug) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(readTimeOut, TimeUnit.SECONDS)
                .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
                .addInterceptor(new MyInterceptor());
        if (debug) {
            builder.addInterceptor(interceptor); //  todo for debug
        }
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(baseUrl)
                .build();
        mApiInterface = retrofit.create((Class<T>) setInterfaceClass());
    }

    private class MyInterceptor implements Interceptor {

        public MyInterceptor() {

        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            Request.Builder reqBuilder = original.newBuilder().header("Content-Type", "application/json");
            Request request = reqBuilder.build();

            Response response = chain.proceed(request);
            String rawJson = response.body().string();
            if (!response.isSuccessful() || rawJson.contains("\"success\":false") && !rawJson.equals("\"errors\": null")) {
                BaseApiDao errorApiDao = new Gson().fromJson(rawJson, BaseApiDao.class);
                String errorMessage = errorApiDao.getMessage();
                if (errorMessage == null) {
                    errorMessage = rawJson;
                }
                return response.newBuilder().body(ResponseBody.create(response.body().contentType(), rawJson)).message(errorMessage).build();
            } else {
                return response.newBuilder().body(ResponseBody.create(response.body().contentType(), rawJson)).build();
            }
        }
    }

    protected abstract T setInterfaceClass();

    public T getInterface() {
        return mApiInterface;
    }
}
