package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Pizzaria extends AppCompatActivity {

    private EditText txtQueijo, txtMargh, txtCalabresa, txtChocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaria);

        txtQueijo = findViewById(R.id.txtQueijo);
        txtMargh = findViewById(R.id.txtMargh);
        txtCalabresa = findViewById(R.id.txtCalabresa);
        txtChocolate = findViewById(R.id.txtChocolate);

    }

    public void pedido(View v) {
        double queijo = 0.0;
        double margh = 0.0;
        double calabresa = 0.0;
        double chocolate = 0.0;

        if (!txtQueijo.getText().toString().isEmpty()) {
            queijo = Double.parseDouble(txtQueijo.getText().toString()) * 79.99;
        }
        if (!txtMargh.getText().toString().isEmpty()) {
            margh = Double.parseDouble(txtMargh.getText().toString()) * 79.99;
        }
        if (!txtCalabresa.getText().toString().isEmpty()) {
            calabresa = Double.parseDouble(txtCalabresa.getText().toString()) * 59.99;
        }
        if (!txtChocolate.getText().toString().isEmpty()) {
            chocolate = Double.parseDouble(txtChocolate.getText().toString()) * 62.00;
        }

        double preco = queijo + margh + calabresa + chocolate;
        preco = Math.round(preco * 100) / 100;
        String mensagem = "Preço final R$ " + preco;
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

}