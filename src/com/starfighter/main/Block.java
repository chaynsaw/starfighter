package com.starfighter.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block extends GameObject{

    private BufferedImage blockImage;

    public Block(int x, int y, ID id, ObjectGraphics gg) {
        super(x, y, id, gg);

        blockImage = gg.grabImage(4,1,32,32);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(blockImage,x,y,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
