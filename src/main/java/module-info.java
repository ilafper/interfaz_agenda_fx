module com.example.interfaz_agenda {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.interfaz_agenda to javafx.fxml;
    exports com.example.interfaz_agenda;
}