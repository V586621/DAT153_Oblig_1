package com.example.dat153_oblig_1.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.dat153_oblig_1.classes.Helper;
import com.example.dat153_oblig_1.classes.Person;
import com.example.dat153_oblig_1.converters.Converter;
import com.example.dat153_oblig_1.dao.HelperDao;
import com.example.dat153_oblig_1.dao.PersonDao;

@Database(entities = {Person.class, Helper.class}, version = 9, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static final String DB_NAME = "app_db";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract PersonDao personDao();
    public abstract HelperDao helperDao();
}