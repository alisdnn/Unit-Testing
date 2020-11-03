package com.example.unittesting.di;

import android.app.Application;

import androidx.room.Room;

import com.example.unittesting.persistence.NoteDao;
import com.example.unittesting.persistence.NoteDatabase;
import com.example.unittesting.repository.NoteRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.example.unittesting.persistence.NoteDatabase.DATABASE_NAME;

@Module
class AppModule {

    @Singleton
    @Provides
    static NoteDatabase provideNoteDatabase(Application application){
        return Room.databaseBuilder(
                application,
                NoteDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static NoteDao provideNoteDao(NoteDatabase noteDatabase){
        return noteDatabase.getNoteDao();
    }


    @Singleton
    @Provides
    static NoteRepository provideNoteRepository(NoteDao noteDao){
        return new NoteRepository(noteDao);
    }
}















