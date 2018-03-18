package com.skip.pfiuza.skip.product.presenter;

import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.base.models.OrderRequest;
import com.skip.pfiuza.skip.base.models.Product;

import java.util.List;

/**
 * Created by PFiuza on 18/03/2018.
 */

public interface ProdcutContract {
    interface Presenter {
        void getProducts(int storeId);

        void createOrder(OrderRequest OrderRequest);
    }

    interface View {
        void onGetProductsResponse(boolean success, List<Product> productList);

        void onCreateOrder(boolean success);
    }
}
