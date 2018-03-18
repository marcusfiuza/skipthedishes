package com.skip.pfiuza.skip.store.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.models.Product;
import com.skip.pfiuza.skip.base.models.Store;
import com.skip.pfiuza.skip.product.view.ProductActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    private Context context;
    private List<Store> storeList;
    private StoreItemAdapterInterface view;


    public StoreAdapter(Context context, List<Store> stores, StoreItemAdapterInterface storeItemAdapterInterface) {
        this.context = context;
        storeList = stores;
        view = storeItemAdapterInterface;
    }


    public interface StoreItemAdapterInterface {
        void openStore(Store item);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        Store store;


        @BindView(R.id.address)
        TextView address;

        @BindView(R.id.name)
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.view_foreground)
        public void listProducts() {
            view.openStore(store);
        }

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Store item = storeList.get(position);
        holder.store = item;
        holder.name.setText(item.getName());
        holder.address.setText(item.getAddress());

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }
}
