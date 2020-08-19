package com.nycapp.nycaid.Presenter.Finance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nycapp.nycaid.Presenter.HomeActivity;
import com.nycapp.nycaid.R;

public class FinanceHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_home);
        onUnemploymentCardClick();
        onHousingCardClick();
        onPublicAssistanceCardClick();
        onFuneralExpensesCardClick();
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

    private void onUnemploymentCardClick() {
        CardView foodStampsCard = findViewById(R.id.unemployment_cardView);
        foodStampsCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://dol.ny.gov/"));
        });
    }

    private void onHousingCardClick() {
        CardView foodPantryCard = findViewById(R.id.housing_cardView);
        foodPantryCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://hcr.ny.gov/RRP#:~:text=To%20qualify%20for%20COVID%20Rent," +
                            "residence%20in%20New%20York%20State.&text=3.-," +
                            "Before%20March%201%2C%202020%20and%20at%20the%20time%20of%20application," +
                            "gross%20monthly%20income%20for%20rent."));
        });
    }

    private void onPublicAssistanceCardClick() {
        CardView foodDeliveryCard = findViewById(R.id.publicAssistance_cardView);
        foodDeliveryCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://a069-access.nyc.gov/accesshra/#/"));
        });
    }

    private void onFuneralExpensesCardClick() {
        CardView foodDeliveryCard = findViewById(R.id.funeralExpenses_cardView);
        foodDeliveryCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://www1.nyc.gov/site/hra/help/burial-assistance.page"));
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