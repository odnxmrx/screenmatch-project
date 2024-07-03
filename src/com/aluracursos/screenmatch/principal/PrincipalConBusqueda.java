package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.exceptions.ErrorConversionOfDurationException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a movie name: ");
        var newSearch = userInput.nextLine();

        //URL to search API
        String searchUrl = "https://www.omdbapi.com/?t=" +
                newSearch.replace(" ","+") +
                "&apikey=b81b726d";

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

            //Gson myGson = new Gson();
            Gson myGson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb miTituloOmdb = myGson.fromJson(json, TituloOmdb.class);

//        System.out.println(miTitulo.getName());
            System.out.println(miTituloOmdb);

            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("Titulo ya convertido: " + miTitulo);

        } catch (NumberFormatException e) { //siempre se debe incluir el 'catch'
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
        System.out.println("Programa finalizado.");

    }
}
