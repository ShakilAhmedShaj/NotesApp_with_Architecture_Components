package com.t3ch.shaj.notesapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.t3ch.shaj.notesapp.database.AppRepository;
import com.t3ch.shaj.notesapp.database.NoteEntity;
import com.t3ch.shaj.notesapp.util.SampleData;

import java.util.List;


/**
 * Created by Shakil Ahmed Shaj on 05-May-19.
 * shakilahmedshaj@gmail.com
 */
public class MainViewModel extends AndroidViewModel {

    public List<NoteEntity> mNotes;
    private AppRepository mRepository;


    public MainViewModel(@NonNull Application application) {
        super(application);

        mRepository = AppRepository.getInstance();
        mNotes = SampleData.getNotes();


    }
}