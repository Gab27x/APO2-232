module com.example.animation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animation to javafx.fxml;
    exports com.example.animation;
    exports com.example.animation.control;
    opens com.example.animation.control to javafx.fxml;
}