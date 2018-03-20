

package com.cartenz.cartenztaxcore.feature.forgot;

import android.content.Context;
import android.support.annotation.Nullable;

import com.cartenz.cartenztaxcore.App;
import com.cartenz.cartenztaxcore.api.dao.SimpleStringDao;
import com.cartenz.cartenztaxcore.api.repository.ForgotPassRepository;
import com.cartenz.core.api.MySubscriber;
import com.cartenz.core.base.BaseSubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

final class ForgotPresenter extends BaseSubscriber implements ForgotContract.PresenterInterface {


    @Nullable
    private ForgotContract.View mForgotView;
    private Context context;

    @Override
    public void setView(Context context, ForgotContract.View view) {
        this.context = context;
        this.mForgotView = view;

    }


    @Override
    public void callForgot(String email) {
        ForgotPassRepository repo = new ForgotPassRepository(App.getApi(), email);
        addSubscription(repo.post().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber<SimpleStringDao>() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(String message, String errorMessage) {
                        mForgotView.forgotResult(errorMessage);
                    }

                    @Override
                    public void onSuccess(SimpleStringDao string) {
                        mForgotView.forgotResult(null);
                    }

                }));

    }

    @Override
    public void dropView() {
        finishSubscriber();
        mForgotView = null;
    }

}
