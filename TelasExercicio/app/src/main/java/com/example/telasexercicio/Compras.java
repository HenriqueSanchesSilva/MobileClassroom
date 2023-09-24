package com.example.telasexercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Compras extends AppCompatActivity {

    private CheckBox chkArroz, chkLeite, chkCarne, chkFeijao, chkCoca;
    private Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        chkArroz = findViewById(R.id.chkArroz);
        chkLeite = findViewById(R.id.chkLeite);
        chkCarne = findViewById(R.id.chkCarne);
        chkFeijao = findViewById(R.id.chkFeijao);
        chkCoca = findViewById(R.id.chkCoca);
        btnCalc = findViewById(R.id.btnCalc);
    }
    public void calcValor(View v){
        double soma = 0;
        if(chkArroz.isChecked())
            soma += 12.35;
        if(chkLeite.isChecked())
            soma += 2.48;
        if(chkCarne.isChecked())
            soma += 23.99;
        if(chkFeijao.isChecked())
            soma += 4.30;
        if(chkCoca.isChecked())
            soma += 5.09;

        soma = Math.round(soma*100.0)/100.0;
        String status = "Resultado das Compras >>" + soma;
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }
}