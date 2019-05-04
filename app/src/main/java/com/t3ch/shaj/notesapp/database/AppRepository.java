package com.t3ch.shaj.notesapp.database;

import com.t3ch.shaj.notesapp.util.SampleData;

import java.util.List;

/**
 * Created by Shakil Ahmed Shaj on 05-May-19.
 * shakilahmedshaj@gmail.com
 */
public class AppRepository {

    public List<NoteEntity> mNotes;

    private static final AppRepository ourInstance = new AppRepository();

    public static AppRepository getInstance() {
        return ourInstance;
    }

    private AppRepository() {

        mNotes = SampleData.getNotes();

    }
}
