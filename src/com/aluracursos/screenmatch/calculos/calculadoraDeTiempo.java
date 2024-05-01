package com.aluracursos.screenmatch.calculos;
import com.aluracursos.screenmatch.modelos.Pelicula;

public class calculadoraDeTiempo {
    private int tiempoTotal;

    //ir incluyendo en lista (pelis o series)
    public void incluye(Pelicula pelicula){
        tiempoTotal += pelicula.getDurationInMinutes();
    }

}
