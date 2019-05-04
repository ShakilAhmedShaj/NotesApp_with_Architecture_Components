package com.t3ch.shaj.notesapp.database;

import android.content.Context;

import com.t3ch.shaj.notesapp.util.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Shakil Ahmed Shaj on 05-May-19.
 * shakilahmedshaj@gmail.com
 */
public class AppRepository {

    public List<NoteEntity> mNotes;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    private static AppRepository ourInstance;

    public static AppRepository getInstance(Context context) {

        if (ourInstance == null) {
            ourInstance = new AppRepository(context);

        }

        return ourInstance;
    }

    private AppRepository(Context context) {

        mNotes = SampleData.getNotes();
        mDb = AppDatabase.getInstance(context);

    }

    public void addSampleData() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.noteDao().insertAll((NoteEntity) SampleData.getNotes());
            }
        });
    }
}
