package com.starfighter.gameObjects;

import com.starfighter.main.Handler;
import com.starfighter.main.ID;
import com.starfighter.main.ObjectGraphics;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject{

    Random r = new Random();
    int choose = 0;
    int hp = 100;

    private BufferedImage enemyImage;

    public Enemy(int x, int y, ID id, ObjectGraphics gg, Handler handler) {
        super(x, y, id,gg, handler);

        enemyImage = gg.grabImage(4,1,32,32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        choose = r.nextInt(10);

        for (int i = 0; i < handler.gameObjects.size(); i++){
            GameObject tempObject = handler.gameObjects.get(i);

            if(tempObject.getId() == ID.BLOCK){
                if(getBoundsBig().intersects(tempObject.getBounds())){
                    x += (velX*2) * -1;
                    y += (velY*2) * -1;
                    velX *= -1;
                    velY *= -1;
                } else if (choose == 0) {
                    velX = (r.nextInt(4 - -4) + -4 );
                    velY = (r.nextInt(4 - -4) + -4 );
                }
            }

            if(tempObject.getId() == ID.BULLET){
                if(getBounds().intersects(tempObject.getBounds())) {
                    hp -= 50;
                    handler.removeObject(tempObject);
                }
            }
        }
        if(hp <= 0) handler.removeObject(this);
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(enemyImage,x,y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }

    public Rectangle getBoundsBig(){
        return new Rectangle(x-16,y-16,64,64);
    }
}
