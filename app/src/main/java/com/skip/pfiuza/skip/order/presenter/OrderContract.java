package com.skip.pfiuza.skip.order.presenter;

import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.base.models.OrderRequest;
import com.skip.pfiuza.skip.base.models.Product;

import java.util.List;

/**
 * Created by PFiuza on 18/03/2018.
 */

public interface OrderContract {
    interface Presenter {
        void getOrders();
    }

    interface View {
        void onGetOrders(boolean success, List<Order> orderList);
    }
}
