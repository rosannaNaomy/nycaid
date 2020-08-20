package com.nycapp.nycaid.Presenter.Health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nycapp.nycaid.Model.TestSite;
import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;
import com.nycapp.nycaid.Presenter.Food.GrabNGoSitesActivity;
import com.nycapp.nycaid.Presenter.Food.RCV.GrabNGoAdapter;
import com.nycapp.nycaid.Presenter.Health.RCV.TestSiteAdapter;
import com.nycapp.nycaid.Presenter.HomeActivity;
import com.nycapp.nycaid.R;

import java.util.List;

public class TestSitesActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, Contract.TestingListView, AdapterView.OnItemSelectedListener {

    private Contract.TestingPresenter presenter;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sites);

        SearchView searchView = findViewById(R.id.test_sites_searchView);
        searchView.setOnQueryTextListener(this);
        searchView.clearFocus();
        NycAidAPI api = NycAidRetrofit.getRetrofitInstance()
                .create(NycAidAPI.class);
        presenter = new TestingPresenter(this, api);
        presenter.getTestingSitesCall();
        spinnerMenu();
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
        return (super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String input = newText.toLowerCase();
        presenter.searchListByZip(input);
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Object itemPos = adapterView.getItemAtPosition(i);
        presenter.searchListByBorough(itemPos);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void showTestingSites(List<TestSite> testSiteList) {
        RecyclerView recyclerView = findViewById(R.id.testSites_recyclerContainer);
        recyclerView.setAdapter(new TestSiteAdapter(testSiteList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
    }

    private void spinnerMenu() {
        spinner = (Spinner) findViewById(R.id.test_sites_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.borough_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}