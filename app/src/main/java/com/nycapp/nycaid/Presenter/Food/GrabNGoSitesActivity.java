package com.nycapp.nycaid.Presenter.Food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.nycapp.nycaid.Network.NycAidAPI;
import com.nycapp.nycaid.Network.NycAidRetrofit;
import com.nycapp.nycaid.Presenter.Contract;
import com.nycapp.nycaid.Presenter.Food.RCV.GrabNGoAdapter;
import com.nycapp.nycaid.Presenter.HomeActivity;
import com.nycapp.nycaid.R;
import com.nycapp.nycaid.Model.FoodGrab;

import java.util.List;

public class GrabNGoSitesActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, Contract.GnGListView {

    private Contract.GnGPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grab_n_go_sites);
        SearchView searchView = findViewById(R.id.gng_searchView);
        searchView.setOnQueryTextListener(this);
        searchView.clearFocus();
        Spinner spinner = (Spinner) findViewById(R.id.gng_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.borough_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        NycAidAPI api = NycAidRetrofit.getRetrofitInstance()
                .create(NycAidAPI.class);
        presenter = new GnGPresenter(this, api);
        presenter.getGnGSitesCall();
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
    public void showGnGSites(List<FoodGrab> foodGrabList) {
        RecyclerView recyclerView = findViewById(R.id.grabNgo_recyclerContainer);
        recyclerView.setAdapter(new GrabNGoAdapter(foodGrabList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
    }
}