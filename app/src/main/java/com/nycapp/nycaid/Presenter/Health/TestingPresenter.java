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

    public TestingPresenter(Contract.TestingListView testingListView, NycAidAPI nycAidAPI) {
        this.testingListView = testingListView;
        this.nycAidAPI = nycAidAPI;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getTestingSitesCall() {
        Log.d("NaomyCheck", "getTestingSitesCall: calling");
        NycAidRetrofit.getRetrofitInstance()
          .create(NycAidAPI.class)
          .getTestSites()
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(this::viewResponse, throwable -> {
              Log.d("NaomyCheckError", "viewResponse: error" + throwable);
              testingListView.showError();
          });
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

