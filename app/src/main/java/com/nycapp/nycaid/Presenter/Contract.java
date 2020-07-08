package com.nycapp.nycaid.Presenter;

public interface Contract {

    interface gngListView {
        void showGnGSites();
        void showError();
    }

    interface testingListView{
        void showTestingSites();
        void showError();
    }

    interface gngPresenter{
        void getGnGSitesCall();
    }

    interface testingPresenter{
        void getTestingSitesCall();
    }
}
