package com.nycapp.nycaid.Presenter.Food.RCV;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.R;

public class GrabNGoViewHolder extends RecyclerView.ViewHolder {

    private static CardView foodgrabCard;
    private static TextView foodgrabLocationName;
    private static TextView foodGrabAddress;

    public GrabNGoViewHolder(@NonNull View itemView) {
        super(itemView);
        //TODO: Bind views
        this.foodgrabCard = itemView.findViewById(R.id.layout_grabNgo_cardview);
        this.foodgrabLocationName = itemView.findViewById(R.id.grabNGo_locationName_textView);
        this.foodGrabAddress = itemView.findViewById(R.id.grabNgo_address_textView);
    }

    public void onBind(final FoodGrab foodGrab){
        //TODO: Set views
        foodgrabLocationName.setText(foodGrab.getName());
        foodGrabAddress.setText(foodGrab.getAddress());

    }
}
