package com.skip.pfiuza.skip.login.presenter;

import com.skip.pfiuza.skip.base.models.Customer;

/**
 * Created by PFiuza on 18/03/2018.
 */

public interface LoginContract {
    interface Presenter {
        void attemptLogin(Customer customer);
    }

    interface View {
        void onLoginResponse(boolean success, String string);
    }
}
