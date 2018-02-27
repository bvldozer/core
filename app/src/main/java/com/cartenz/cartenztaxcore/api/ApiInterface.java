package com.cartenz.cartenztaxcore.api;


import com.cartenz.cartenztaxcore.api.dao.LoginDao;
import com.cartenz.cartenztaxcore.api.dao.SimpleStringDao;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface ApiInterface {

    //post
    @POST("login")
    Observable<LoginDao> login(
            @Body RequestBody body
    );

    @POST("forgot")
    Observable<SimpleStringDao> forgotpass(
            @Body RequestBody body
    );


}
