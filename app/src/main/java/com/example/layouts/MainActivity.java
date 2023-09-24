package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void chamaTelaPoupanca(View v){
        it = new Intent(getApplicationContext(), Poupanca.class);
        startActivity(it);
    }
    public void chamaTelaQuiz(View v){
        it = new Intent(getApplicationContext(), Quiz.class);
        startActivity(it);
    }
    public void chamaTelaRestaurante(View v){
        it = new Intent(getApplicationContext(), Restaurante.class);
        startActivity(it);
    }
    public void chamaTelaPizzaria(View v){
        it = new Intent(getApplicationContext(), Pizzaria.class);
        startActivity(it);
    }
}