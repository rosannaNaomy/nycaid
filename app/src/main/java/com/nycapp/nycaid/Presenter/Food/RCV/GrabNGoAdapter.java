package com.nycapp.nycaid.Presenter.Food.RCV;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nycapp.nycaid.Model.FoodGrab;
import com.nycapp.nycaid.R;

import java.util.List;

public class GrabNGoAdapter extends RecyclerView.Adapter<GrabNGoViewHolder> {

    private List<FoodGrab> foodGrabList;

    public GrabNGoAdapter(List<FoodGrab> foodGrabList){
        this.foodGrabList = foodGrabList;
    }

    @NonNull
    @Override
    public GrabNGoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_grab_n_go, parent, false);
        return new GrabNGoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrabNGoViewHolder holder, int position) {
        holder.onBind(foodGrabList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodGrabList.size();
    }
}
