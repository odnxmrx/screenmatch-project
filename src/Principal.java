import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //1er 'com.aluracursos.screenmatch.modelos.Pelicula' refiere al tipo de dato.
        //2do 'com.aluracursos.screenmatch.modelos.Pelicula' refiere a crear una nueva instancia (crea espacio en memoria para el obj)
        Pelicula miPelicula = new Pelicula();
        miPelicula.setName("Interstellar");
        miPelicula.setReleaseDate(2021);
        miPelicula.setDurationInMinutes(190);
        miPelicula.setIncludedInPlan(true);

        //obtener a partir de los getters
        System.out.println(miPelicula.getName());
        System.out.println(miPelicula.getReleaseDate());

        //Imprimir ficha tecnica
        miPelicula.showDataSheet();

        //agregando evaluaciones
        miPelicula.evaluate(7.8);
        miPelicula.evaluate(9.2);
        miPelicula.evaluate(7.5);

        System.out.println(miPelicula.getEvaluationsTotal());
        System.out.println(miPelicula.calculateMedia());

        System.out.println("************");

        Serie casaDragon = new Serie();
        casaDragon.setName("La casa del drago");
        casaDragon.setReleaseDate(2022);
        casaDragon.setTemporadas(2);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEposodiosPorTemporada(10);
        casaDragon.showDataSheet();
        System.out.println("duracion es: " + casaDragon.getDurationInMinutes());

        System.out.println("************");

        Pelicula otraPelicula = new Pelicula();
        otraPelicula.setName("Matrix");
        otraPelicula.setReleaseDate(1999);
        otraPelicula.setDurationInMinutes(130);
        otraPelicula.showDataSheet();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);

        calculadora.incluye(otraPelicula);

        //ver el tiempo en pantalla
        System.out.println("Time needed to watch these titles: " + calculadora.getTiempoTotal());


        //Creando filtro
        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula); //Clasificacion Inerstellar

        Episodio episodio = new Episodio();
        episodio.setNumeroEpisodio(1);
        episodio.setNombreEpisodio("La Casa Targaryan");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);


        //Del segundo curso

        var peliculaDeBruno = new Pelicula();
        peliculaDeBruno.setName("Lord of the Rings");
        peliculaDeBruno.setReleaseDate(2001);
        peliculaDeBruno.setDurationInMinutes(180);
        peliculaDeBruno.showDataSheet();

        //creando un 'ArrayList' del tipo de dato 'Pelicula'
        ArrayList<Pelicula> miListaDePeliculas = new ArrayList<>();

        //adding new items to my list
        miListaDePeliculas.add(miPelicula);
        miListaDePeliculas.add(otraPelicula);
        miListaDePeliculas.add(peliculaDeBruno);

        //conocer el tamaño de la lista -> metodo '.size();'
        System.out.println("El tamaño de mi lista es: " +  miListaDePeliculas.size());
        //obtener el primer item -> metodo '.get(int)'
        System.out.println("La 1er pelicula en la lista es: " + miListaDePeliculas.get(0).getName());

        //imprimir la lista completa
        System.out.println(miListaDePeliculas);

        System.out.println("toString de la pelicula" + miListaDePeliculas.get(0).toString());

    }
}