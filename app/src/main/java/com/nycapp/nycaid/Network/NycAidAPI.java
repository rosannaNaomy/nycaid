package com.nycapp.nycaid.Network;

import com.nycapp.nycaid.model.FoodGrab;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NycAidAPI {

    String foodGrabEndPoint= "rosannaNaomy/covidNYCFiles/master/grabandgolocations";

    @GET(foodGrabEndPoint)
    Observable<List<FoodGrab>> getGnGSites();

}

