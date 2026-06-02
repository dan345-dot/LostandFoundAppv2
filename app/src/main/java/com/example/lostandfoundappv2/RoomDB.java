package com.example.lostandfoundappv2;

import android.content.Context;
import android.media.RouteListingPreference;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lostandfoundappv2.Items;

@Database(entities = {Items.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB database;

    private static final String DATABASE_NAME = "ItemApp";

    public static synchronized RoomDB getInstance(Context context) {

        if (database == null) {

            database = Room.databaseBuilder(
                            context.getApplicationContext(),
                            RoomDB.class,
                            DATABASE_NAME
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }}


