package com.nycapp.nycaid.Presenter.Health.RCV;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.Model.TestSite;
import com.nycapp.nycaid.R;

public class TestSiteViewHolder extends RecyclerView.ViewHolder {

    private TextView testSiteLocationName;
    private TextView testSiteAddress;
    private TextView testSiteStateZip;

    public TestSiteViewHolder(@NonNull View itemView) {
        super(itemView);
        testSiteLocationName = itemView.findViewById(R.id.testSite_locationName_textView);
        testSiteAddress = itemView.findViewById(R.id.testSite_address_textView);
        testSiteStateZip = itemView.findViewById(R.id.testSite_stateZip_textView);
    }

    public void onBind(final TestSite testSite){
        if (testSite.getName().length() <= 33) testSiteLocationName.setText(testSite.getName());
        else testSiteLocationName.setText(testSite.getName().substring(0, 33));
        testSiteAddress.setText(testSite.getAddress());
        String stateZip = testSite.getState() + ", " + testSite.getZip();
        testSiteStateZip.setText(stateZip);
        itemView.setOnClickListener(view -> {
            String locationQuery = testSite.getAddress() + ", " + testSite.getState() + ", " + testSite.getZip();
            Uri gmIntentUri = Uri.parse("geo:0,0?q=" + locationQuery);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            itemView.getContext().startActivity(mapIntent);
        });
    }
}
