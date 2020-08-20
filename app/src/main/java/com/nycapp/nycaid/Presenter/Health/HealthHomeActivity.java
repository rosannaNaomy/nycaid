package com.nycapp.nycaid.Presenter.Health;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nycapp.nycaid.Presenter.Food.GrabNGoSitesActivity;
import com.nycapp.nycaid.Presenter.HomeActivity;
import com.nycapp.nycaid.R;

public class HealthHomeActivity extends AppCompatActivity {

    private static CardView testSitesCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_home);
        onTestingSitesCardClick();
        onSafetyTipsCardClick();
        onMedicaidCardClick();
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

    private void onTestingSitesCardClick() {
        CardView testingSitesCard = findViewById(R.id.testing_cardView);
        testingSitesCard.setOnClickListener(v -> {
            Intent intent = new Intent(testingSitesCard.getContext(), TestSitesActivity.class);
            testingSitesCard.getContext().startActivity(intent);
        });
    }

    private void onSafetyTipsCardClick() {
        CardView safetyTipsCard = findViewById(R.id.safety_tips_cardView);
        safetyTipsCard.setOnClickListener(v -> {
            Intent intent = new Intent(safetyTipsCard.getContext(), SafetyTipsActivity.class);
            safetyTipsCard.getContext().startActivity(intent);
        });
    }

    private void onMedicaidCardClick() {
        CardView foodPantryCard = findViewById(R.id.medicaid_cardView);
        foodPantryCard.setOnClickListener(v -> {
            CustomTabsIntent customTabsIntent = customTabBuilder().build();
            customTabsIntent.launchUrl(this,
                    Uri.parse("https://nystateofhealth.ny.gov"));
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