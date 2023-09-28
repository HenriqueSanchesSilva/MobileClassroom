package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class Quiz extends AppCompatActivity {

    private ImageView imgPlaca;
    private TextView txtNQuestao;
    Random rand = new Random();
    int indice=1, pontos=0;
    int correto = 1, resposta, erradas=1;

    Button btn1, btn2, btn3, btn4, btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        imgPlaca= findViewById(R.id.imgPlaca);
        txtNQuestao = findViewById(R.id.txtNQuestao);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btnProximo = findViewById(R.id.btnProximo);




        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tag = v.getTag().toString();
                int buttonValue = Integer.parseInt(tag);
                switch (buttonValue) {
                    case 1:
                        btnProximo.setEnabled(true);
                        btn1.setBackgroundColor(Color.parseColor("#9275F0"));
                        btn2.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn3.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn4.setBackgroundColor(Color.parseColor("#45BE35"));
                        btnProximo.setBackgroundColor(Color.parseColor("#29E009"));
                        resposta = 1;
                        break;
                    case 2:
                        btnProximo.setEnabled(true);
                        btn1.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn2.setBackgroundColor(Color.parseColor("#9275F0"));
                        btn3.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn4.setBackgroundColor(Color.parseColor("#45BE35"));
                        btnProximo.setBackgroundColor(Color.parseColor("#29E009"));
                        resposta = 2;
                        break;
                    case 3:
                        btnProximo.setEnabled(true);
                        btn1.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn2.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn3.setBackgroundColor(Color.parseColor("#9275F0"));
                        btn4.setBackgroundColor(Color.parseColor("#45BE35"));
                        btnProximo.setBackgroundColor(Color.parseColor("#29E009"));
                        resposta = 3;
                        break;
                    case 4:
                        btnProximo.setEnabled(true);
                        btn1.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn2.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn3.setBackgroundColor(Color.parseColor("#45BE35"));
                        btn4.setBackgroundColor(Color.parseColor("#9275F0"));
                        btnProximo.setBackgroundColor(Color.parseColor("#29E009"));
                        resposta = 4;
                        break;
                }
            }
        };

        btn1.setOnClickListener(buttonClickListener);
        btn2.setOnClickListener(buttonClickListener);
        btn3.setOnClickListener(buttonClickListener);
        btn4.setOnClickListener(buttonClickListener);
    }


    public void botaoProx(View v) {
        if(indice==1){
            if (correto == resposta) {
                pontos++;
            }
        }else{
            if (correto + 1 == resposta) {
                pontos++;
            }
        }
        if (indice == 4) {
            btnProximo.setText("Finalizar");
        }
        if (indice < 5) {
            indice++;
            txtNQuestao.setText("Questão " + indice + " de 5");
            String image = "img" + indice;
            int id = getResources().getIdentifier(image, "drawable", getPackageName());
            Drawable img = getResources().getDrawable(id);
            imgPlaca.setImageDrawable(img);

            gerarRespostas();
        } else {
            String mensagem = "Você acertou " + pontos + "/5 das placas.";
            Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();

            reiniciarAtividade();
        }
    }



    public void gerarRespostas() {
        int id = iD("placa", indice);
        correto = rand.nextInt(4);
        setText(correto, id);

        ArrayList<Integer> opcoesIncorretas = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            if (i != correto) {
                opcoesIncorretas.add(i);
            }
        }

        for (int i = 0; i < 3; i++) {
            int opcaoIncorretaIndex = rand.nextInt(opcoesIncorretas.size());
            int opcaoIncorreta = opcoesIncorretas.remove(opcaoIncorretaIndex);
            id = iD("placaErrada", erradas);
            setText(opcaoIncorreta, id);
            erradas++;
        }
    }


    public void setText(int btn, int id) {
        String texto = getResources().getString(id);
        switch (btn) {
            case 0:
                btn1.setText(texto);
                break;
            case 1:
                btn2.setText(texto);
                break;
            case 2:
                btn3.setText(texto);
                break;
            case 3:
                btn4.setText(texto);
                break;
        }
    }
    public int iD(String name, int num) {
        String texto = name + num;
        int id = getResources().getIdentifier(texto, "string", getPackageName());

        if (id == 0) {
            Log.e("Quiz", "ID not found for " + texto);
        }

        return id;
    }


    private void reiniciarAtividade() {
        Intent intent = getIntent();
        finish(); // Encerra a atividade atual
        startActivity(intent); // Inicia a atividade novamente
    }
}