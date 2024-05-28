package com.aluracursos.screenmatch.modelos;

public class Serie extends Titulo{
    int temporadas;
    int eposodiosPorTemporada;
    int minutosPorEpisodio;

    //constructor que matchea clase madre 'Titulo'
    public Serie(String name, int releaseDate) {
        super(name, releaseDate);
    }

    //getters y setters
    @Override
    public int getDurationInMinutes() {
        return temporadas * eposodiosPorTemporada * minutosPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEposodiosPorTemporada() {
        return eposodiosPorTemporada;
    }

    public void setEposodiosPorTemporada(int eposodiosPorTemporada) {
        this.eposodiosPorTemporada = eposodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }
}
