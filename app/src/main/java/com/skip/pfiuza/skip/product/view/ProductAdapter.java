package com.skip.pfiuza.skip.product.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.skip.pfiuza.skip.R;
import com.skip.pfiuza.skip.base.models.Product;
import com.skip.pfiuza.skip.base.models.Store;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context context;
    private List<Product> productList;

    private OrderItemContract orderItemContract;


    public ProductAdapter(Context context, List<Product> products, OrderItemContract orderItemContract) {
        this.context = context;
        productList = products;
        this.orderItemContract = orderItemContract;
    }


    public interface OrderItemContract {
        void addToOrder(Product p);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        Product product;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.price)
        TextView price;

        @BindView(R.id.btn_add)
        Button add;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }



        @OnClick(R.id.btn_add)
        public void addItem(){
            orderItemContract.addToOrder(product);
        }



    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Product item = productList.get(position);
        holder.product = item;
        holder.name.setText(item.getName());
        holder.price.setText(Double.toString(item.getPrice()));

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
