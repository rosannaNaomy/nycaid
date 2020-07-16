package com.nycapp.nycaid.Presenter.Health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.nycapp.nycaid.Model.TestSite;
import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;
import com.nycapp.nycaid.Presenter.Food.GrabNGoSitesActivity;
import com.nycapp.nycaid.Presenter.HomeActivity;
import com.nycapp.nycaid.R;

import java.util.List;

public class TestSitesActivity extends AppCompatActivity implements Contract.TestingListView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sites);
        Log.d("NaomyCheckSuccess", "onCreate: before call");

        NycAidAPI api = NycAidRetrofit.getRetrofitInstance()
          .create(NycAidAPI.class);
        Contract.TestingPresenter presenter = new TestingPresenter(this, api);
        presenter.getTestingSitesCall();
        Log.d("NaomyCheckSuccess", "onCreate: after call");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            return (true);
        }
        return(super.onOptionsItemSelected(item));
    }

    @Override
    public void showTestingSites(List<TestSite> testSiteList) {
        Toast.makeText(this, "List size: " + testSiteList.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
    }
}