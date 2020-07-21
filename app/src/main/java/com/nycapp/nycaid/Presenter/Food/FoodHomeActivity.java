package com.nycapp.nycaid.Presenter.Food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nycapp.nycaid.Presenter.HomeActivity;
import com.nycapp.nycaid.R;

public class FoodHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_home);
        onGNGCardClick();
        onFoodStampsCardClick();
        onFoodPantryCardClick();
        onFoodDeliveryCardClick();
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

    private void onGNGCardClick() {
        CardView grabNgoCard = findViewById(R.id.grabnGo_cardView);
        grabNgoCard.setOnClickListener(v -> {
            Intent intent = new Intent(grabNgoCard.getContext(), GrabNGoSitesActivity.class);
            grabNgoCard.getContext().startActivity(intent);
        });
    }

    private void onFoodStampsCardClick() {
        CardView foodStampsCard = findViewById(R.id.foodStamps_cardView);
        foodStampsCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://a069-access.nyc.gov/accesshra/#/"));
        });
    }

    private void onFoodPantryCardClick() {
        CardView foodPantryCard = findViewById(R.id.foodPantry_cardView);
        foodPantryCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://maps.nyc.gov/foodhelp/#map-page"));
        });
    }

    private void onFoodDeliveryCardClick() {
        CardView foodDeliveryCard = findViewById(R.id.foodDelivery_cardView);
        foodDeliveryCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://cv19engagementportal.cityofnewyork.us/#/display/5e7555117ad6750216160409"));
        });
    }

    private CustomTabsIntent.Builder customTabBuilder() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getApplicationContext()
                .getResources()
                .getColor(R.color.colorPrimary));
        return builder;
    }
}