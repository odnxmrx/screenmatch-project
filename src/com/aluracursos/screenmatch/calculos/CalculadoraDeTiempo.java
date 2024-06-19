package com.aluracursos.screenmatch.calculos;
import com.aluracursos.screenmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    //ir incluyendo en lista (pelis o series)
    public void incluye(Titulo titulo){
        this.tiempoTotal += titulo.getDurationInMinutes();
    }

}
