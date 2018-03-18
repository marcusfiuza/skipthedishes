package com.skip.pfiuza.skip.store.Presenter;

import com.skip.pfiuza.skip.base.models.Customer;
import com.skip.pfiuza.skip.base.models.Store;

import java.util.List;

/**
 * Created by PFiuza on 18/03/2018.
 */

public interface StoreContract {
    interface Presenter {
        void getStores();
    }

    interface View {
        void onGetStoresResponse(boolean success, List<Store> storesList);
    }
}
