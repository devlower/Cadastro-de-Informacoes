package com.puc.tuangieagenda.viewmodel;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.puc.tuangieagenda.database.Contatodb
import com.puc.tuangieagenda.model.Contato

class DbViewModele(contatodb: Contatodb) : ViewModel() {

    private val mContatodb = contatodb
    var list: MutableLiveData<List<Contato>> = MutableLiveData()

    fun insertContact() {
        mContatodb.addContact(
            Contato(
                "Tuanne",
                "13",
                "tuanne@email.com",
                "123.456.789-13",
                "35984047259"
            )
        )
        refreshList()
    }

    private fun refreshList() {
        mContatodb.all.let {
            list.postValue(it)
        }
    }
}
