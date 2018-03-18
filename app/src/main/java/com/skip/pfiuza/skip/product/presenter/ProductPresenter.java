package com.skip.pfiuza.skip.product.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.api.SkipProviderAPI;
import com.skip.pfiuza.skip.base.api.SkipService;
import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.base.models.OrderRequest;
import com.skip.pfiuza.skip.base.models.Product;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class ProductPresenter implements ProdcutContract.Presenter {

    protected ProdcutContract.View view;

    final SkipService api;

    public ProductPresenter(ProdcutContract.View view) {
        this.api = SkipProviderAPI.provideAndCreate();
        this.view = view;
    }

    @Override
    public void getProducts(int storeId) {

        SharedPreferences sharedPref = ((Context) view).getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String token = sharedPref.getString(((Context) view).getString(R.string.token), null);
        api.getStoreProducts("Bearer " + token, storeId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Product>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Product> products) {
                        view.onGetProductsResponse(true, products);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onGetProductsResponse(false, null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void createOrder(OrderRequest order) {
        SharedPreferences sharedPref = ((Context) view).getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        String token = sharedPref.getString(((Context) view).getString(R.string.token), null);
        api.createOrder("Bearer " + token, order)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Order>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Order s) {
                        view.onCreateOrder(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onCreateOrder(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
