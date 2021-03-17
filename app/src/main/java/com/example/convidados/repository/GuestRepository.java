package com.example.convidados.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.convidados.constants.DataBaseConstants;
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

    public boolean insert(GuestModel guest) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.getConfirmation());

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(GuestModel guest) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.getName());
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.getConfirmation());

            String where = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] args = {String.valueOf(guest.getId())};

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, where, args);
            db.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            String where = DataBaseConstants.GUEST.COLUMNS.ID + " = ?";
            String[] args = {String.valueOf(id)};

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, where, args);
            db.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
