package com.puc.tuangieagenda.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.puc.tuangieagenda.R;
import com.puc.tuangieagenda.database.AppDatabase;
import com.puc.tuangieagenda.database.ContatoDao;
import com.puc.tuangieagenda.database.Contatodb;
import com.puc.tuangieagenda.model.Contato;
import com.puc.tuangieagenda.viewmodel.DbViewModel;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText birthDate;
    private EditText phone;
    private EditText email;
    private EditText cpf;
    private Button btnRegister;

    private AppDatabase db;
    private ContatoDao contatoDao;
    private DbViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.et_name);
        birthDate = findViewById(R.id.et_birth_date);
        phone = findViewById(R.id.et_phone);
        email = findViewById(R.id.et_email);
        cpf = findViewById(R.id.et_cpf);
        btnRegister = findViewById(R.id.btn_register);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "contato").build();
        contatoDao = db.contatoDao();
        Contatodb contatodb = new Contatodb(contatoDao);
        appViewModel = new DbViewModel(contatodb);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato contato = new Contato(name.toString(), birthDate.toString(), email.toString(), cpf.toString(), phone.toString());
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            appViewModel.insertContact();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                finish();
            }
        });

    }
}