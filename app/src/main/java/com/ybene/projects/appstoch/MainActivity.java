package com.ybene.projects.appstoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgbStart, imgbAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération des composants du layout
        imgbStart = findViewById(R.id.activity_main_start_button);
        imgbAbout = findViewById(R.id.activity_main_about);

        // Action à effectuer lors de l'appui sur le bouton démarrer
        imgbStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStoch = new Intent(MainActivity.this, StochActivity.class);
                startActivity(intentStoch);
            }
        });

        // Action à effectuer lors de l'appui sur le bouton "about"
        imgbAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentAbout);
            }
        });
    }
}
