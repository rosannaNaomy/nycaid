package com.nycapp.nycaid.Presenter.Food;

import android.annotation.SuppressLint;
import android.util.Log;
import android.widget.Toast;

import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;
import com.nycapp.nycaid.model.FoodGrab;
import com.nycapp.nycaid.model.FoodGrabWrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GnGPresenter implements Contract.GnGPresenter {

    private Contract.GnGListView gngListView;
    private NycAidAPI nycAidAPI;

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
                .subscribe(this::viewResponse, throwable -> gngListView.showError());
    }

    private void viewResponse(FoodGrabWrapper response) {
        List<FoodGrab> list = new ArrayList<>(response.getFoodgrab());
        final boolean success = !list.isEmpty();
        if (success) {
            Log.d("JessTag", "viewResponse: success");
            gngListView.showGnGSites(list);
        }
        else {
            Log.d("JessTag2", "viewResponse: error");
            gngListView.showError();
        }
    }
}
