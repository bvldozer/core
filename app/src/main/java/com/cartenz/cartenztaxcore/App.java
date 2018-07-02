package com.cartenz.cartenztaxcore;

import android.support.annotation.NonNull;

import com.cartenz.cartenz.CartenzApp;
import com.cartenz.cartenztaxcore.api.ApiInterface;
import com.cartenz.cartenztaxcore.feature.utils.ApiConstant;

import org.jetbrains.annotations.NotNull;

public class App extends CartenzApp {

    @Override
    protected void initBaseCreate() {

    }

    @NonNull
    @Override
    protected Class<?> setApiInterface() {
        return ApiInterface.class;
    }

    @NotNull
    @Override
    protected String setBaseUrl() {
        return ApiConstant.BASEURL;
    }

    @Override
    protected boolean isDebug() {
        return true;
    }

    public static ApiInterface getApiInterface() {
        return (ApiInterface) App.Companion.getApi();
    }



}
