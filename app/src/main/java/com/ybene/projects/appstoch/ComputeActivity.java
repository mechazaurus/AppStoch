package com.ybene.projects.appstoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ybene.projects.appstoch.calcul.CalculFile;

public class ComputeActivity extends AppCompatActivity {

    private TextView tvQ0, tvW, tvWq, tvL, tvLq, tvClient, tvSecSys, tvSecFile;
    private EditText etProbClient, etProbSecSys, etProbSecFile;
    private CalculFile calculFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute);

        // Récupération des composants du layout
        tvQ0 = findViewById(R.id.activity_compute_qo);
        tvW = findViewById(R.id.activity_compute_w);
        tvWq = findViewById(R.id.activity_compute_wq);
        tvL = findViewById(R.id.activity_compute_l);
        tvLq = findViewById(R.id.activity_compute_lq);
        tvClient = findViewById(R.id.activity_compute_prob_result);
        tvSecSys = findViewById(R.id.activity_compute_prob_result2);
        tvSecFile = findViewById(R.id.activity_compute_prob_result3);

        etProbClient = findViewById(R.id.compute_activity_number);
        etProbSecSys = findViewById(R.id.compute_activity_number2);
        etProbSecFile = findViewById(R.id.compute_activity_number3);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        calculFile = (CalculFile)bundle.getSerializable("calculFile");

        Double q0 = calculFile.getQ0();
        tvQ0.setText(q0.toString());

        Double w = calculFile.getW();
        tvW.setText(w.toString());

        Double wq = calculFile.getWq();
        tvWq.setText(wq.toString());

        Double l = calculFile.getL();
        tvL.setText(l.toString());

        Double lq = calculFile.getLq();
        tvLq.setText(lq.toString());
    }

    // ===== Informations sur les paramètres =====
    public void onClickQ0(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Probabilité de n'avoir aucun client dans le système.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickW(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Temps moyen passé dans le système.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickWq(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Temps d'attente moyen dans la file.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickL(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Nombre de clients moyen dans le système.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickLq(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Nombre de clients moyen dans la file.", Toast.LENGTH_SHORT);
        toast.show();
    }
    // ===========================================

    public void onClickRecompute(View v) {

        Integer nbClient;
        Double secSys, secFile;



        try {
            nbClient = Integer.valueOf(etProbClient.getText().toString());
        } catch (Exception e) {
            nbClient = null;
        }

        try {
           secSys = Double.valueOf(etProbSecSys.getText().toString());
        } catch (Exception e) {
            secSys = null;
        }

        try {
            secFile = Double.valueOf(etProbSecFile.getText().toString());
        } catch (Exception e) {
            secFile = null;
        }

        if (nbClient != null) {
            Double resultClient = calculFile.getQn(nbClient);
            tvClient.setText(resultClient.toString().substring(0,8));
        }

        if (secSys != null) {
            Double resultSecSys = calculFile.getPsejour(secSys);
            tvSecSys.setText(resultSecSys.toString().substring(0,8));
        }

        if (secFile != null) {
            Double resultSecFile = calculFile.getPattente(secFile);
            tvSecFile.setText(resultSecFile.toString().substring(0,8));
        }
    }
}
