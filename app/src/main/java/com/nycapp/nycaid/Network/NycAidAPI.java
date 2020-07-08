package com.nycapp.nycaid.Network;

import android.database.Observable;

import com.nycapp.nycaid.model.FoodGrab;

import java.util.List;

import retrofit2.http.GET;

public interface NycAidAPI {

    String foodGrabEndPoint= "grabandgolocations?token=AKSENFFO4CJ4OQK7K4QMRUC7AUSRE";

    @GET(foodGrabEndPoint)
    Observable<List<FoodGrab>> getGnGSites();

}

