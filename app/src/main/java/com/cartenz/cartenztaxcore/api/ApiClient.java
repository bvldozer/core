package com.cartenz.cartenztaxcore.api;

/**
 * Created by pratama on 2/13/2018.
 */

public class ApiClient extends com.cartenz.core.api.ApiClient {

    public ApiClient(String baseUrl) {
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
