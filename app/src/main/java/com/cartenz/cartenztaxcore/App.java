package com.cartenz.cartenztaxcore;

import android.app.Application;

import com.cartenz.cartenztaxcore.api.BaseApiClient;
import com.cartenz.cartenztaxcore.feature.utils.ApiConstant;
import com.cartenz.core.utils.Dictionary;

public class App extends Application {

    private static App instance;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    public static BaseApiClient getApi() {
        return new BaseApiClient(ApiConstant.BASEURL);
    }

    public static App getInstance() {
        return instance;
    }


}
