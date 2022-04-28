package com.puc.tuangieagenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.puc.tuangieagenda.R;
import com.puc.tuangieagenda.database.AppDatabase;
import com.puc.tuangieagenda.database.ContatoDao;
import com.puc.tuangieagenda.database.Contatodb;
import com.puc.tuangieagenda.model.Contato;
import com.puc.tuangieagenda.viewmodel.DbViewModel;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ListView listView = (ListView) findViewById(R.id.lista);
        fab = findViewById(R.id.fab_register);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callRegisterActivity = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(callRegisterActivity);
            }
        });

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "contato").build();

        ContatoDao contatoDao = db.contatoDao();

        Contatodb contatodb = new Contatodb(contatoDao);

        DbViewModel viewModel = new DbViewModel(contatodb);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    viewModel.insertContact();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();

        viewModel.getList().observe(this, value -> {
            Log.i("TAG", "abluble: " + value.toString());
        });

    }
}