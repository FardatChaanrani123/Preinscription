package com.example.preinscription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText telephone;
    private EditText naissance;
    private Spinner spinner;
    private Spinner spinner1;
    private Button btnSave;
    private Button btnAnnuler;
    String recPays;
    String filiere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nom);
        telephone = findViewById(R.id.telephone);
        naissance = findViewById(R.id.naissance);
        spinner = findViewById(R.id.spinner);
        spinner1 = findViewById(R.id.spinner1);
        btnSave = findViewById(R.id.btnSave);
        btnAnnuler = findViewById(R.id.btnAnnuler);

        String[] pays = {"Selectionner pays","Comores","Senegal","Gabon"};
        String[] filiere = {"Selectionner filiere","GL","RI","IAG"};
        ArrayAdapter<String> spinnerAdapterPays = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,pays);
        ArrayAdapter<String> spinnerAdapterFiliere = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,filiere);

        spinnerAdapterPays.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapterFiliere.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapterPays);
        spinner1.setAdapter(spinnerAdapterFiliere);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String recPays = pays[position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String recFiliere = filiere[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomRec = nom.getText().toString();
                String telRec = telephone.getText().toString();
                String naissRec = naissance.getText().toString();
                Intent intent = new Intent(MainActivity.this, Affichage.class);
                intent.putExtra("nom",nomRec);
                intent.putExtra("telephone",telRec);
                intent.putExtra("naissance",naissRec);
                intent.putExtra("pays",recPays);
                intent.putExtra("filiere",filiere);
                String paysRec = (String) spinner.getSelectedItem();
                String filiereRec = (String) spinner1.getSelectedItem();
                startActivity(intent);

            }
        });
        btnAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}