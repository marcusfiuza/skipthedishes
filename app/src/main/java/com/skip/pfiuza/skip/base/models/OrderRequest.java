package com.skip.pfiuza.skip.base.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.annotations.Nullable;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class OrderRequest {

    @SerializedName("deliveryAddress")
    private String deliveryAddress;
    @SerializedName("contact")
    private String contact;
    @SerializedName("storeId")
    private int storeId;
    @SerializedName("orderItems")
    private List<OrderItem> orderItems;
    @SerializedName("status")
    private String status;


    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


