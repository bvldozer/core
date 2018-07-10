package com.cartenz.kotlin_core

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

abstract class CartenzBaseActivity : AppCompatActivity() {

    lateinit var intentData: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBeforeCreateContent()
        setContentView(getLayoutId())
        intentData = this.getIntent();
        initBaseCreate()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish();
        return super.onOptionsItemSelected(item)
    }

    open fun setToolbar(title: String) {
        setTitle(title)
        invalidateOptionsMenu()
    }


    protected abstract fun initBeforeCreateContent()

    protected abstract fun getLayoutId(): Int

    protected abstract fun initBaseCreate()

    protected abstract fun initDestroy()

    override fun onDestroy() {
        super.onDestroy()
        initDestroy()
    }


}