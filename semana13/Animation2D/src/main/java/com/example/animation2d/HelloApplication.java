package com.example.animation2d;

import com.example.animation2d.util.Lambdas;
import com.example.animation2d.util.Sum;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        // cierra la ventana -> termina la ejecución del segundo hilo
        stage.setOnCloseRequest(windowEvent -> {
            HelloController controller = fxmlLoader.getController();
            controller.setRunning(false);
        });
        stage.show();
    }

    public static void main(String[] args) {
        // (<Params>) -> {<Executed code>};
        Sum add = (int x, int y) ->{
            System.out.printf("suma");
            return x+y;
        };

        Runnable hello = () -> {
            System.out.printf("Hello from runnable\n");
        };

        hello.run();

        System.out.printf("\n"+ add.sum(5, 6));
        Lambdas l = new Lambdas();
        l.executeSum(4, 7);

        launch();
    }

}



