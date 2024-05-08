package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    //getter
    public String getDirector() {
        return director;
    }

    //setter
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculateMedia() / 2); //es necesario hacer casting del valor (double -> int)
    }
}
