package com.puc.tuangieagenda.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.puc.tuangieagenda.database.Contatodb;
import com.puc.tuangieagenda.model.Contato;

import java.util.List;

public class DbViewModel extends ViewModel {

    private Contatodb mContatodb;
    public MutableLiveData<List<Contato>> list = new MutableLiveData<>();

    public DbViewModel(Contatodb contatodb) {
        this.mContatodb = contatodb;
    }

    public void insertContact( ) {
        mContatodb.addContact(new Contato("1", "1", "tuannl.com", "-13", "359840"));
        mContatodb.addContact(new Contato("2", "2", "te@email.com", "123.43", "59"));
        mContatodb.addContact(new Contato("3", "3", "tuanne@emaim", "129-13", "359859"));

        refreshList();
    }

    private void refreshList() {
        list.postValue(mContatodb.getAll());
    }

    public MutableLiveData<List<Contato>> getList() {
        return list;
    }
}
