package com.cartenz.kotlin_core


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


abstract class CartenzBaseFragment : Fragment() {


    protected lateinit var inflater: LayoutInflater
    var intentData: Bundle? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.inflater = inflater
        val view = inflater.inflate(this.getLayoutId(), container, false)
        this.intentData = this.arguments
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.initBaseCreateView()
    }

    protected abstract fun getLayoutId(): Int

    protected abstract fun initBaseCreateView()

    protected abstract fun initDestroy()

    override fun onDestroy() {
        super.onDestroy()
        initDestroy()
    }


}