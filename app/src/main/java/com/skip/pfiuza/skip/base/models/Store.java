package com.skip.pfiuza.skip.base.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PFiuza on 18/03/2018.
 */

public class Store {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private String address;

    @SerializedName("cousineId")
    private int cousineId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCousineId() {
        return cousineId;
    }

    public void setCousineId(int cousineId) {
        this.cousineId = cousineId;
    }
}
