package com.example.examenandroidextraordinario.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.examenandroidextraordinario.R;
import com.example.examenandroidextraordinario.fragments.ListadoEspecifico;
import com.example.examenandroidextraordinario.util.DiaSeleccionado;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SemanaActivity extends AppCompatActivity {

    BottomNavigationView bottomView;

    // LOS ELEMENTOS DE LA LISTA ESPECIFICA SE MOSTRARAn SI LOS DIAS ESCRITOS EN LA OTRA ACTIVIDAD SON:
    // Lunes, Martes, Miércoles, Jueves, Viernes
    // EN CUALQUIER CASO SE VERA EN EL LISTADO GENERAL, VISIBLE EN EL RECYCLER DESDE DONDE SE AGREGAN LOS DATOS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana);

        bottomView = findViewById(R.id.bottomView);
        DiaSeleccionado.getInstance().setDia("Lunes");
        remplazarFragmentos(new ListadoEspecifico());
        listenerMenu();
    }

    private void listenerMenu(){
        bottomView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_lunes:
                        DiaSeleccionado.getInstance().setDia("Lunes");
                        remplazarFragmentos(new ListadoEspecifico());
                        break;
                    case R.id.menu_martes:
                        DiaSeleccionado.getInstance().setDia("Martes");
                        remplazarFragmentos(new ListadoEspecifico());
                        break;
                    case R.id.menu_miercoles:
                        DiaSeleccionado.getInstance().setDia("Miércoles");
                        remplazarFragmentos(new ListadoEspecifico());
                        break;
                    case R.id.menu_jueves:
                        DiaSeleccionado.getInstance().setDia("Jueves");
                        remplazarFragmentos(new ListadoEspecifico());
                        break;
                    case R.id.menu_viernes:
                        DiaSeleccionado.getInstance().setDia("Viernes");
                        remplazarFragmentos(new ListadoEspecifico());
                }
                return true;
            }
        });
    }

    // Metodo que reemplaza los fragmentos en el FrameLayout creado
    private void remplazarFragmentos(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragLayout2, f);
        ft.commit();
    }


}