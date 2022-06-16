package com.example.examenandroidextraordinario.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.examenandroidextraordinario.R;

public class MainActivity extends AppCompatActivity {

    ImageView imageMeterData, imageVerData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageMeterData = findViewById(R.id.imageMeterData);
        imageVerData = findViewById(R.id.imageVerData);
        listeners();
    }


    private void verListado(){
        Intent intent = new Intent(MainActivity.this, ListadoActivity.class);
        startActivity(intent);
    }

    private void verSemana(){
        Intent intent = new Intent(MainActivity.this, SemanaActivity.class);
        startActivity(intent);
    }

    private void listeners(){
        imageMeterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verListado();
            }
        });

        imageVerData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verSemana();
            }
        });
    }

}