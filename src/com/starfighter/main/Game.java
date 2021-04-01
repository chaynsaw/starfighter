package com.starfighter.main;

import com.starfighter.gameObjects.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

    //Fields
    private boolean isRunning = false;
    private Thread thread;
    protected final Handler handler;
    protected final Camera camera;
    protected final ObjectGraphics gg;

    private BufferedImage level = null;
    private BufferedImage graphics = null;
    private BufferedImage space = null;

    public int ammo = 100;

    //constructor
    public Game(){
        new Window(1000,563,"StarFighter", this); //size
        start();

        handler = new Handler();
        camera = new Camera(0,0);
        this.addKeyListener(new KeyInput(handler));


        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("/StarShipWorld.png");
        graphics = loader. loadImage("/textures.png");

        gg = new ObjectGraphics(graphics);

        space = gg.grabImage(2,1,64,64);

        this.addMouseListener(new MouseInput(handler,camera, this, gg));
        loadLevel(level);
    }


    // Runnable
    private void start(){
        isRunning = true;
        thread = new Thread(this); // we are calling this class run method
        thread.start();
    }
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // CREDITS:Markus Alexej Persson AKA Notch developer of Minecraft
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >=1){
                tick();
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void tick(){

        for(int i = 0; i < handler.object.size(); i++){
            if(handler.object.get(i).getId() == ID.PLAYER){
                camera.tick(handler.object.get(i));
            }
        }

        handler.tick();
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        ////////////////////////////////
        g.setColor(Color.gray);
        g.fillRect(0,0,getWidth(),getHeight());

        g2d.translate(-camera.getX(), -camera.getY());

        for(int xx = 0; xx < 30*72; xx+=64){
            for(int yy = 0; yy < 30*72; yy+=64){
                g.drawImage(space,xx,yy,null);
            }
        }

        handler.render(g);

        g2d.translate(-camera.getX(), -camera.getY());

        g.setColor(Color.white);
        g.drawString("Ammo: " + ammo, 5, 20);

        /////////////////////////////////
        g.dispose();
        bs.show();
    }

    // loading the level
    private void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16 ) & 0xff;
                int green = (pixel >> 8 ) & 0xff;
                int blue = (pixel) & 0xff;

                if(red == 255)
                    handler.addObject(new Block(xx*32, yy*32, ID.BLOCK, gg));

                if(blue == 255 && green == 0)
                    handler.addObject(new StarShip(xx*32, yy*32, ID.PLAYER, handler, this, gg));

                if(green == 255 && blue == 0)
                    handler.addObject(new Enemy(xx*32, yy*32, ID.ENEMY, gg,  handler));

                if(green == 255 && blue == 255)
                    handler.addObject(new Crate(xx*32, yy*32, ID.CRATE, gg));
            }
        }
    }
}
