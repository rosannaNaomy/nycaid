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

    //TODO: Created private variable for Model class list
    List<FoodGrab> foodGrabList;

    //TODO: Create constructor with Model class list parameter
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
        FoodGrab foodGrab = foodGrabList.get(position);
        GrabNGoViewHolder.onBind(foodGrab);//modelClassList.get(position)
    }

    @Override
    public int getItemCount() {
        //TODO: Return modelClassList.size()
        return foodGrabList.size();
    }
}
