package com.puc.tuangieagenda.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.puc.tuangieagenda.model.Contato;

@Database(
        entities = {Contato.class},
        version = 1,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {
    public abstract ContatoDao contatoDao();

}
