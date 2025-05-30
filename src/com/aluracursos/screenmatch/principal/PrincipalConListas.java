package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Interstellar", 2021); //constructor
        miPelicula.evaluate(9);

        Pelicula otraPelicula = new Pelicula("Matrix", 1999); //constructor
        otraPelicula.evaluate(7);

        var peliculaDeBruno = new Pelicula("Lord of the Rings", 2001); //constructor
        peliculaDeBruno.evaluate(7);

        Serie breakingBad = new Serie("Braking Bad", 2018); //constructor
        
        // creando un 'ArrayList' del tipo de dato 'Titulo'
        ArrayList<Titulo> miListaDeTitulos = new ArrayList<>();
        //adding new items to my list
        miListaDeTitulos.add(miPelicula);
        miListaDeTitulos.add(otraPelicula);
        miListaDeTitulos.add(peliculaDeBruno);
        miListaDeTitulos.add(breakingBad);

        //iterando cada item con un forEach
        for(Titulo item:miListaDeTitulos) {
            //'item' nombre dado a cada valor
            //'miLista' el arreglo a iterar
            System.out.println(item.getName());

            //Corrigiendo el error... si 'item' es del tipo 'Pelicula' (y no de 'Titulo')
            if(item instanceof Pelicula peli && peli.getClasificacion() > 3) { //aquí, 'peli' haría el casteo
                //Pelicula peli = (Pelicula) item; //convertir 'item' en tipo 'Pelicula' con casteo
                System.out.println(peli.getClasificacion()); //mostrar clasif
            }
        }

        //ordenando datos - Ordenando la lista
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        //List<String> listaDeAmigos = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");

        System.out.println("Lista de Artistas sin ordenar");
        System.out.println(listaDeArtistas);

        //COLLECTIONS
        //paquete de java.lang que permite ordenar
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de Artistas ya ordenada:");
        System.out.println(listaDeArtistas);

        System.out.println("***************************");

        //ahora, comparando titulos de mi lista de peliculas
        Collections.sort(miListaDeTitulos);
        System.out.println("Lista ordenada de titulos: " + miListaDeTitulos);

        //ordenando de otra manera:
        //utilizando método .sort() propio de ArrayList
        miListaDeTitulos.sort(Comparator.comparing(Titulo::getReleaseDate));
        System.out.println("Lista de títulos ordenada por fecha: " +  miListaDeTitulos);

    }
}
