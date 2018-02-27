package com.cartenz.cartenztaxcore.feature.base;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends com.cartenz.core.base.BaseFragment {
    private Unbinder unbinder;

    @Override
    public void initBaseCreateView() {
        unbinder = ButterKnife.bind(this, view);
        initCreateView();
    }

    protected abstract void initCreateView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
