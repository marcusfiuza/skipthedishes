package com.skip.pfiuza.skip.store.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skip.pfiuza.skip.MainActivity;
import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.models.Store;
import com.skip.pfiuza.skip.product.view.ProductActivity;
import com.skip.pfiuza.skip.store.Presenter.StoreContract;
import com.skip.pfiuza.skip.store.Presenter.StorePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class StoreFragment extends Fragment implements StoreContract.View, StoreAdapter.StoreItemAdapterInterface {

    @BindView(R.id.stores)
    RecyclerView store;

    StorePresenter storePresenter;

    StoreAdapter storeAdapter;
    List<Store> storeList;

    public StoreFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.store_fragment, container, false);
        ButterKnife.bind(this, v);
        storePresenter = new StorePresenter(this, getContext());

        storeList = new ArrayList<>();
        storeAdapter = new StoreAdapter(getContext(), storeList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        store.setLayoutManager(mLayoutManager);
        store.setItemAnimator(new DefaultItemAnimator());
        store.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
        store.setAdapter(storeAdapter);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        storePresenter.getStores();
    }

    @Override
    public void onGetStoresResponse(boolean success, List<Store> result) {
        storeList.addAll(result);
        storeAdapter.notifyDataSetChanged();
    }

    @Override
    public void openStore(Store item) {
        Intent intent = new Intent(getContext(), ProductActivity.class);
        intent.putExtra(ProductActivity.KEY_STORE_ID, item.getId());
        startActivity(intent);
    }
}
