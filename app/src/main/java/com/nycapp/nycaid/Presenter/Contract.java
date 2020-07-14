package com.nycapp.nycaid.Presenter;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.Model.FoodGrabWrapper;

import java.util.List;

public interface Contract {

    interface GnGListView {
        void showGnGSites(List<FoodGrab> foodGrabList);
        void showError();
    }

    interface TestingListView {
        void showTestingSites();
        void showError();
    }

    interface GnGPresenter {
        void getGnGSitesCall(String string);
    }

    interface TestingPresenter {
        void getTestingSitesCall();
    }
}
