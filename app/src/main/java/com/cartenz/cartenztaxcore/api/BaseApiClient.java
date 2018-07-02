package com.cartenz.cartenztaxcore.api;

/**
 * Created by pratama on 2/13/2018.
 */

public class BaseApiClient extends com.cartenz.core.api.BaseApiClient {

    public BaseApiClient(String baseUrl) {
        super(baseUrl, 5, 5, true);
    }

    @Override
    protected Class setInterfaceClass() {
        return ApiInterface.class;
    }

    public ApiInterface getInterfaceClass() {
        return (ApiInterface) getInterface();
    }


}
