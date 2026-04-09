package com.example.interfaz_agenda;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class conectarBBDD {

    private static final HttpClient client = HttpClient.newHttpClient();

    // url mongo
    private static final String mongo_get_clientes = "http://localhost:3000/api/clientes"; // Cambia a tu endpoint

    public static String getClientesMongo() {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(mongo_get_clientes)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al conectar con Mongo API";
        }
    }
}



