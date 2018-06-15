package com.game.world;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class World {

    private int width = 45;
    private int height = 30;

    public int[][] world = new int[height][width];

    private SpriteSheet tiles;

    public World() throws SlickException {
        for(int row=0; row<world.length; row++) {
            for(int col=0; col<world[0].length; col++) {
                world[row][col] = 0;
            }
        }

        tiles = new SpriteSheet("res/tiles.png", 16, 16);

    }

    public void draw() {
        for(int row=0; row<height; row++) {
            for(int col=0; col<width; col++) {
                if(world[row][col] == 0) {
                    tiles.getSubImage(0, 0).draw(col * 16, row * 16);
                }else {
                    tiles.getSubImage(1, 0).draw(col * 16, row * 16);
                }
            }
        }
    }

    public void setTile(int x, int y, int id) {
        world[y / 16][x / 16] = id;
    }

}
