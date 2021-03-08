package com.najimaddinova.autoscout24codechallenge;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ColorItemRecyclerViewAdapter extends RecyclerView.Adapter<ColorItemRecyclerViewAdapter.MyViewHolder> {

    ArrayList<ListItemData> itemData;
    private RecyclerViewClickListener rv_clickListener;


    public ColorItemRecyclerViewAdapter(ArrayList<ListItemData> itemData,RecyclerViewClickListener listener) {
        this.itemData = itemData;
        this.rv_clickListener = listener;
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        FrameLayout frameLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            frameLayout = itemView.findViewById(R.id.list_item);
            textView = itemView.findViewById(R.id.tv_colorId);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onViewRecycled(@NonNull MyViewHolder holder) {
        super.onViewRecycled(holder);
        holder.frameLayout.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ListItemData listItemData = itemData.get(position);
        holder.textView.setText(listItemData.getName());
        holder.itemView.setOnClickListener((v) -> {
            this.rv_clickListener.onClick(listItemData);
        });
        if (listItemData.getColorValue() != 0){
            holder.frameLayout.setBackgroundColor(listItemData.getColorValue());
        }
    }


    @Override
    public int getItemCount() {
        return itemData.size();
    }
}
