package com.skip.pfiuza.skip.order.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.base.models.Product;
import com.skip.pfiuza.skip.product.view.ProductAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by PFiuza on 18/03/2018.
 */

class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<Order> orderList;


    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.delivrey)
        TextView delivrey;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.status)
        TextView status;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Order o = orderList.get(position);
        holder.delivrey.setText(o.getDeliveryAddress());
        holder.price.setText(String.format("%.2f", o.getTotal()));
        holder.status.setText(o.getStatus());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

}