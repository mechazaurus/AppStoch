package com.ybene.projects.appstoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class StochActivity extends AppCompatActivity {

    private EditText etLambda, etMu, etS, etK;
    private ImageButton ibCompute;
    private Spinner spLambda, spMu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoch);

        // Récupération des composants du layout
        etLambda = findViewById(R.id.activity_stoch_lambda);
        etMu = findViewById(R.id.activity_stoch_mu);
        etS = findViewById(R.id.activity_stoch_s);
        etK = findViewById(R.id.activity_stoch_K);
        ibCompute = findViewById(R.id.activity_stoch_compute_compute);
        spLambda = findViewById(R.id.activity_stoch_lambda_spinner);
        spMu = findViewById(R.id.activity_stoch_mu_spinner);

        // Création de la liste des champs du spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Ajout de la liste aux spinners
        spLambda.setAdapter(adapter);
        spMu.setAdapter(adapter);

        // Action à effectuer lors de l'appui sur le bouton calculer
        ibCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO
                // Créer l'objet et le passer en extra à l'intent

                Intent intent = new Intent(StochActivity.this, ComputeActivity.class);
                startActivity(intent);
            }
        });
    }

    // ===== Informations sur les paramètres =====
    public void onClickLambda(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Rythme d'arrivée des clients.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickMu(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Rythme de service", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickS(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Nombre de serveurs.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickK(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Nombre de clients.", Toast.LENGTH_SHORT);
        toast.show();
    }
    // ===========================================
}
