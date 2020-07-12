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

    private static CardView grabNgoCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_home);

        grabNgoCard = findViewById(R.id.grabnGo_cardView);

        grabNgoCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(grabNgoCard.getContext(), GrabNGoSitesActivity.class);
                grabNgoCard.getContext().startActivity(intent);
            }
        });
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
}