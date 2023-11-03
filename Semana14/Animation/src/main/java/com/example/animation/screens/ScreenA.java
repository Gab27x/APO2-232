package com.example.animation.screens;

import com.example.animation.model.Avatar;
import com.example.animation.model.Box;
import com.example.animation.model.IDistance;
import com.example.animation.model.Vector;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class ScreenA  extends  BaseScreen{

    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private Avatar avatar;
    private Box box;

    public ScreenA(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = this.canvas.getGraphicsContext2D();
        this.avatar = new Avatar(this.canvas);
        this.box = new Box(this.canvas);
        this.box.start();
    }

    @Override
    public void paint() {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        avatar.paint();
        box.paint();

        IDistance distanceCalculator = (from, to) -> {
            return Math.sqrt(
                    Math.pow(from.getPosX() - to.getPosX(), 2) +
                            Math.pow(from.getPosY() - to.getPosY(), 2)
            );
        };

        double distance = distanceCalculator.calculateDistance(avatar.getPosition(), box.getPosition());
        System.out.println(distance);

        if(distance < 100){
            double posX = avatar.getPosition().getPosX() - box.getPosition().getPosX();
            double posY = avatar.getPosition().getPosY() - box.getPosition().getPosY();

            Vector diff = new Vector(posX, posY);
            diff.normalize();
            diff.setSpeed(4);

            box.getPosition().setPosX(box.getPosition().getPosX() + diff.getPosX());
            box.getPosition().setPosY(box.getPosition().getPosY() + diff.getPosY());

        }

        if(avatar.getPosition().getPosY() < 20){
            avatar.getPosition().setPosY(20);
        }


    }

    public void setOnKeyPressed(KeyEvent event) {
        avatar.setOnKeyPressed(event);
    }

    public void setOnKeyReleassed(KeyEvent event){
        avatar.setOnKeyReleassed(event);
    }
}
