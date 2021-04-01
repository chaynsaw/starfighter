package com.starfighter.gameObjects;

import com.starfighter.main.Handler;
import com.starfighter.main.ID;
import com.starfighter.main.ObjectGraphics;

import java.awt.*;

public class Bullet extends GameObject {

    private Handler handler;

    public Bullet(int x, int y, ID id, Handler handler, int mx, int my, ObjectGraphics gg) {
        super(x, y, id, gg);
        this.handler = handler;

        velX = (mx -x) / 10;
        velY = (my -y) / 10;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        for(int i = 0; i < handler.gameObjects.size(); i++){
            GameObject tempObject = handler.gameObjects.get(i);

            if(tempObject.getId() == ID.BLOCK){
                if(getBounds().intersects(tempObject.getBounds())){
                    handler.removeObject(this);
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x,y, 8,8);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,8,8);
    }
}
