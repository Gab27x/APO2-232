package com.example.animation2d;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;

    private GraphicsContext graphicsContext;

    private int rectPosX;
    private boolean isRunning;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rectPosX = 50;
        isRunning = true;
        graphicsContext = canvas.getGraphicsContext2D();

        // Hilo de java
        new Thread(
                // Runnable
                () -> {
                    while (isRunning){
                        Platform.runLater(
                                ()-> {
                                    graphicsContext.setFill(Color.rgb(0, 0, 0));
                                    graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                                    graphicsContext.setFill(Color.rgb(255, 0, 0));
                                    graphicsContext.fillRect(rectPosX, 50, 50, 50);
                                }
                        );
                        rectPosX++;
                        try {
                            Thread.sleep(10);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                }
        ).start();
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}