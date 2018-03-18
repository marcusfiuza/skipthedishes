package com.skip.pfiuza.skip.product.view;

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
import com.skip.pfiuza.skip.base.models.OrderItem;
import com.skip.pfiuza.skip.base.models.OrderRequest;
import com.skip.pfiuza.skip.base.models.Product;
import com.skip.pfiuza.skip.product.presenter.ProdcutContract;
import com.skip.pfiuza.skip.product.presenter.ProductPresenter;
import com.skip.pfiuza.skip.store.view.StoreAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class ProductActivity extends AppCompatActivity implements ProdcutContract.View, ProductAdapter.OrderItemContract {

    public final static String KEY_STORE_ID = "StoreID";

    OrderRequest order;

    HashMap<Integer, OrderItem> orderProductList;

    @BindView(R.id.products)
    RecyclerView products;

    @BindView(R.id.total)
    TextView total;

    double totalValue;

    ProductPresenter productPresenter;
    List<Product> productList;

    ProductAdapter productAdapter;

    int storeId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);

        storeId = getIntent().getIntExtra(KEY_STORE_ID, 0);

        productPresenter = new ProductPresenter(this);

        productList = new ArrayList<>();

        orderProductList = new HashMap<>();

        productAdapter = new ProductAdapter(this, productList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        products.setLayoutManager(mLayoutManager);
        products.setItemAnimator(new DefaultItemAnimator());
        products.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        products.setAdapter(productAdapter);
        productPresenter.getProducts(storeId);

    }

    @Override
    public void onGetProductsResponse(boolean success, List<Product> result) {
        productList.addAll(result);
        productAdapter.notifyDataSetChanged();
    }

    @Override
    public void addToOrder(Product p) {

        if (orderProductList.get(p.getId()) == null) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(p.getId());
            orderItem.setQuantity(1);
            orderProductList.put(p.getId(), orderItem);
        } else {
            orderProductList.get(p.getId()).setQuantity(orderProductList.get(p.getId()).getQuantity() + 1);
        }
        totalValue += p.getPrice();
        total.setText(String.format("%.2f", totalValue));

    }


    @OnClick(R.id.btn_order)
    public void order() {
        order = new OrderRequest();
        order.setContact("teste");
        order.setDeliveryAddress("teste");
        order.setStoreId(storeId);
        List<OrderItem> items = new ArrayList<>();
        items.addAll(orderProductList.values());
        order.setOrderItems(items);
        order.setStatus("WAITING");
        productPresenter.createOrder(order);
    }

    @Override
    public void onCreateOrder(boolean success) {
        finish();
    }

}
