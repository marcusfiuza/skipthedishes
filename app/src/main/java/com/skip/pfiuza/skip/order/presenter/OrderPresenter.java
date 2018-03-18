package com.skip.pfiuza.skip.order.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.api.SkipProviderAPI;
import com.skip.pfiuza.skip.base.api.SkipService;
import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.base.models.OrderRequest;
import com.skip.pfiuza.skip.base.models.Product;
import com.skip.pfiuza.skip.product.presenter.ProdcutContract;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class OrderPresenter implements OrderContract.Presenter {

    protected OrderContract.View view;

    final SkipService api;

    public OrderPresenter(OrderContract.View view) {
        this.api = SkipProviderAPI.provideAndCreate();
        this.view = view;
    }


    @Override
    public void getOrders() {
        SharedPreferences sharedPref = ((Context) view).getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String token = sharedPref.getString(((Context) view).getString(R.string.token), null);
        api.getOrders("Bearer " + token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Order>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Order> orderList) {
                        view.onGetOrders(true, orderList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetOrders(false, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
