
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declarăm butonul și textul afișat pe ecran
    Button butonulMeu;
    TextView textulMeu;

    // Variabile pentru a reține starea dimensiunii și a culorii
    int stareCuloare = 0;
    int stareDimensiune = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Încărcăm interfața grafică a aplicației
        setContentView(R.layout.activity_main);

        // Identificăm elementele din interfața XML
        butonulMeu = findViewById(R.id.button);
        textulMeu = findViewById(R.id.textView);

        // Setăm culoarea inițială a textului
        textulMeu.setTextColor(getResources().getColor(R.color.colorAccent));

        // Setăm dimensiunea inițială a textului
        textulMeu.setTextSize(38);

        // Inițializăm starea culorii și a dimensiunii
        stareCuloare = 0;
        stareDimensiune = 0;

        // Detectăm apăsarea lungă a butonului
        butonulMeu.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        // Dacă textul este în starea inițială,
                        // îi păstrăm dimensiunea de 38
                        if (stareDimensiune == 0) {
                            textulMeu.setTextSize(38);
                            stareDimensiune = 1;
                        } else {
                            // Altfel, micșorăm textul la dimensiunea 20
                            textulMeu.setTextSize(20);
                            stareDimensiune = 0;
                        }

                        // Confirmăm că apăsarea lungă a fost gestionată
                        return true;
                    }
                });

        // Detectăm apăsarea scurtă a butonului
        butonulMeu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Schimbăm culoarea în funcție de dimensiune
                        if (stareDimensiune == 0) {

                            // Aplicăm culoarea mov
                            textulMeu.setTextColor(getResources().getColor(R.color.purple_700));

                            stareCuloare = 1;

                        } else {

                            // Revenim la culoarea inițială
                            textulMeu.setTextColor(getResources().getColor(R.color.colorAccent));

                            stareCuloare = 0;
                        }
                    }
                });
    }
}
