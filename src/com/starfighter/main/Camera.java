package com.starfighter.main;

import com.starfighter.gameObjects.GameObject;

public class Camera {

    private double x, y; // positioning of our camera

    public Camera(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject object) {
        x += ((object.getX() - x) - 1000 / 2.0) * 0.05; // its not completing locked on to the object
        y += ((object.getY() - y) - 563 / 2.0) * 0.05;

        // not allowing camera to go outside of space
        if (x <= 0) x = 0;
        if (x >= 1032) x = 1032;
        if (y <= 0) y = 0;
        if (y >= 563 + 48) y = 563 + 48;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
