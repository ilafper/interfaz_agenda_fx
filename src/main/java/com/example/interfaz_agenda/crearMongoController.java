package com.example.interfaz_agenda;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


public class crearMongoController {
    @FXML
    private Button atrasMongo;


    @FXML
    private TextField nombreMongo;

    @FXML
    private TextField apellidosMongo;

    @FXML
    private TextField telefonoMongo;

    @FXML
    private TextField direccionMongo;

    @FXML
    private TextField correoMongo;



    @FXML
    public void atrasMongoBoton(ActionEvent event){
        System.out.println("crear cliente mongo boton");
        try {
            Stage stage = (Stage) atrasMongo.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/mongo_home.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // crear cliente mongo
    @FXML
    private void crearClienteMongo(ActionEvent event) {
        System.out.println("Sisii enviar");
        String nombre = nombreMongo.getText();
        String apellidos = apellidosMongo.getText();
        String telefono = telefonoMongo.getText();
        String direccion = direccionMongo.getText();
        String correo = correoMongo.getText();

        System.out.println(nombre);
        System.out.println(apellidos);
        System.out.println(telefono);
        System.out.println(direccion);
        System.out.println(correo);


        String json = """
    {
        "nombre": "%s",
        "apellidos": "%s",
        "telefono": "%s",
        "direccion": "%s",
        "correo": "%s"
    }
    
    """.formatted(nombre, apellidos, telefono, direccion, correo);
        System.out.println(json);
        conectarBBDD.postClienteMongo(json);
    }
}
