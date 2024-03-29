package com.nycapp.nycaid.Presenter.Health.RCV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nycapp.nycaid.Model.TestSite;
import com.nycapp.nycaid.R;

import java.util.List;

public class TestSiteAdapter extends RecyclerView.Adapter<TestSiteViewHolder> {

    private List<TestSite> testSitesList;

    public TestSiteAdapter(List<TestSite> testSitesList) {
        this.testSitesList = testSitesList;
    }

    @NonNull
    @Override
    public TestSiteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_test_site, parent, false);
        return new TestSiteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestSiteViewHolder holder, int position) {
        holder.onBind(testSitesList.get(position));
    }

    @Override
    public int getItemCount() {
        return testSitesList.size();
    }
}
