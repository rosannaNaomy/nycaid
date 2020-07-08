package com.nycapp.nycaid.Presenter.Food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;
import com.nycapp.nycaid.R;
import com.nycapp.nycaid.Model.FoodGrab;

import java.util.List;

public class GrabNGoSitesActivity extends AppCompatActivity implements Contract.GnGListView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grab_n_go_sites);
        Log.d("GNG", "app created!");
        NycAidAPI api = NycAidRetrofit.getRetrofitInstance()
                .create(NycAidAPI.class);
        Contract.GnGPresenter presenter = new GnGPresenter(this, api);
        presenter.getGnGSitesCall();
    }

    @Override
    public void showGnGSites(List<FoodGrab> foodGrabList) {
    //TODO: RecyclerView
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
        Log.d("GNGTag", "showError: error");
    }
}