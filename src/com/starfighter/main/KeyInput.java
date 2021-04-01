package com.starfighter.main;

import com.starfighter.gameObjects.GameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    Handler handler;  // dont create new

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.PLAYER) {
                if (key == KeyEvent.VK_W) handler.setUp(true);
                if (key == KeyEvent.VK_S) handler.setDown(true);
                if (key == KeyEvent.VK_A) handler.setLeft(true);
                if (key == KeyEvent.VK_D) handler.setRight(true);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        // key stroke
        int key = e.getKeyCode();

        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject tempObject = handler.gameObjects.get(i);

            if (tempObject.getId() == ID.PLAYER) {
                if (key == KeyEvent.VK_W) handler.setUp(false);
                if (key == KeyEvent.VK_S) handler.setDown(false);
                if (key == KeyEvent.VK_A) handler.setLeft(false);
                if (key == KeyEvent.VK_D) handler.setRight(false);
            }

        }
    }
}
