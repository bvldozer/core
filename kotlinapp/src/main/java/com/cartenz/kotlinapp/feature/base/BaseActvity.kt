package com.cartenz.kotlinapp.feature.base

import android.os.Build
import android.support.v7.widget.Toolbar
import com.cartenz.helper.CheckPermission
import com.google.gson.Gson
import java.util.*

abstract class BaseActvity : com.cartenz.kotlin_core.CartenzBaseActivity() {

    var toolbar: Toolbar? = null

    var gson = Gson()

    override fun initBeforeCreateContent() {

    }

    override fun initBaseCreate() {

        val MyVersion = Build.VERSION.SDK_INT
        if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
            callPermission()
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
        initCreate()
    }

    override fun setToolbar(title: String) {
        setTitle(title)
        invalidateOptionsMenu()
    }


    fun callPermission() {
        val checkPermission = CheckPermission(this)
        val request = arrayOf(CheckPermission.CAMERA, CheckPermission.NETWORK, CheckPermission.READ_EXTERNAL_STORAGE, CheckPermission.READ_PHONE_STORAGE, CheckPermission.WRITE_EXTERNAL_STORAGE)
        checkPermission.check(Arrays.asList(*request))
    }

    protected abstract fun initCreate()


}
