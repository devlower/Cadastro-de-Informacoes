package com.puc.tuangieagenda.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.puc.tuangieagenda.model.Contato;

import java.util.List;

@Dao
public interface ContatoDao {
    @Query("SELECT * FROM contato")
    List<Contato> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addContact(Contato... users);

    @Delete
    void delete(Contato contato);
}
