package com.cartenz.core.api;


public class BaseRequest {
    protected BaseApiClient mBaseApiClient;

    public BaseRequest(BaseApiClient baseApiClient) {
        mBaseApiClient = baseApiClient;
    }

}
