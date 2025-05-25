package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.exceptions.ErrorConversionOfDurationException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {
    //@SerializedName("Title")
    private String name;
    //@SerializedName("Year")
    private int releaseDate;
    private int durationInMinutes;
    private boolean includedInPlan;

    //calculo de evaluaciones
    private double evaluationSum;
    private int evaluationsTotalCount;

    //constructor de Titulo, para 'name' y 'releaseDate'
    public Titulo(String name, int releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.name = miTituloOmdb.title();
        this.releaseDate = Integer.valueOf(miTituloOmdb.year()); // Year es un String y 'releaseDate' es int

        //creando mi propia excepcion
        if(miTituloOmdb.runtime().contains("N/A")) { //excepcion para 'runtime' que devuelve API con 'N/A'
            throw new ErrorConversionOfDurationException("Unnable to convert duration string N/A to number.");
        }

        this.durationInMinutes = Integer.valueOf(
                miTituloOmdb
                        .runtime() //'runtime' obtiene "000 min" o "00 min"
                        .substring(0, 3) //toma los 1ros 3 valores
                        .replace(" ", "") //dado el caso de obtener "90 ", elimina blank space
        );
    }

    //setters
    public void setName(String name) {
        this.name = name;
        //this.name refiere al atributo "name" de ESTA clase (Pelicula)
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setIncludedInPlan(boolean includedInPlan) {
        this.includedInPlan = includedInPlan;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public int getDurationInMinutes() { //metodo original
        return durationInMinutes;
    }

    public boolean isIncludedInPlan() {
        return includedInPlan;
    }

    //al obtener el valor de algo, convencion es utilizar 'get'
    public int getEvaluationsTotal(){
        return evaluationsTotalCount;
    }


    //creando métodos
    //convención: declarar en imperativo "show/muestra"
    public void showDataSheet() {
        System.out.println("Title name: " + name);
        System.out.println("Its release date is: " + releaseDate);
        System.out.println("Duration in minutes: " + getDurationInMinutes());
    }

    //crear metodo de tipo void
    public void evaluate(double rating){
        //evaluaciones
        evaluationSum += rating;
        evaluationsTotalCount++;
    }

    //metodo de tipo double
    public double calculateMedia(){
        return evaluationSum / evaluationsTotalCount;
    } //no puede estar vacía. Debe retornar algo (a diferencia de 'void')

    //sobrescribiendo el 'compareTo' para comparar solo por 'name'
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getName().compareTo(otroTitulo.getName());
    }

    //sobreescribir el 'toString' para visualizarlo más fácilmente
    @Override
    public String toString() {
        return "(Name='" + name + '\'' +
                ", release year=" + releaseDate +
                ", duration= " +  durationInMinutes + ")";
    }
}
