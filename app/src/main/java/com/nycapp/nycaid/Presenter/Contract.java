package com.nycapp.nycaid.Presenter;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.Model.TestSite;

import java.util.List;

public interface Contract {

    interface GnGListView {
        void showGnGSites(List<FoodGrab> foodGrabList);
        void showError();
    }

    interface TestingListView {
        void showTestingSites(List<TestSite> testSiteList);
        void showError();
    }

    interface GnGPresenter {
        void getGnGSitesCall();
        void searchListByZip(String input);
        void searchListByBorough(Object input);
    }

    interface TestingPresenter {
        void getTestingSitesCall();
        void searchListByZip(String input);
        void searchListByBorough(Object input);
    }
}
