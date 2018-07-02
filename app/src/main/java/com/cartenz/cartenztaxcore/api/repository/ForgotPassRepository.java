package com.cartenz.cartenztaxcore.api.repository;

import com.cartenz.cartenztaxcore.api.BaseApiClient;
import com.cartenz.cartenztaxcore.api.dao.SimpleStringDao;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by pratama on 2/22/2018.
 */

public class ForgotPassRepository {
    private String email;
    private BaseApiClient apiClient;

    public ForgotPassRepository(BaseApiClient apiClient, String email) {
        this.apiClient = apiClient;
        this.email = email;
    }

    public Observable<SimpleStringDao> post() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("93010006", email);
        return apiClient.getInterfaceClass().forgotpass(RequestBody.create(MediaType.parse("application/json"), jsonObject.toString()));
    }
}
