package com.starfighter.main;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);

        //size of the frame
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

        JMenuBar menu = new JMenuBar();
        JMenu ammo = new JMenu("Ammo: " + game.ammo);
        menu.add(ammo);
        frame.setJMenuBar(menu);

    }
}
