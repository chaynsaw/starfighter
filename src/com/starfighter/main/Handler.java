package com.starfighter.main;


import com.starfighter.gameObjects.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Handler {

    public List<GameObject> gameObjects = new ArrayList<>();

    private boolean up = false, down = false, right = false, left = false;

    public void tick() {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);

            tempObject.render(g);
        }
    }

    public void addObject (GameObject tempObject){
        gameObjects.add(tempObject);
    }

    public void removeObject(GameObject tempObject){
        gameObjects.remove(tempObject);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}
