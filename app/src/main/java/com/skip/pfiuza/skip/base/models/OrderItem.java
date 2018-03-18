package com.skip.pfiuza.skip.base.models;

import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.Nullable;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class OrderItem {

    @SerializedName("id")
    @Nullable
    private int id;

    @SerializedName("orderId")
    @Nullable
    private int orderId;

    @SerializedName("productId")
    private int productId;

    @SerializedName("product")
    @Nullable
    private Product product;

    @SerializedName("price")
    @Nullable
    private double price;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("total")
    @Nullable
    private double total;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
