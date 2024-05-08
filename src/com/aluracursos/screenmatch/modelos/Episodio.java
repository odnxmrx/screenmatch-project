package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificable;

public class Episodio implements Clasificable {
    private int numeroEpisodio;
    private String nombreEpisodio;
    private int totalVisualizaciones;

    //relacionar episodio con una serie
    private Serie serie;

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getNombreEpisodio() {
        return nombreEpisodio;
    }

    public void setNombreEpisodio(String nombreEpisodio) {
        this.nombreEpisodio = nombreEpisodio;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClasificacion() {
        //total de rep., a mayor reproducc, mayor valor
        if(totalVisualizaciones > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
