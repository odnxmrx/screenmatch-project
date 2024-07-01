package com.aluracursos.screenmatch.modelos;

//entre paréntesis van los items a guardar
/*
*  Aunque en la API se usan las keys con la 1er letra mayuscula (Title, Year, Runtime)
* NO vale la pena perder (yo) buenas prácitcas de manejar los nombres en minúsculas (camelCase);
* Para esto, aprovechamos el mecanismo de Gson: 'JSON Field Naming Support'
* Permite comprender automáticamente que inician con MAYUS
* */
public record TituloOmdb(String title, String year, String runtime) {
}
