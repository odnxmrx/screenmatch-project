package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

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
        String searchUrl = "https://www.omdbapi.com/?t=" + newSearch + "&apikey=b81b726d";

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

        Gson myGson = new Gson();
        Titulo miTitulo = myGson.fromJson(json, Titulo.class);

//        System.out.println(miTitulo.getName());
        System.out.println(miTitulo);

    }
}
