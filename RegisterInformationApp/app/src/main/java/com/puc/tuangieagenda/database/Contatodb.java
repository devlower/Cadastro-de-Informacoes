package com.puc.tuangieagenda.database;

import com.puc.tuangieagenda.model.Contato;

import java.util.List;

public class Contatodb {

    ContatoDao contatoDao;

    public Contatodb(ContatoDao contatoDao) {
        this.contatoDao = contatoDao;
    }

    public void delete(Contato contato) {
        contatoDao.delete(contato);
    }

    public List<Contato> getAll() {
        return contatoDao.getAll();
    }
    public void addContact(Contato contato) {
        contatoDao.addContact(contato);
    }
}
