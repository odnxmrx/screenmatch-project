package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendacion {

    //metodo para recomendaciones
    public void filtra(Clasificable clasificacion) { //cualquier producto que tenga una clasificacion
        if(clasificacion.getClasificacion() >= 4) {
            System.out.println("Muy buena evaluación en el momento.");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Popular en el momento.");
        } else {
            System.out.println("Agregalo a tu lista para verlo después.");
        }
    }
}
