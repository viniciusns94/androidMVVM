package com.example.convidados.repository;

import android.content.Context;

import com.example.convidados.model.GuestModel;

import java.util.ArrayList;
import java.util.List;

public class GuestRepository {

    private static GuestRepository INSTANCE;
    private GuestDataBaseHelper mHelper;

    private GuestRepository(Context context) {
        this.mHelper = new GuestDataBaseHelper(context);
    }

    public static GuestRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new GuestRepository(context);
        }
        return INSTANCE;
    }

    public List<GuestModel> getList() {
        return new ArrayList<>();
    }

    public void insert(GuestModel guest) {

    }

    public void update(GuestModel guest) {

    }

    public void delete(GuestModel guest) {

    }
}
