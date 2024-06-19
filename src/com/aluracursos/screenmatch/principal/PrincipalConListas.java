package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalConListas {
    public static void main(String[] args) {

        Pelicula miPelicula = new Pelicula("Interstellar", 2021); //constructor
        miPelicula.evaluate(9);

        Pelicula otraPelicula = new Pelicula("Matrix", 1999); //constructor
        otraPelicula.evaluate(7);

        var peliculaDeBruno = new Pelicula("Lord of the Rings", 2001); //constructor
        peliculaDeBruno.evaluate(7);

        Serie breakingBad = new Serie("Braking Bad", 2018); //constructor
        
        //creando un 'ArrayList' del tipo de dato 'Titulo'
        ArrayList<Titulo> miLista = new ArrayList<>();
        //adding new items to my list
        miLista.add(miPelicula);
        miLista.add(otraPelicula);
        miLista.add(peliculaDeBruno);
        miLista.add(breakingBad);

        //iterando cada item con un forEach
        for(Titulo item:miLista) {
            //'item' nombre dado a cada valor
            //'miLista' el arreglo a iterar
            System.out.println(item.getName());

            //Corrigiendo el error... si 'item' es del tipo 'Pelicula' (y no de 'Titulo')
            if(item instanceof Pelicula peli && peli.getClasificacion() > 3) { //aquí, 'peli' haría el casteo
                //Pelicula peli = (Pelicula) item; //convertir 'item' en tipo 'Pelicula' con casteo
                System.out.println(peli.getClasificacion()); //mostrar clasif
            }
        }
    }
}
