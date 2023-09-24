package com.example.telasexercicio;

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

    public void chamaTela1(View v){
        it = new Intent(getApplicationContext(), Calculadora.class);
        startActivity(it);
    }

    public void chamaTela2(View v){
        it = new Intent(getApplicationContext(), Compras.class);
        startActivity(it);
    }

    public void chamaTela3(View v){
        it = new Intent(getApplicationContext(), Salario.class);
        startActivity(it);
    }

    public void chamaTela4(View v){
        it = new Intent(getApplicationContext(), ContaRestaurante.class);
        startActivity(it);
    }
}