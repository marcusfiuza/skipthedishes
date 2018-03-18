package com.skip.pfiuza.skip.base.api;

import com.skip.pfiuza.skip.base.models.Customer;
import com.skip.pfiuza.skip.base.models.Order;
import com.skip.pfiuza.skip.base.models.OrderRequest;
import com.skip.pfiuza.skip.base.models.Product;
import com.skip.pfiuza.skip.base.models.Store;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by PFiuza on 18/03/2018.
 */

public interface SkipService {
    @POST("v1/Customer/auth")
    Observable<String> authUser(@Query("email") String email, @Query("password") String password);

    @POST("v1/Customer")
    Observable<String> signUp(@Body Customer costumer);


    @GET("v1/Store")
    Observable<List<Store>> getStores(@Header("Authorization") String authHeader);


    @GET("v1/Store/{id}/products")
    Observable<List<Product>> getStoreProducts(@Header("Authorization") String authHeader, @Path("id") int id);

    @POST("v1/Order")
    Observable<Order> createOrder(@Header("Authorization") String authHeader, @Body OrderRequest order);

    @GET("v1/Order/customer")
    Observable<List<Order>> getOrders(@Header("Authorization") String authHeader);

}
