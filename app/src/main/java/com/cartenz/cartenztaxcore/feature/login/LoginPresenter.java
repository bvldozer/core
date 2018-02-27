

package com.cartenz.cartenztaxcore.feature.login;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cartenz.cartenztaxcore.App;
import com.cartenz.cartenztaxcore.api.dao.LoginDao;
import com.cartenz.cartenztaxcore.api.repository.LoginRepository;
import com.cartenz.core.api.MySubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

final class LoginPresenter implements LoginContract.Presenter {


    @Nullable
    private LoginContract.View mLoginView;
    private Context context;


    @Override
    public void setView(Context context, LoginContract.View view) {
        this.context = context;
        this.mLoginView = view;

    }


    @Override
    public void callLogin(String username, String password) {
        LoginRepository repo = new LoginRepository(App.getApi(), username, password);
        repo.post().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<LoginDao>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(String message, String errorMessage) {
                        Log.wtf("Test_okhttp", message + " " + errorMessage);
                        mLoginView.loginResult(errorMessage);
                    }

                    @Override
                    public void onSuccess(LoginDao loginDao) {
                        mLoginView.loginResult(null);
                    }

                });
    }

    @Override
    public void dropView() {
        mLoginView = null;
    }


}
