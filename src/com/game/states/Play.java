package com.game.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

    private Animation animation;
    private int x = 400;

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        animation = new Animation(new SpriteSheet("res/ash.png", 28, 38), 350);
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.setBackground(Color.decode("#6EBF9F"));
        animation.draw(x, 100);

        if(container.getInput().isKeyDown(Input.KEY_A)) {
            x -= 2;
        }

    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        animation.update(delta);
    }

    public int getID() {
        return 0;
    }

}
