package com.starfighter.main;

import java.awt.*;

public abstract class GameObject {

    protected int x,y;
    protected float velX = 0, velY = 0;
    protected ID id;
    protected ObjectGraphics gg;

    public GameObject(int x, int y, ID id, ObjectGraphics gg){
        this.x = x;
        this.y = y;
        this.id = id;
        this.gg =gg;
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

    public float getVelX() {
        return velX;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
