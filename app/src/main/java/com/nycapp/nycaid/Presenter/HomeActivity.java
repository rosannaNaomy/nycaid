package com.nycapp.nycaid.Presenter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.nycapp.nycaid.Presenter.Finance.FinanceHomeActivity;
import com.nycapp.nycaid.Presenter.Food.FoodHomeActivity;
import com.nycapp.nycaid.Presenter.Food.GrabNGoSitesActivity;
import com.nycapp.nycaid.Presenter.Health.HealthHomeActivity;
import com.nycapp.nycaid.R;

public class HomeActivity extends AppCompatActivity {


    private static CardView foodCard;
    private static CardView financeCard;
    private static CardView healthCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

       foodCard = findViewById(R.id.homeFood_cardView);
        financeCard = findViewById(R.id.homeFinance_cardView);
        healthCard = findViewById(R.id.homeHealth_cardView);


        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(foodCard.getContext(), FoodHomeActivity.class);
                foodCard.getContext().startActivity(intent);
            }
        });

        financeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(financeCard.getContext(), FinanceHomeActivity.class);
                financeCard.getContext().startActivity(intent);
            }
        });

        healthCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(healthCard.getContext(), HealthHomeActivity.class);
                healthCard.getContext().startActivity(intent);
            }
        });



    }



}