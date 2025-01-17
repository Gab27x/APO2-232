package com.example.animation.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Box extends Thread{

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Vector position;

    private int posY;

    public Box(Canvas canvas){
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.position = new Vector(200, 0);
    }

    public void paint(){
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(position.getPosX(), position.getPosY(), 50, 50);
    }

    @Override
    public void run(){
        while (true){
            position.setPosY(posY);
            posY++;

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Vector getPosition() {
        return position;
    }


}
