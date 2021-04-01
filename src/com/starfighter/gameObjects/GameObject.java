package com.starfighter.gameObjects;

import com.starfighter.main.Handler;
import com.starfighter.main.ID;
import com.starfighter.main.ObjectGraphics;

import java.awt.*;

public abstract class GameObject {

    protected int x,y;
    protected double velX = 0, velY = 0;
    protected ID id;
    protected ObjectGraphics gg;
    protected Handler handler;

    public GameObject(int x, int y, ID id, ObjectGraphics gg) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.gg =gg;
    }

    public GameObject(int x, int y, ID id, ObjectGraphics gg, Handler handler){
        this(x, y, id, gg);
        this.handler = handler;
    }

    public abstract void tick();  // every object needs to update
    public abstract void render(Graphics g); // needs to draw something
    public abstract Rectangle getBounds(); // needs collision detection

    //Accessor Methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
