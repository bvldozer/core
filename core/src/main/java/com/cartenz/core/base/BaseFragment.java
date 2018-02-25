package com.cartenz.core.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    public View view;
    protected LayoutInflater inflater;
    private Bundle intentData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        view = inflater.inflate(getLayoutId(), container, false);
        intentData = getArguments();
        initBaseCreateView();

        return view;
    }

    protected abstract int getLayoutId();

    protected abstract void initBaseCreateView();


    protected abstract void initDestroy();


    public Bundle getIntentData() {
        return intentData;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        initDestroy();
    }


}
