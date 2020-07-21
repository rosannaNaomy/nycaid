package com.nycapp.nycaid.Presenter.Food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
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
        CardView foodStampsCard = findViewById(R.id.grabnGo_cardView);
        foodStampsCard.setOnClickListener(v -> {
        });
    }

    private void onFoodPantryCardClick() {
        CardView foodPantryCard = findViewById(R.id.grabnGo_cardView);
        foodPantryCard.setOnClickListener(v -> {
        });
    }

    private void onFoodDeliveryCardClick() {
        CardView foodDeliveryCard = findViewById(R.id.grabnGo_cardView);
        foodDeliveryCard.setOnClickListener(v -> {
        });
    }
}