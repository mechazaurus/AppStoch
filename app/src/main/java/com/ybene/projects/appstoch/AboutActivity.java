package com.ybene.projects.appstoch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AboutActivity extends AppCompatActivity {

    private ImageButton imgbCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Récupération des composants du layout
        imgbCancel = findViewById(R.id.activity_about_cancel_button);

        imgbCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
