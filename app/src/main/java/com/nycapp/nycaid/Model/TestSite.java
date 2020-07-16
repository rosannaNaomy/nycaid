package com.nycapp.nycaid.Model;

import com.google.gson.annotations.SerializedName;

public class TestSite {

    @SerializedName("Borough")
    private String borough;
    @SerializedName("Name")
    private String name;
    @SerializedName("Address")
    private String address;
    private String state;
    private String zip;
    private String phone;

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

    public String getPhone() { return phone; }
}
