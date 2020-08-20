package com.nycapp.nycaid.Network;

import com.nycapp.nycaid.Model.FoodGrabWrapper;
import com.nycapp.nycaid.Model.TestSitesWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NycAidAPI {

    String foodGrabEndPoint= "rosannaNaomy/covidNYCFiles/master/grabandgolocations";
    String testSiteEndPoint= "rosannaNaomy/covidNYCFiles/master/testsite";

    @GET(foodGrabEndPoint)
    Observable<FoodGrabWrapper> getGnGSites();

    @GET(testSiteEndPoint)
    Observable<TestSitesWrapper> getTestSites();
}

