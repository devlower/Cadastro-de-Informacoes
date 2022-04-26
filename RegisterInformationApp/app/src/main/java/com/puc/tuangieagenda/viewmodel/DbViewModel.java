package com.puc.tuangieagenda.viewmodel;

import androidx.lifecycle.ViewModel;

import com.puc.tuangieagenda.database.ContatoDao;
import com.puc.tuangieagenda.model.Contato;

public class DbViewModel extends ViewModel {
    void insertContact() {
        ContatoDao contatoDao = db.contatoDao();
        contatoDao.addContact(new Contato("Tuanne", 13, "tuanne@email.com", "123.456.789-13", "35984047259"));
    }
}
