package com.game.states;

import com.game.entity.Player;
import com.game.world.World;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

    public static Animation animation;
    private int x = 400;

    private Player player;

    private World world;

    private Input input;

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        input = container.getInput();

        player = new Player(400, 96);

        world = new World();

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setBackground(Color.decode("#6EBF9F"));


        if(input.isKeyDown(Input.KEY_A)) {
            player.moveTo(3);
        }
        else if(input.isKeyDown(Input.KEY_S)) {
            player.moveTo(2);
        }
        else if(input.isKeyDown(Input.KEY_W)) {
            player.moveTo(0);
        }
        else if(input.isKeyDown(Input.KEY_D)) {
            player.moveTo(1);
        }



        world.draw();
        player.render(g);


        if(input.isMouseButtonDown(0)) {
            world.setTile(input.getMouseX(), input.getMouseY(), 1);
        }


    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        player.update(delta);


    }

    public int getID() {
        return 0;
    }

}
