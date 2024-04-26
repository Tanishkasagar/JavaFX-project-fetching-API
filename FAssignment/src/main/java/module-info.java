module com.example.fassignment {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.fassignment to javafx.fxml;
    exports com.example.fassignment;
}