package com.t3ch.shaj.notesapp.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


/**
 * Created by Shakil Ahmed Shaj on 05-May-19.
 * shakilahmedshaj@gmail.com
 */
@Database(entities = {NoteEntity.class,},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "AppDatabase.db";

    private static volatile AppDatabase instance;
    private static final Object LOCK = new Object();

    public abstract NoteDao noteDao();


    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }

        return instance;
    }
}