package com.nycapp.nycaid.Presenter.Health;

import android.annotation.SuppressLint;
import android.util.Log;

import com.nycapp.nycaid.Model.TestSite;
import com.nycapp.nycaid.Model.TestSitesWrapper;
import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TestingPresenter implements Contract.TestingPresenter {

    private final Contract.TestingListView testingListView;
    private final NycAidAPI nycAidAPI;

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
          .subscribe(this::viewResponse, throwable -> testingListView.showError());
    }

    private void viewResponse(TestSitesWrapper response) {
        List<TestSite> list = new ArrayList<>(response.getTestSites());
        Log.d("NaomyCheck", "viewResponse: list size" + list.size());

        final boolean success = !list.isEmpty();
        if (success){
            Log.d("NaomyCheckSuccess", "viewResponse: success");
            testingListView.showTestingSites(list);
        }
        else {
            Log.d("NaomyCheckError", "viewResponse: error");
            testingListView.showError();
        }
    }
}
