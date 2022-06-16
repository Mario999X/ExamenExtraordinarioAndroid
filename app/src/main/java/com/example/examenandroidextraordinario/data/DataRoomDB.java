package com.example.examenandroidextraordinario.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examenandroidextraordinario.model.DataEntity;

@Database(entities = {DataEntity.class}, version = 1)
public abstract class DataRoomDB extends RoomDatabase {

    private static String DATABASE_NAME = "basededatos";

    public abstract DataDao dataDao();

    private static volatile DataRoomDB INSTANCE;

    public synchronized static DataRoomDB getInstance(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    DataRoomDB.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
