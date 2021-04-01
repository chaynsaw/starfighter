package com.starfighter.main;

import com.starfighter.gameObjects.Bullet;
import com.starfighter.gameObjects.GameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MouseInput extends MouseAdapter {

    private Handler handler; // to create bullets
    private Camera camera;
    private Game game;
    private ObjectGraphics gg;
    public List<GameObject> gameObjects;

    public MouseInput(Handler handler, Camera camera, Game game, ObjectGraphics gg) {
        this.handler = handler;
        this.gameObjects = handler.getGameObjects();
        this.camera = camera;
        this.game = game;
        this.gg = gg;
    }

    public void mousePressed(MouseEvent e) {
        int mx = (int) (e.getX() + camera.getX()); //adding to camera
        int my = (int) (e.getY() + camera.getY());

        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject tempObject = gameObjects.get(i);

            if (tempObject.getId() == ID.PLAYER && game.ammo >= 1) {
                handler.addObject(new Bullet(tempObject.getX() + 16, tempObject.getY() + 24, ID.BULLET, handler, mx, my, gg));
                game.ammo--;
            }
        }
    }
}
