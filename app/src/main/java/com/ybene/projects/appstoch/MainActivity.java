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

        imgbStart = findViewById(R.id.activity_main_start_button);
        imgbAbout = findViewById(R.id.activity_main_about);

        imgbStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStoch = new Intent(MainActivity.this, StochActivity.class);
                startActivity(intentStoch);
            }
        });
    }
}
