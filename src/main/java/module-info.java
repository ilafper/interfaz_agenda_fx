module com.example.interfaz_agenda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;
    requires java.net.http;


    opens com.example.interfaz_agenda to javafx.fxml;
    exports com.example.interfaz_agenda;
}