import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

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


    }
}