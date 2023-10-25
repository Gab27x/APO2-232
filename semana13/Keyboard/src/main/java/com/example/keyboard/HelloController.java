package com.example.keyboard;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Rectangle rectangle;
    private int posX;
    private int posY;
    private boolean upPressed;
    private boolean downPressed;
    private boolean leftPressed;
    private boolean rightPressed;
    private boolean isAlive;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initActions();
        posX = 50;
        posY = 50;
        graphicsContext = canvas.getGraphicsContext2D();
        rectangle = new Rectangle(posX, posY, 50, 50);
        isAlive = true;

        new Thread(() -> {
            while (isAlive) {
                Platform.runLater(() -> {
                    // Actualizar la posición de los rectángulos
                    updateRec();

                    // Dibujar los rectángulos en el canvas
                    paint();
                });

                try {
                    // Esperar un momento antes de volver a actualizar la posición de los rectángulos
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initActions(){
        canvas.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case UP -> upPressed = true;
                case DOWN -> downPressed = true;
                case LEFT -> leftPressed = true;
                case RIGHT -> rightPressed = true;
            }
        });

        canvas.setOnKeyReleased(keyEvent -> {
            switch (keyEvent.getCode()){
                case UP -> upPressed = false;
                case DOWN -> downPressed = false;
                case LEFT -> leftPressed = false;
                case RIGHT -> rightPressed = false;
            }

        });
    }

    private void updateRec(){
        if(upPressed){
            posY -= 5;
        }
        if (downPressed){
            posY += 5;
        }
        if (leftPressed){
            posX -= 5;
        }
        if (rightPressed){
            posX += 5;
        }
    }

    private void paint(){
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        graphicsContext.setFill(Color.rgb(255, 0, 0));
        graphicsContext.fillRect(posX, posY,
                rectangle.getHeight(), rectangle.getWidth());
    }




}