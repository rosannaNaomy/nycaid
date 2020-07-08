package com.nycapp.nycaid.model;

import com.google.gson.annotations.SerializedName;

public class FoodGrab {

    @SerializedName("Borough")
    private String borough;
    @SerializedName("Name")
    private String name;
    @SerializedName("Address")
    private String address;
    private String state;
    private String zip;

    public String getBorough() {
        return borough;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }
}
