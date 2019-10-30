package com.ybene.projects.appstoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.ybene.projects.appstoch.calcul.CalculFile;
import com.ybene.projects.appstoch.calcul.Unites;

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
                R.array.units_array, R.layout.spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Ajout de la liste aux spinners
        spLambda.setAdapter(adapter);
        spMu.setAdapter(adapter);

        // Action à effectuer lors de l'appui sur le bouton calculer
        ibCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lambda
                Double lambda = Double.valueOf(etLambda.getText().toString());
                String lambdaUnitStr = spLambda.getSelectedItem().toString();
                Unites lambdaUnit = getUnite(lambdaUnitStr);

                // Mu
                Double mu = Double.valueOf(etMu.getText().toString());
                String muUnitStr = spMu.getSelectedItem().toString();
                Unites muUnit = getUnite(muUnitStr);

                // s
                Integer s = Integer.valueOf(etS.getText().toString());

                // K
                Integer k = Integer.valueOf(etK.getText().toString());

                // Créer l'objet et le passer en extra à l'intent
                CalculFile calculFile = new CalculFile(lambda, lambdaUnit, mu, muUnit, s, k);

                Bundle bundle = new Bundle();
                bundle.putSerializable("calculFile", calculFile);

                Intent intent = new Intent(StochActivity.this, ComputeActivity.class);
                intent.putExtras(bundle);
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

    private Unites getUnite(String str) {
        if (str.equals("Par seconde")) {
            return Unites.CPS;
        } else if (str.equals("Par minute")) {
            return Unites.CPM;
        } else if (str.equals("Par heure")) {
            return Unites.CPH;
        } else if (str.equals("Par jour")) {
            return Unites.CPJ;
        } else if (str.equals("Secondes")) {
            return Unites.SECONDES;
        } else if (str.equals("Minutes")) {
            return Unites.MINUTES;
        } else if (str.equals("Heures")) {
            return Unites.HEURES;
        } else if (str.equals("Jours")) {
            return Unites.JOURS;
        }

        return Unites.SECONDES;
    }
}
