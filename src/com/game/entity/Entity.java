package com.game.entity;

public class Entity {

    protected int x;
    protected int y;

    protected  int w;
    protected int h;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


}
