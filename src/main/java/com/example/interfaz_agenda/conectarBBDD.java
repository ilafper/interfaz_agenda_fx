package com.example.interfaz_agenda;
import java.lang.invoke.StringConcatFactory;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class conectarBBDD {

    private static final HttpClient client = HttpClient.newHttpClient();

    // url mongo
    private static final String mongo_get_clientes = "http://localhost:3000/api/clientes"; // Cambia a tu endpoint
    private static final String mongo_post_clientes = "http://localhost:3000/api/crearcliente";
    private  static  final String mongo_delete_cliente= "http://localhost:3000/api/eliminarcliente";



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

    public  static String postClienteMongo(String json) {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(mongo_post_clientes))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al conectar con Mongo API";
        }

    }

    public  static String deleteClienteMongo(String code_user) {
        String urldelete = mongo_delete_cliente + "/"+ code_user;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urldelete))
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al conectar con Mongo API";
        }

    }
}



