package com.example.bandeiras;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ranking extends AppCompatActivity {

    TextView lblNome, lblAcertos;
    Intent get;
    Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        get = getIntent();

        String nome = get.getStringExtra("nome");
        int pontos = get.getIntExtra("pontos", 0);

        lblNome = findViewById(R.id.lblNome);
        lblAcertos = findViewById(R.id.lblAcertos);
        lblAcertos.setText(String.valueOf(pontos));
        lblNome.setText(nome);
    }

    public void reiniciarAplicacao(View v) {
        Intent intent = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void reiniciar(View v){
        it = new Intent(getApplicationContext(), Quiz.class);
        it.putExtra("nome", lblNome.getText().toString());
        startActivity(it);
    }
}
