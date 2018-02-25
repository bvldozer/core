package com.cartenz.core.api;


public class BaseRequest {
    protected ApiClient mApiClient;

    public BaseRequest(ApiClient apiClient) {
        mApiClient = apiClient;
    }

}
