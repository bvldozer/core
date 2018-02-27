package com.cartenz.core.api;

import android.text.TextUtils;

import com.cartenz.core.utils.Dictionary;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public abstract class MySubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
        onComplete();
    }

    @Override
    public void onError(Throwable e) {
        onError(e.getMessage(), "");
        onComplete();
    }

    @Override
    public void onNext(T t) {

        Gson gson = new Gson();
        String json = gson.toJson(t);
        BaseApiDao baseApiDao = gson.fromJson(json, BaseApiDao.class);
        String message = null;

        if (!TextUtils.isEmpty(baseApiDao.message)) {
            message = baseApiDao.message;
        }

        String errorMessage = null;
        if (baseApiDao.errors != null) {
            List<BaseApiDao.Errors> baseErrorDaoList = baseApiDao.errors;
            List<String> error = new ArrayList<>();
            for (int i = 0; i < baseErrorDaoList.size(); i++) {
                error.add(baseErrorDaoList.get(i).itemCode + "");
            }
            errorMessage = Dictionary.getValueByKey(error);
        }

        if (TextUtils.isEmpty(message) && TextUtils.isEmpty(errorMessage)) {
            onSuccess(t);
        } else {
            if (TextUtils.isEmpty(message)) {
                message = "";
            }
            if (TextUtils.isEmpty(errorMessage)) {
                errorMessage = "";
            }
            onError(message, errorMessage);
        }

        onComplete();
    }

    public abstract void onError(String message, String ErrorMessage);

    public abstract void onSuccess(T t);

    public abstract void onComplete();
}
