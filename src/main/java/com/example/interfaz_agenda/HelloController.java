package com.example.interfaz_agenda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
public class HelloController {

    @FXML
    private Button vistaMongo;
    @FXML
    private Button vistaSQL;

    // redirigir mongo.
    @FXML
    public void redirigirMongo(ActionEvent event){
        System.out.println("pusla pulsa");
        try {
            Stage stage = (Stage) vistaMongo.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/mongo_home.fxml")));

            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // redirigir a sql
    @FXML
    public void redirigirSQL(ActionEvent event){
        System.out.println("pusla pulsa11222");
        try {
            Stage stage = (Stage) vistaSQL.getScene().getWindow();

            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/sql_home.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
