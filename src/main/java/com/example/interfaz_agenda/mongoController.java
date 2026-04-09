package com.example.interfaz_agenda;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import javafx.fxml.FXML;

import javax.swing.text.Document;
import java.net.URL;
import java.util.ResourceBundle;


public class mongoController implements Initializable {
     @FXML
     private Pane todosClientes;
    //String datosCliente= conectarBBDD.getClientesMongo();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Se ejecuta al cargar la vista
        String datos = conectarBBDD.getClientesMongo();

        for (int i = 0; i < datos.length(); i++) {
            System.out.println(datos.mensaj);
        }
    }
}
