package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Restaurante extends AppCompatActivity {

    EditText edtConsumo, edtCouvert, edtContaPorPessoa, edtTaxa, edtContaTotal, edtValorPorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtContaPorPessoa = findViewById(R.id.edtContaPorPessoa);
        edtTaxa = findViewById(R.id.edtTaxa);
        edtContaTotal = findViewById(R.id.edtContaTotal);
        edtValorPorPessoa = findViewById(R.id.edtValorPorPessoa);
    }

    public void calculaConta(View v){
        double consumo = Double.parseDouble(edtConsumo.getText().toString());
        double couvert = Double.parseDouble(edtCouvert.getText().toString());
        double valor =  consumo + couvert;
        double taxa = (valor/100)*10;
        double pessoas = Double.parseDouble(edtContaPorPessoa.getText().toString());
        String text = String.valueOf(taxa);
        edtTaxa.setText(text);
        text = String.valueOf(valor+taxa);
        edtContaTotal.setText(text);
        double vlrPerPessoa = (valor+taxa)/pessoas;
        text = String.valueOf(vlrPerPessoa);
        edtValorPorPessoa.setText(text);
    }
}