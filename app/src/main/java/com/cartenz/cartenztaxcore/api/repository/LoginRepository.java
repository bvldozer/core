package com.cartenz.cartenztaxcore.api.repository;

import com.cartenz.cartenztaxcore.api.ApiClient;
import com.cartenz.cartenztaxcore.api.dao.LoginDao;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by pratama on 2/22/2018.
 */

public class LoginRepository {
    private String username;
    private String password;
    private ApiClient apiClient;

    public LoginRepository(ApiClient apiClient, String username, String password) {
        this.apiClient = apiClient;
        this.username = username;
        this.password = password;
    }

    public Observable<LoginDao> post() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("99010101", 2);
        jsonObject.addProperty("99020302", username);
        jsonObject.addProperty("99020402", password);
        return apiClient.getInterfaceClass().login(RequestBody.create(MediaType.parse("application/json"), jsonObject.toString()));
    }


}
