package com.example.interfaz_agenda;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Modality;
import javafx.stage.Stage;
import org.kordamp.ikonli.javafx.FontIcon;

public class mongoController implements Initializable {
    @FXML
    private  FlowPane todosClientes;

    @FXML
    private Button crearClienteMongo;


    @FXML
    public void clienteMongoBoton(ActionEvent event) {
        System.out.println("crear cliente mongo bton");

        try {
            Stage stage = (Stage) crearClienteMongo.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/crear_cliente_mongo.fxml")));
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        cargaClientesMongo();


    }

    public void cargaClientesMongo() {
        // al inciar la vista carga todos los clientes
        // limpiar el contenido
        todosClientes.getChildren().clear();
        // todos los cliente de la bbdd
        String json = conectarBBDD.getClientesMongo();

        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        JsonArray lista = obj.getAsJsonArray("lista_clientes");

        todosClientes.setHgap(15);
        todosClientes.setVgap(15);

        for (int i = 0; i < lista.size(); i++) {

            JsonObject cliente = lista.get(i).getAsJsonObject();


            HBox tarjeta = new HBox();
            // añadir clase a
            tarjeta.getStyleClass().add("tarjeta");
            HBox nombreApe = new HBox();
            tarjeta.setAlignment(Pos.CENTER_LEFT);
            tarjeta.setSpacing(15);
            tarjeta.setPrefWidth(680);

            tarjeta.setStyle(
                    "-fx-padding: 12;" +
                            "-fx-background-color: white;" +
                            "-fx-border-color: #131E3F;" +
                            "-fx-border-radius: 12;" +
                            "-fx-background-radius: 12;" +
                            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 10, 0, 0, 2);" +
                            "-fx-border-width: 3;"
            );


            Label nombre = new Label(cliente.get("nombre").getAsString());
            nombre.setStyle(
                    "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #1f2937;"
            );

            Label apellidos = new Label(cliente.get("apellidos").getAsString());

            apellidos.setStyle(
                    "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: #1f2937;"
            );

            nombreApe.getChildren().addAll(nombre, apellidos);
            nombreApe.setSpacing(10);
            VBox info = new VBox(3);

            Label telefono = new Label(cliente.get("telefono").getAsString());
            Label correo = new Label(cliente.get("correo").getAsString());
            Label direccion = new Label(cliente.get("direccion").getAsString());
            telefono.setStyle("-fx-text-fill: #6b7280;");
            correo.setStyle("-fx-text-fill: #6b7280;");


            // toda la targeta junta
            info.getChildren().addAll(nombreApe, telefono, direccion, correo);


            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);


            Button borrarBTN = new Button();
            FontIcon icon = new FontIcon("fas-trash-alt");
            // ver si añado icono al telefono
            //FontIcon tlf = new FontIcon("fas-phone");
            icon.setIconSize(16);

            borrarBTN.setGraphic(icon);
            borrarBTN.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-cursor: hand;"
            );
            borrarBTN.setUserData(cliente.get("code_user").getAsString());

            tarjeta.getChildren().addAll(info, spacer, borrarBTN);


            todosClientes.getChildren().add(tarjeta);

            borrarBTN.setOnAction(e -> {

                Button b = (Button) e.getSource();
                String code_user = (String) b.getUserData();
                System.out.println(code_user);
                // // obtener controller del modal
                //        ModalBorrarController controller = loader.getController();
                //
                //        //  EL DATO
                //        controller.setCodeUser(code_user);
                try {
                    FXMLLoader loader = new FXMLLoader(
                            mongoController.class.getResource("/com/example/modalBorrar.fxml")
                    );

                    Parent root = loader.load();
                    // coger el controllador del modal

                    modalBorrar controller = loader.getController();
                    // pasarlo al controllador del modal
                    controller.setCode_user(code_user);

                    controller.setFuncionMongoController(this);
                    Stage modal = new Stage();
                    modal.setScene(new Scene(root));

                    modal.initModality(Modality.APPLICATION_MODAL);

                    modal.setTitle("Modal Borrar");

                    modal.showAndWait();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            });
        }
    }
}