package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.exceptions.ErrorConversionOfDurationException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        String clave = "b81b726d";
        Scanner userInput = new Scanner(System.in);

        //create list of movie titles
        List<Titulo> myTitles = new ArrayList<>(); //'List' -> Interface. 'ArrayList' -> Clase

        //Gson myGson = new Gson();
        Gson myGson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // Recibiendo formato en MAYUS desde API
                .setPrettyPrinting() //dar mejor formato a JSON
                .create();

        //Get movie list
        while(true) {

            System.out.println("Enter a movie name: (or type 'exit' to end program) ");
            var newSearch = userInput.nextLine();

            if(newSearch.equalsIgnoreCase("exit")) {
                break;
            }

            //URL to search API
            String searchUrl = "https://www.omdbapi.com/?t=" +
                    newSearch.replace(" ","+") +
                    "&apikey=" + clave;

            try {
                //utilizando la clase HttpRequest
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(searchUrl)) //url a consultar
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(response.body());
                System.out.println(json);

                TituloOmdb miTituloOmdb = myGson.fromJson(json, TituloOmdb.class);

//              System.out.println(miTitulo.getName());
                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                myTitles.add(miTitulo); //add to 'MyTitles' list, single object 'miTitulo' from API

            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error: ");
                System.out.println(e.getMessage());
                //throw new RuntimeException(e);
            } catch (IllegalArgumentException e) {
                System.out.println("Error en URI. Verifique dirección.");
            } catch (ErrorConversionOfDurationException e) {
                System.out.println(e.getMessage()); //imprimimos el error seteado al crear throw new
            } catch (Exception e) { //'Exception' clase madre de todas las excepciones
                //NO es buena práctica tener todas las excepciones englobadas pues perdemos control
                System.out.println("Ocurrió error inesperado.");
            }
        }
        System.out.println("***************************");
        System.out.println(myTitles); //print my Titles

        //guardamos esta lista en un archivo
        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(myGson.toJson(myTitles)); //debemos convertir nuestros titles en un JSON - Usamos 'Gson'
        escritura.close();

        System.out.println("Programa finalizado.");

    }
}
