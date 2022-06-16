package com.example.examenandroidextraordinario.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.examenandroidextraordinario.R;
import com.example.examenandroidextraordinario.adapters.AdapterListadoGeneral;
import com.example.examenandroidextraordinario.data.DataRoomDB;
import com.example.examenandroidextraordinario.model.DataEntity;
import com.example.examenandroidextraordinario.util.DiaSeleccionado;

import java.util.ArrayList;
import java.util.List;

public class ListadoEspecifico extends Fragment {

    List<DataEntity> dataEntities;
    DataRoomDB database;
    String diaFiltro;

    RecyclerView recyclerEspecifico;
    AdapterListadoGeneral adapterListadoGeneral;
    LinearLayoutManager llm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = DataRoomDB.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_listado_especifico, container, false);

        diaFiltro = DiaSeleccionado.getInstance().getDia();

        dataEntities = database.dataDao().selectByDay(diaFiltro);

        // ELEMENTOS RECYCLER
        recyclerEspecifico = v.findViewById(R.id.recyclerEspecifico);
        llm = new LinearLayoutManager(getContext());
        recyclerEspecifico.setLayoutManager(llm);
        adapterListadoGeneral = new AdapterListadoGeneral(dataEntities, getActivity());
        recyclerEspecifico.setAdapter(adapterListadoGeneral);


        return v;
    }
}