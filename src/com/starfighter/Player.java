package com.starfighter;

import com.apps.util.Prompter;

import java.util.Scanner;

public class Player {

    //FIELDS
    String name;
    int kills = 0;

    //Constructor

    public Player() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        name = prompter.prompt("Enter your Name: ");
    }

    //Getter and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }
}
