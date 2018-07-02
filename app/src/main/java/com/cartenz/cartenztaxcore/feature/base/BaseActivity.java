package com.cartenz.cartenztaxcore.feature.base;

import android.os.Build;
import android.support.v7.widget.Toolbar;

import com.cartenz.helper.CheckPermission;
import com.google.gson.Gson;

import java.util.Arrays;

import butterknife.ButterKnife;

public abstract class BaseActivity extends com.cartenz.core.BaseActivity {

    public Toolbar toolbar;

    public Gson gson = new Gson();

    @Override
    public void initBeforeCreateContent() {

    }

    @Override
    public void initBaseCreate() {
        ButterKnife.bind(this);

        int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            callPermission();
        }
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_24dp);
//
//            if (getLayoutId() == R.layout.login_activity || getLayoutId() == R.layout.main_activity) {
//                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//                getSupportActionBar().setHomeButtonEnabled(false);
//            }
//
//        }
        initCreate();
    }

    public void setToolbar(String title) {
        setTitle(title);
        invalidateOptionsMenu();
    }


    public void callPermission() {
        CheckPermission checkPermission = new CheckPermission(this);
        String[] request = new String[]{CheckPermission.CAMERA, CheckPermission.NETWORK, CheckPermission.READ_EXTERNAL_STORAGE, CheckPermission.READ_PHONE_STORAGE, CheckPermission.WRITE_EXTERNAL_STORAGE};
        checkPermission.check(Arrays.asList(request));
    }

    protected abstract void initCreate();


}
