package com.nycapp.nycaid.Presenter.Food;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.appcompat.widget.SearchView;

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

    public GnGPresenter(Contract.GnGListView gngListView, NycAidAPI nycAidAPI) {
        this.gngListView = gngListView;
        this.nycAidAPI = nycAidAPI;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getGnGSitesCall(String input) {
        NycAidRetrofit.getRetrofitInstance()
                .create(NycAidAPI.class)
                .getGnGSites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    viewResponse(response, input);
                }, throwable -> gngListView.showError());
    }

    private void viewResponse(FoodGrabWrapper response, String input) {
        List<FoodGrab> list = new ArrayList<>(response.getFoodgrab());
        final boolean success = !list.isEmpty();
        if (success) {
            Log.d("JessTag", "viewResponse: success");
            DataSort.sortListAlphabetically(list);
            gngListView.showGnGSites(list);
            searchByBoroughOrZip(response, input);
        } else {
            Log.d("JessTag2", "viewResponse: error");
            gngListView.showError();
        }
    }

    public void searchByBoroughOrZip(FoodGrabWrapper foodGrabWrapper, String input) {
        List<FoodGrab> list = new ArrayList<>(foodGrabWrapper.getFoodgrab());
        List<FoodGrab> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBorough().toLowerCase().startsWith(input.toLowerCase())) {
                newList.add(list.get(i));
            } else if (list.get(i).getZip().toLowerCase().startsWith(input.toLowerCase())) {
                newList.add(list.get(i));
            }
        }
        DataSort.sortListAlphabetically(newList);
        gngListView.showGnGSites(newList);
    }
}
