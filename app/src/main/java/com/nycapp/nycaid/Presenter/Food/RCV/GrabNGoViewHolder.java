package com.nycapp.nycaid.Presenter.Food.RCV;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.R;

public class GrabNGoViewHolder extends RecyclerView.ViewHolder {

    private TextView foodGrabLocationName;
    private TextView foodGrabAddress;
    private TextView foodGrabStateZip;

    public GrabNGoViewHolder(@NonNull View itemView) {
        super(itemView);
        foodGrabLocationName = itemView.findViewById(R.id.grabNGo_locationName_textView);
        foodGrabAddress = itemView.findViewById(R.id.grabNgo_address_textView);
        foodGrabStateZip = itemView.findViewById(R.id.grabNGo_stateZip_textView);
    }

    public void onBind(final FoodGrab foodGrab) {
        foodGrabLocationName.setText(foodGrab.getName());
        foodGrabAddress.setText(foodGrab.getAddress());
        String stateZip = foodGrab.getState() + ", " + foodGrab.getZip();
        foodGrabStateZip.setText(stateZip);
    }
}
