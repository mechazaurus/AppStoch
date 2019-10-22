package com.ybene.projects.appstoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ComputeActivity extends AppCompatActivity {

    private TextView tvQ0, tvW, tvWq, tvL, tvLq;

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


    }

    // ===== Informations sur les paramètres =====
    public void onClickQ0(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Probabilité d'avoir aucun client dans le système.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickW(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Temps d'attente global.", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickWq(View v) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Temps d'attente dans la file.", Toast.LENGTH_SHORT);
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
}
