package com.example.telasexercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class ContaRestaurante extends AppCompatActivity {

    EditText edtConsumo, edtCouvert, edtContaPorPessoa, edtTaxa, edtContaTotal, edtValorPorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_restaurante);

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtContaPorPessoa = findViewById(R.id.edtContaPorPessoa);
        edtTaxa = findViewById(R.id.edtTaxa);
        edtContaTotal = findViewById(R.id.edtContaTotal);
        edtValorPorPessoa = findViewById(R.id.edtValorPorPessoa);

    }
}