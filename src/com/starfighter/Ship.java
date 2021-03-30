package com.starfighter;

public enum Ship {
    STARSHIP(Weapon.STAR),ENEMY_SHIP(Weapon.ENEMY);

    private final Weapon weapon;


    public void moveLeft(){

    }

    public void moveRight(){

    }

    public int fire(){
        return weapon.fire();
    }

    Ship(Weapon weapon){
        this.weapon = weapon;
    }
    private enum Weapon {
        STAR{
            int firePower(){
                return FIRE_POWER = 2;
            }
        }, ENEMY{
            int firePower(){
                return FIRE_POWER = 1;
            }
        };

        abstract int firePower();
        private static int FIRE_POWER = 0;

        int fire(){
            return firePower();
        }

    }
}
