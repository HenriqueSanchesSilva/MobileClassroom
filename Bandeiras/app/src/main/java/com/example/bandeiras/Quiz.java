package com.example.bandeiras;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class Quiz extends AppCompatActivity {

    private ImageView imgBandeira;
    private TextView txtNQuestao;
    Random rand = new Random();
    int indice=1, pontos=0;
    int correto = 1, resposta, erradas=1;
    private RadioGroup rdgBandeiras;
    Intent it;
    Intent get;
    String nome;
    private RadioButton rdbBandeira1, rdbBandeira2, rdbBandeira3, rdbBandeira4;

    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        get = getIntent();

        imgBandeira = findViewById(R.id.imgBandeira);
        txtNQuestao = findViewById(R.id.txtNQuestao);
        rdgBandeiras = findViewById(R.id.rdgBandeiras);
        btnProximo = findViewById(R.id.btnProximo);
        rdbBandeira1 = findViewById(R.id.rdbBandeira1);
        rdbBandeira2 = findViewById(R.id.rdbBandeira2);
        rdbBandeira3 = findViewById(R.id.rdbBandeira3);
        rdbBandeira4 = findViewById(R.id.rdbBandeira4);
        nome = get.getStringExtra("nome");

        View.OnClickListener radioClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnProximo.setEnabled(true);
                if (v.getId() == R.id.rdbBandeira1) {
                    resposta = 1;
                } else if (v.getId() == R.id.rdbBandeira2) {
                    resposta = 2;
                } else if (v.getId() == R.id.rdbBandeira3) {
                    resposta = 3;
                } else if (v.getId() == R.id.rdbBandeira4) {
                    resposta = 4;
                }
            }
        };

        rdbBandeira1.setOnClickListener(radioClickListener);
        rdbBandeira2.setOnClickListener(radioClickListener);
        rdbBandeira3.setOnClickListener(radioClickListener);
        rdbBandeira4.setOnClickListener(radioClickListener);
    }


    public void botaoProx(View v) {
        if(indice==1){
            if (correto == resposta) {
                pontos++;
            }
        }else{
            if (correto+1 == resposta) {
                pontos++;
            }
        }

        resposta = -1;
        if (indice == 9) {
            btnProximo.setText("Finalizar");
        }
        if (indice < 10) {
            indice++;
            txtNQuestao.setText("Questão " + indice + " de 10");
            String image = "img" + indice;
            int id = getResources().getIdentifier(image, "drawable", getPackageName());
            Drawable img = getResources().getDrawable(id);
            imgBandeira.setImageDrawable(img);

            // Desmarque todos os RadioButtons no RadioGroup
            rdgBandeiras.clearCheck();  // Isso desmarcará todos os botões de opção
            btnProximo.setEnabled(false);
            gerarRespostas();
        } else {
            it = new Intent(getApplicationContext(), Ranking.class);
            it.putExtra("nome",nome);
            it.putExtra("pontos",pontos);
            startActivity(it);
        }
    }




    public void gerarRespostas() {
        int id = iD("bandeira", indice);
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
            id = iD("bandeiraErrada", erradas);
            setText(opcaoIncorreta, id);
            erradas++;
        }
    }


    public void setText(int btn, int id) {
        String texto = getResources().getString(id);
        switch (btn) {
            case 0:
                rdbBandeira1.setText(texto);
                break;
            case 1:
                rdbBandeira2.setText(texto);
                break;
            case 2:
                rdbBandeira3.setText(texto);
                break;
            case 3:
                rdbBandeira4.setText(texto);
                break;
        }
    }
    public int iD(String name, int num) {
        String texto = name + num;
        int id = getResources().getIdentifier(texto, "string", getPackageName());

        return id;
    }


    private void reiniciarAtividade() {
        Intent intent = getIntent();
        finish(); // Encerra a atividade atual
        startActivity(intent); // Inicia a atividade novamente
    }
}