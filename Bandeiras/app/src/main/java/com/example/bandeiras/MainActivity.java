package com.example.bandeiras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private Button btnIniciar;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        btnIniciar = findViewById(R.id.btnIniciar);

        txtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    btnIniciar.setEnabled(false);
                } else {
                    btnIniciar.setEnabled(true);
                }
            }
        });
    }

    public void chamaQuiz(View v){
        it = new Intent(getApplicationContext(), Quiz.class);
        it.putExtra("nome", txtNome.getText().toString());
        startActivity(it);
    }

    public void fecha(View v){
        finishAffinity();
    }
}
