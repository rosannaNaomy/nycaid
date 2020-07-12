package com.nycapp.nycaid.Presenter.Food.RCV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nycapp.nycaid.R;

public class GrabNGoAdapter extends RecyclerView.Adapter<GrabNGoViewHolder> {

    //TODO: Created private variable for Model class list
    //TODO: Create constructor with Model class list parameter

    @NonNull
    @Override
    public GrabNGoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_grab_n_go, parent, false);
        return new GrabNGoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrabNGoViewHolder holder, int position) {
        holder.onBind();//modelClassList.get(position)
    }

    @Override
    public int getItemCount() {
        //TODO: Return modelClassList.size()
        return 0;
    }
}
