package com.cartenz.core.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

public abstract class BaseActivity extends AppCompatActivity {


    public Gson gson = new Gson();
    private Intent intentData;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public Intent getIntentData() {
        return intentData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeCreateContent();
        int layoutResID = getLayoutId();
        super.setContentView(layoutResID);
        intentData = this.getIntent();
        initBaseCreate();
    }

    public void setToolbar(String title) {
        setTitle(title);
        invalidateOptionsMenu();
    }

    protected abstract int getLayoutId();

    protected abstract void initBeforeCreateContent();

    protected abstract void initBaseCreate();

    protected abstract void initDestroy();

    @Override
    public void onDestroy() {
        super.onDestroy();
        initDestroy();
    }


}
