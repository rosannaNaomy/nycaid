package com.nycapp.nycaid.Presenter.Food.RCV;

import android.content.Intent;
import android.net.Uri;
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
        if (foodGrab.getName().length() <= 33) foodGrabLocationName.setText(foodGrab.getName());
        else foodGrabLocationName.setText(foodGrab.getName().substring(0, 33));
        foodGrabAddress.setText(foodGrab.getAddress());
        String stateZip = foodGrab.getState() + ", " + foodGrab.getZip();
        foodGrabStateZip.setText(stateZip);
        itemView.setOnClickListener(view -> {
            String locationQuery = foodGrab.getAddress() + ", " + foodGrab.getState() + ", " + foodGrab.getZip();
            Uri gmIntentUri = Uri.parse("geo:0,0?q=" + locationQuery);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            itemView.getContext().startActivity(mapIntent);
        });
    }
}
