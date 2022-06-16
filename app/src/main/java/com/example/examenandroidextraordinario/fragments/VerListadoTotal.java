package com.example.examenandroidextraordinario.fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.examenandroidextraordinario.R;
import com.example.examenandroidextraordinario.adapters.AdapterListadoGeneral;
import com.example.examenandroidextraordinario.data.DataRoomDB;
import com.example.examenandroidextraordinario.model.DataEntity;

import java.util.List;

public class VerListadoTotal extends Fragment {

    DataRoomDB database;
    List<DataEntity> dataEntities;

    RecyclerView recyclerListadoGeneral;
    AdapterListadoGeneral adapterListadoGeneral;
    LinearLayoutManager llm;

    ImageView imageAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = DataRoomDB.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_ver_listado_total, container, false);

       dataEntities = database.dataDao().getAll();

       // ELEMENTOS REYCLER
        recyclerListadoGeneral = v.findViewById(R.id.recyclerGeneral);
        llm = new LinearLayoutManager(getContext());
        recyclerListadoGeneral.setLayoutManager(llm);
        adapterListadoGeneral = new AdapterListadoGeneral(dataEntities, getActivity());
        recyclerListadoGeneral.setAdapter(adapterListadoGeneral);

        // IMAGE + LISTENER
        imageAdd = v.findViewById(R.id.imageAdd);

        imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CREACION DIALOGO
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_new_data);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

                dialog.show();
                dialog.getWindow().setAttributes(lp);

                // ELEMENTOS DIALOGO
                EditText editextDia = dialog.findViewById(R.id.editextDia);
                EditText editextHora = dialog.findViewById(R.id.editextHora);
                EditText editextModulo = dialog.findViewById(R.id.editextModulo);
                EditText editextAula = dialog.findViewById(R.id.editextAula);
                Button btnAddDialog = dialog.findViewById(R.id.btnAddDialog);

                btnAddDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (editextDia.getText().toString().equals("")){
                            Toast.makeText(getActivity(), "Escriba un DIA válido", Toast.LENGTH_SHORT).show();
                        } else {

                            DataEntity data = new DataEntity();

                            data.setDia(editextDia.getText().toString());
                            data.setHora(editextHora.getText().toString());
                            data.setModulo(editextModulo.getText().toString());
                            data.setAula(editextAula.getText().toString());

                            dialog.dismiss();

                            long resultado = database.dataDao().insert(data);
                            Log.i("insert() = ", "" + resultado); // Comprobacion

                            // LIMPIAMOS LISTA Y ACTUALIZAMOS
                            dataEntities.clear();
                            dataEntities = database.dataDao().getAll();
                            adapterListadoGeneral = new AdapterListadoGeneral(dataEntities, getActivity());
                            recyclerListadoGeneral.setAdapter(adapterListadoGeneral);
                        }
                        }


                });
            }
        });
       return v;
    }
}