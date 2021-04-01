package com.starfighter.gameObjects;

import com.starfighter.main.ID;
import com.starfighter.main.ObjectGraphics;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Crate extends GameObject {

    private BufferedImage ammoCrateImage;

    public Crate(int x, int y, ID id, ObjectGraphics gg) {
        super(x, y, id, gg);

        ammoCrateImage = gg.grabImage(5, 1, 32, 32);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(ammoCrateImage, x, y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
