package com.starfighter.main;

import com.starfighter.gameObjects.Bullet;
import com.starfighter.gameObjects.GameObject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class  MouseInput extends MouseAdapter {

    private Handler handler;
    private Camera camera;
    private Game game;
    private ObjectGraphics gg;

    public MouseInput(Handler handler, Camera camera, Game game, ObjectGraphics gg) {
        this.handler = handler;
        this.camera = camera;
        this.game = game;
        this.gg = gg;
    }

    public void mousePressed (MouseEvent e) {
        int mx = (int) (e.getX() + camera.getX());
        int my = (int) (e.getY() + camera.getY());

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.PLAYER && game.ammo >= 1){
                handler.addObject(new Bullet(tempObject.getX()+16, tempObject.getY()+24, ID.BULLET, handler, mx, my,gg));
                game.ammo --;
            }
        }
    }
}
