package com.skip.pfiuza.skip.signup.presenter;

import com.skip.pfiuza.skip.base.api.SkipProviderAPI;
import com.skip.pfiuza.skip.base.api.SkipService;
import com.skip.pfiuza.skip.base.models.Customer;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by PFiuza on 18/03/2018.
 */

public class SignUpPresenter implements SignUpContract.Presenter {

    protected SignUpContract.View view;

    final SkipService api;

    public SignUpPresenter(SignUpContract.View view) {
        this.api = SkipProviderAPI.provideAndCreate();
        this.view = view;
    }


    @Override
    public void signUp(Customer customer) {
        api.signUp(customer).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        view.onSignUpResponse(true, s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onSignUpResponse(false, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
