package com.example.telasexercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {

    private EditText edtValor1, edtValor2;
    private Button btnSoma, btnSub, btnDiv, btnMultiplica;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        edtValor1 = findViewById(R.id.edtValor1);
        edtValor2 = findViewById(R.id.edtValor2);
        btnSoma = findViewById(R.id.btnSoma);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMultiplica = findViewById(R.id.btnMultiplica);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void calcSoma(View v){

        int soma = Integer.parseInt(edtValor1.getText().toString()) + Integer.parseInt(edtValor2.getText().toString());

        txtResultado.setText("Resultado da Soma = "+soma);
    }
    public void calcSubtrai(View v){

        int soma = Integer.parseInt(edtValor1.getText().toString()) - Integer.parseInt(edtValor2.getText().toString());

        txtResultado.setText("Resultado da Subtração = "+soma);
    }
    public void calcDivisao(View v){

        int soma = Integer.parseInt(edtValor1.getText().toString()) / Integer.parseInt(edtValor2.getText().toString());

        txtResultado.setText("Resultado da Divisão = "+soma);
    }
    public void calcMultiplicacao(View v){

        int soma = Integer.parseInt(edtValor1.getText().toString()) * Integer.parseInt(edtValor2.getText().toString());

        txtResultado.setText("Resultado da Multiplicação = "+soma);
    }
}