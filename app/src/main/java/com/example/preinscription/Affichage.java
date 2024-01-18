package com.example.preinscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Affichage extends AppCompatActivity {

    private TextView nomsvg;
    private TextView telephoneSvg;
    private TextView naissSvg;
    private TextView paysSvg;
    private  TextView filiereSvg;
    private Button btnSend;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
        nomsvg = findViewById(R.id.nomSvg);
        telephoneSvg = findViewById(R.id.telephoneSvg);
        naissSvg = findViewById(R.id.naissSvg);
        paysSvg = findViewById(R.id.paysSvg);
        filiereSvg = findViewById(R.id.filiereSvg);
        btnSend = findViewById(R.id.btnSend);
        btnRetour = findViewById(R.id.btnRetour);

        nomsvg.setText(getIntent().getStringExtra("nom"));
        telephoneSvg.setText(getIntent().getStringExtra("telephone"));
        naissSvg.setText(getIntent().getStringExtra("naissance"));
        String[] pays = {"Selectionner pays","Comores","Senegal","Gabon"};
        String[] filiere = {"Selectionner filiere","GL","RI","IAG"};
        ArrayAdapter<String> spinnerAdapterPays = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,pays);


        ArrayAdapter<String> spinnerAdapterFiliere = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,filiere);
        paysSvg.setText(getIntent().getStringExtra("pays"));
        filiereSvg.setText(getIntent().getStringExtra("filiere"));
        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Affichage.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}