package com.skip.pfiuza.skip.base.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.reactivex.annotations.Nullable;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class Order {


    @SerializedName("id")
    @Nullable
    private int id;
    @SerializedName("date")
    @Nullable
    private String date;
    @SerializedName("customerId")
    @Nullable
    private int customerId;
    @SerializedName("deliveryAddress")
    private String deliveryAddress;
    @SerializedName("contact")
    private String contact;
    @SerializedName("storeId")
    private int storeId;
    @SerializedName("orderItems")
    private List<OrderItem> orderItems;
    @SerializedName("total")
    @Nullable
    private double total;
    @SerializedName("status")
    private String status;
    @SerializedName("lastUpdate")
    @Nullable
    private String lastUpdate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public java.lang.String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(java.lang.String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public java.lang.String getContact() {
        return contact;
    }

    public void setContact(java.lang.String contact) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.lang.String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
