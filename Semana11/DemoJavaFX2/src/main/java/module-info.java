module com.example.demojavafx2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.demojavafx2 to javafx.fxml;
    exports com.example.demojavafx2;
    exports com.example.demojavafx2.control;
    exports com.example.demojavafx2.model;

    opens com.example.demojavafx2.control to javafx.fxml;
}