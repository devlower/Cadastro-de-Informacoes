package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button yes;
    private Button no;
    private TextView dynamicQuestions;
    private ArrayList<String> questionsList = new ArrayList<String>();
    private int positiveClick;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProperties();
        setListeners();
    }

    private void initProperties() {
        yes = findViewById(R.id.btn_yes);
        no = findViewById(R.id.btn_no);
        dynamicQuestions = findViewById(R.id.dynamicQuestions);
        questionsList.add("Nos últimos 10 dias você recebeu o diagnóstico positivo de COVID-19?");
        questionsList.add("Você teve contato com alguma pessoa com diagnóstico positivo de COVID-19 nos últimos 10 dias?");
        questionsList.add("Você apresenta neste momento dois ou mais sintomas listados da seguir? (verificar os sintomas no aplicativo PUC Mobile)");

    }

    private void setListeners() {
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Resposta enviada", Toast.LENGTH_SHORT).show();
                index++;
                positiveClick++;
                showQuestions();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Resposta enviada", Toast.LENGTH_SHORT).show();
                index++;
            }
        });
    }

    private void showQuestions() {
        while (index < 3) {
            String question = questionsList.get(index);
            dynamicQuestions.setText("question");
        }
    }

}