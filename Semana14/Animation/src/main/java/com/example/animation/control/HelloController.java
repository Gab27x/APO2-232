package com.example.animation.control;

import com.example.animation.screens.BaseScreen;
import com.example.animation.screens.ScreenA;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private ArrayList<BaseScreen> screens;
    private ScreenA screenA;

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.graphicsContext = canvas.getGraphicsContext2D();
        screenA = new ScreenA(canvas);
        initActions();

        new Thread( ()-> {
            while (true){
                Platform.runLater( () -> {
                    paint();
                });
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } ).start();

    }

    public void paint(){
        screenA.paint();
    }

    public void initActions(){
        canvas.setOnKeyReleased(event -> {
            screenA.setOnKeyReleassed(event);
        });

        canvas.setOnKeyPressed(event -> {
            screenA.setOnKeyPressed(event);
        });
    }

}