package com.skip.pfiuza.skip.signup.presenter;

import com.skip.pfiuza.skip.base.models.Customer;

/**
 * Created by PFiuza on 18/03/2018.
 */

public interface SignUpContract {
    interface Presenter {
        void signUp(Customer customer);
    }

    interface View {
        void onSignUpResponse(boolean success, String string);
    }
}
