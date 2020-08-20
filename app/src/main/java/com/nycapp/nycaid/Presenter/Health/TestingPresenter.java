package com.nycapp.nycaid.Presenter.Health;

import android.annotation.SuppressLint;
import android.util.Log;

import com.nycapp.nycaid.DataSort;
import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.Model.TestSite;
import com.nycapp.nycaid.Model.TestSitesWrapper;
import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestingPresenter implements Contract.TestingPresenter {

    private final Contract.TestingListView testingListView;
    private final NycAidAPI nycAidAPI;
    private List<TestSite> list;

    public TestingPresenter(Contract.TestingListView testingListView, NycAidAPI nycAidAPI) {
        this.testingListView = testingListView;
        this.nycAidAPI = nycAidAPI;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getTestingSitesCall() {
        NycAidRetrofit.getRetrofitInstance()
                .create(NycAidAPI.class)
                .getTestSites()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            list = new ArrayList<>(viewResponse(response));
                        },
                        throwable -> testingListView.showError());
    }

    @Override
    public void searchListByZip(String input) {
        List<TestSite> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getZip().toLowerCase().startsWith(input.toLowerCase())) {
                newList.add(list.get(i));
            }
        }
        DataSort.sortTestListAlphabetically(newList);
        testingListView.showTestingSites(newList);
    }

    @Override
    public void searchListByBorough(Object input) {
        List<TestSite> newList = new ArrayList<>();
        if (input.toString().startsWith("NYC")) {
            DataSort.sortTestListAlphabetically(list);
            testingListView.showTestingSites(list);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBorough().startsWith(input.toString())) {
                newList.add(list.get(i));
                DataSort.sortTestListAlphabetically(newList);
                testingListView.showTestingSites(newList);
            }
        }
    }

    private List<TestSite> viewResponse(TestSitesWrapper response) {
        final boolean success = !response.getTestSites().isEmpty();
        if (success) {
            DataSort.sortTestListAlphabetically(response.getTestSites());
            testingListView.showTestingSites(list);
        } else {
            testingListView.showError();
        }
        return response.getTestSites();
    }
}

