package com.nycapp.nycaid.Presenter.Health.RCV;

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
    private TextView testSitePhoneNumber;

    public TestSiteViewHolder(@NonNull View itemView) {
        super(itemView);
        testSiteLocationName = itemView.findViewById(R.id.testSite_locationName_textView);
        testSiteAddress = itemView.findViewById(R.id.testSite_address_textView);
        testSitePhoneNumber = itemView.findViewById(R.id.testSite_phoneContact_textView);
    }

    public void onBind(final TestSite testSite){
        testSiteLocationName.setText(testSite.getName());
        testSiteAddress.setText(testSite.getAddress());
        testSitePhoneNumber.setText(testSite.getPhone());
    }
}
