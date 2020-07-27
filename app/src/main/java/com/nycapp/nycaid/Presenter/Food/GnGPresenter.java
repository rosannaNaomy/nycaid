package com.nycapp.nycaid.Presenter.Food;

import android.annotation.SuppressLint;

import com.nycapp.nycaid.DataSort;
import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;
import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.Model.FoodGrabWrapper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GnGPresenter implements Contract.GnGPresenter {

    private final Contract.GnGListView gngListView;
    private final NycAidAPI nycAidAPI;
    private List<FoodGrab> list;

    public GnGPresenter(Contract.GnGListView gngListView, NycAidAPI nycAidAPI) {
        this.gngListView = gngListView;
        this.nycAidAPI = nycAidAPI;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getGnGSitesCall() {
        NycAidRetrofit.getRetrofitInstance()
                .create(NycAidAPI.class)
                .getGnGSites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            list = new ArrayList<>(viewResponse(response));
                        },
                        throwable -> gngListView.showError());
    }

    @Override
    public void searchListByZip(String input) {
        List<FoodGrab> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getZip().toLowerCase().startsWith(input.toLowerCase())) {
                newList.add(list.get(i));
            }
        }
        DataSort.sortGNGListAlphabetically(newList);
        gngListView.showGnGSites(newList);
    }

    @Override
    public void searchListByBorough(Object input) {
        List<FoodGrab> newList = new ArrayList<>();
        if (input.toString().startsWith("NYC")) {
            DataSort.sortGNGListAlphabetically(list);
            gngListView.showGnGSites(list);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBorough().startsWith(input.toString())) {
                newList.add(list.get(i));
                DataSort.sortGNGListAlphabetically(newList);
                gngListView.showGnGSites(newList);
            }
        }
    }

    private List<FoodGrab> viewResponse(FoodGrabWrapper response) {
        final boolean success = !response.getFoodgrab().isEmpty();
        if (success) {
            DataSort.sortGNGListAlphabetically(response.getFoodgrab());
            gngListView.showGnGSites(response.getFoodgrab());
        } else {
            gngListView.showError();
        }
        return response.getFoodgrab();
    }

}
