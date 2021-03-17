package com.example.convidados.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.convidados.constants.DataBaseConstants;

public class GuestDataBaseHelper extends SQLiteOpenHelper {

    private static final String NAME = "convidades.bd";
    private static final int VERSION = 1;

    private static final String CREATE_TABLE_GUEST = "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " ( "
            + DataBaseConstants.GUEST.COLUMNS.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DataBaseConstants.GUEST.COLUMNS.NAME + " TEXT, "
            + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " INTEGER)";

    public GuestDataBaseHelper(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override 
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
