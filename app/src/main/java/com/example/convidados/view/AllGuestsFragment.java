package com.example.convidados.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convidados.R;
import com.example.convidados.model.GuestModel;
import com.example.convidados.view.adapter.GuestAdapter;
import com.example.convidados.viewmodel.AllGuestsViewModel;

import java.util.List;

public class AllGuestsFragment extends Fragment {

    private AllGuestsViewModel mViewModel;
    private ViewHolder mViewHolder = new ViewHolder();
    private GuestAdapter mAdapter = new GuestAdapter();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mViewModel = new ViewModelProvider(this).get(AllGuestsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_all_guests, container, false);

        this.mViewHolder.recyclerGuests = root.findViewById(R.id.recycler_list);
        this.mViewHolder.recyclerGuests.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mViewHolder.recyclerGuests.setAdapter(mAdapter);

        this.observers();

        return root;
    }

    private static class ViewHolder {
        RecyclerView recyclerGuests;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mViewModel.getList();
    }

    private void observers(){
        this.mViewModel.guestList.observe(getViewLifecycleOwner(), new Observer<List<GuestModel>>() {
            @Override
            public void onChanged(List<GuestModel> list) {
                mAdapter.attachList(list);
            }
        });
    }
}