package com.example.examenandroidextraordinario.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.examenandroidextraordinario.R;
import com.example.examenandroidextraordinario.fragments.VerListadoTotal;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        remplazarFragmentos(new VerListadoTotal());
    }


    // Metodo que reemplaza los fragmentos en el FrameLayout creado
    private void remplazarFragmentos(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragLayout, f);
        ft.commit();
    }
}