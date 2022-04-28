package com.puc.tuangieagenda.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.puc.tuangieagenda.model.Contato;

@Database(
        entities = {Contato.class},
        version = 1,
        exportSchema = false
)

public abstract class AppDatabase extends RoomDatabase {
    public abstract ContatoDao contatoDao();

}
