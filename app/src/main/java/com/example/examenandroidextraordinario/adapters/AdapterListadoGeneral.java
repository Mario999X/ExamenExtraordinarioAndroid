package com.example.examenandroidextraordinario.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenandroidextraordinario.R;
import com.example.examenandroidextraordinario.model.DataEntity;

import java.util.List;

public class AdapterListadoGeneral extends RecyclerView.Adapter<AdapterListadoGeneral.ViewHolder> {

    List<DataEntity> dataEntityList;
    Activity context;

    public AdapterListadoGeneral(List<DataEntity> dataEntityList, Activity context) {
        this.dataEntityList = dataEntityList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterListadoGeneral.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListadoGeneral.ViewHolder holder, int position) {

        DataEntity item = dataEntityList.get(position);

        holder.textViewHora.setText("Hora: " +item.getHora());
        holder.textViewModulo.setText("Módulo: " + item.getModulo());
        holder.textViewAula.setText("Clase: " + item.getAula());

    }

    @Override
    public int getItemCount() {
        return dataEntityList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewHora, textViewModulo, textViewAula;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAula = itemView.findViewById(R.id.textViewAula);
            textViewModulo = itemView.findViewById(R.id.textViewModulo);
            textViewHora = itemView.findViewById(R.id.textViewHora);
        }
    }
}
