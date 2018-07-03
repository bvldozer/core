package com.cartenz.kotlinapp.feature.base


abstract class BaseFragment : com.cartenz.kotlin_core.BaseFragment() {

    override fun initBaseCreateView() {
        initCreateView()
    }

    protected abstract fun initCreateView()

    override fun onDestroyView() {
        super.onDestroyView()
    }

}
