package com.example.convidados.view.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convidados.model.GuestModel;
import com.example.convidados.view.viewholder.GuestViewHolder;

import java.util.ArrayList;
import java.util.List;

public class GuestAdapter extends RecyclerView.Adapter<GuestViewHolder> {

    private List<GuestModel> mList = new ArrayList<>();

    @NonNull
    @Override
    public GuestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GuestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }

    public void attachList(List<GuestModel> list){
        this.mList = list;
        notifyDataSetChanged();
    }
}
