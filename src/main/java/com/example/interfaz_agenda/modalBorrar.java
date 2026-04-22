package com.example.interfaz_agenda;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class modalBorrar {

    private String code_user;

    private mongoController funcionMongoController;
    @FXML
    private Button noBorrarMon;


    public void setCode_user(String code_user){
        this.code_user=code_user;
    }
    public void  setFuncionMongoController(mongoController funcionMongoController){
        this.funcionMongoController= funcionMongoController;
    }

    @FXML
    private void aceptarBorrarMongo(){
        System.out.println("sisissis");
        System.out.println(code_user);
        conectarBBDD.deleteClienteMongo(code_user);

        funcionMongoController.cargaClientesMongo();
        cerrarModal();
    }
    @FXML
    private void cerrarModal() {
        cerrar();
    }

    private void cerrar() {
        Stage stage = (Stage) noBorrarMon.getScene().getWindow();
        stage.close();
    }
}
