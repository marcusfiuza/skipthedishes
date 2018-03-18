package com.skip.pfiuza.skip.store.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.api.SkipProviderAPI;
import com.skip.pfiuza.skip.base.api.SkipService;
import com.skip.pfiuza.skip.base.models.Store;
import com.skip.pfiuza.skip.signup.presenter.SignUpContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class StorePresenter implements StoreContract.Presenter {

    protected StoreContract.View view;

    protected Context context;

    final SkipService api;

    public StorePresenter(StoreContract.View view,Context context) {
        this.api = SkipProviderAPI.provideAndCreate();
        this.view = view;
        this.context = context;

    }

    @Override
    public void getStores() {
        SharedPreferences sharedPref = context.getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String token = sharedPref.getString(context.getString(R.string.token), null);
        api.getStores("Bearer " + token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Store>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Store> stores) {
                        view.onGetStoresResponse(true, stores);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetStoresResponse(true, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
