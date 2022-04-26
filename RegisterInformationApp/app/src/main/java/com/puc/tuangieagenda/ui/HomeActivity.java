package com.puc.tuangieagenda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.puc.tuangieagenda.R;
import com.puc.tuangieagenda.database.AppDatabase;
import com.puc.tuangieagenda.database.ContatoDao;
import com.puc.tuangieagenda.model.Contato;

public class HomeActivity extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

//        Log.i("TAG", "ablublé" + contatoDao.getAll());
    }
}