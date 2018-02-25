package com.cartenz.core.api;

import android.text.TextUtils;

import rx.Subscriber;

public abstract class MySubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
        onComplete();
    }

    @Override
    public void onError(Throwable e) {
        onError(e.getMessage());
        onComplete();
    }

    @Override
    public void onNext(T t) {
        BaseApiDao baseApiDao = (BaseApiDao) t;
        if (!TextUtils.isEmpty(baseApiDao.getMessage())) {
            onError(baseApiDao.getMessage());
        } else {
            onSuccess(t);
        }
        onComplete();
    }

    public abstract void onError(String errorMessage);

    public abstract void onSuccess(T t);

    public abstract void onComplete();
}
