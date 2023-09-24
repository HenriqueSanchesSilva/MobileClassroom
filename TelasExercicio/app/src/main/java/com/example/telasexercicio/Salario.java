package com.example.telasexercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Salario extends AppCompatActivity {

    EditText edtSalario;
    RadioButton rdb40, rdb45, rdb50;
    Button btnNovoSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);


        edtSalario = findViewById(R.id.edtSalario);
        rdb40 = findViewById(R.id.rdb40);
        rdb45 = findViewById(R.id.rdb45);
        rdb50 = findViewById(R.id.rdb50);
        btnNovoSalario = findViewById(R.id.btnNovoSalario);
    }
    public void novoSalario(View v){
        String status = "";
        Double salario;

        if(edtSalario.getText().toString().isEmpty()){
            status="Informe seu salário!";
        }else{
            salario = Double.parseDouble(edtSalario.getText().toString());
            if(rdb40.isChecked()){
                salario = Math.round((salario*1.4)*100.0)/100.0;
                status = status + " Novo salário é :" + salario;
            }else if(rdb45.isChecked()){
                salario = Math.round((salario*1.45)*100.0)/100.0;
                status = status + " Novo salário é :" + salario;
            }
            else if(rdb50.isChecked()){
                salario = Math.round((salario*1.5)*100.0)/100.0;
                status = status + " Novo salário é :" + salario;
            }else{
                status ="Selecione um percentual!";
            }
        }

        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }
}