package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Quiz extends AppCompatActivity {

    ImageView imgPlaca;
    TextView txtNQuestao;
    public int indice=1, pontos=0;
    String correto = "placa1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        imgPlaca= findViewById(R.id.imgPlaca);
        txtNQuestao = findViewById(R.id.txtNQuestao);
    }

    public void selected(View v){

    }

    public void botaoProx(View v) {
        if(indice<5){
            indice++;
            txtNQuestao.setText("Questão "+indice+" de 5");

            String image = "img"+indice;
            int id = getResources().getIdentifier(image, "drawable", getPackageName());
            Drawable img = getResources().getDrawable(id);
            imgPlaca.setImageDrawable(img);
        }
    }
}