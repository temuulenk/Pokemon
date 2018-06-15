package com;

import com.game.states.Play;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {


    public Main(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Play());
        enterState(0);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Main("Pokemon"));
        app.setDisplayMode(720, 480, false);
//        app.setTargetFrameRate(60);
        app.setShowFPS(true);
        app.start();
    }

}
