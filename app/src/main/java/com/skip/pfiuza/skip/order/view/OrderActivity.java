package com.skip.pfiuza.skip.order.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.order.presenter.OrderContract;
import com.skip.pfiuza.skip.order.presenter.OrderPresenter;
import com.skip.pfiuza.skip.product.view.ProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class OrderActivity extends AppCompatActivity implements OrderContract.View {


    @BindView(R.id.orders)
    RecyclerView orders;

    OrderPresenter orderPresenter;
    private ArrayList<Order> ordersList;
    private OrderAdapter orderAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        orderPresenter = new OrderPresenter(this);

        ordersList = new ArrayList<>();

        orderAdapter = new OrderAdapter(ordersList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        orders.setLayoutManager(mLayoutManager);
        orders.setItemAnimator(new DefaultItemAnimator());
        orders.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        orders.setAdapter(orderAdapter);


        orderPresenter.getOrders();
    }

    @Override
    public void onGetOrders(boolean success, List<Order> orderList) {
        ordersList.addAll(orderList);
        orderAdapter.notifyDataSetChanged();

    }
}
