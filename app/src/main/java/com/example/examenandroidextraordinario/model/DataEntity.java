package com.example.examenandroidextraordinario.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "tabla_datos")
public class DataEntity {

    @PrimaryKey(autoGenerate = true)
    Integer id;
    String dia;
    String hora;
    String modulo;
    String aula;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
}
