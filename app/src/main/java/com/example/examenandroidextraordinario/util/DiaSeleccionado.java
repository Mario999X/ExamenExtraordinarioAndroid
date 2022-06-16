package com.example.examenandroidextraordinario.util;

public class DiaSeleccionado {

    private static DiaSeleccionado diaSeleccionado;

    private DiaSeleccionado(){

    }

    public static DiaSeleccionado getInstance() {
        if (diaSeleccionado == null)
            diaSeleccionado = new DiaSeleccionado();
        return diaSeleccionado;
    }

    private String dia = null;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
