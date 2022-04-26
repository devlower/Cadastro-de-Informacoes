package com.puc.tuangieagenda.database;

import com.puc.tuangieagenda.model.Contato;

import java.util.List;

public class Contatodb {

    ContatoDao contatoDao;

    Contatodb(ContatoDao contatoDao) {
        this.contatoDao = contatoDao;
    }

    void delete(Contato contato) {
        contatoDao.delete(contato);
    }

    List<Contato> getAll() {
        return contatoDao.getAll();
    }
    void addContact(Contato contato) {
        contatoDao.addContact(contato);
    }
}
