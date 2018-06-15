package com.game.entity;

import com.game.states.Play;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Player extends Entity {

    private int destinationX;
    private int destinationY;

    private float timer = 0;

    private int direction = 3;


    private Animation down;

    private boolean moving = false;


    private int animationTimer = 250;
    private float animationTweenTimer = (float) animationTimer / 16F;



    private Animation westAnimation;
    private Animation eastAnimation;
    private Animation northAnimation;
    private Animation southAnimation;

    private boolean noMovementPeriod = false;
    private int noMovementPeriodTimer = 0;



    public Player(int x, int y) throws SlickException {
        super(x, y);

//        down = new Animation(new SpriteSheet("res/2.png", 15, 20), 250);

        westAnimation  = new Animation(new SpriteSheet("res/west.png", 16, 20), animationTimer);
        eastAnimation  = new Animation(new SpriteSheet("res/east.png", 16, 20), animationTimer);
        southAnimation = new Animation(new SpriteSheet("res/south.png", 16, 20), animationTimer);
        northAnimation = new Animation(new SpriteSheet("res/north.png", 16, 20), animationTimer);



    }

    public void render(Graphics g) {

        if(moving) {
            if(direction == 0) {
                northAnimation.draw(x, y - 5);
            }else if(direction == 1) {
                eastAnimation.draw(x, y - 5);
            }else if(direction == 2) {
                southAnimation.draw(x, y - 5);
            }else if(direction == 3) {
                westAnimation.draw(x, y - 5);
            }
        }
        else {
            if(direction == 0) {
                northAnimation.getImage(0).draw(x, y - 5);
            }else if(direction == 1) {
                eastAnimation.getImage(0).draw(x, y - 5);
            }else if(direction == 2) {
                southAnimation.getImage(0).draw(x, y - 5);
            }else if(direction == 3) {
                westAnimation.getImage(0).draw(x, y - 5);
            }
        }



    }

    public void update(int delta) {

        if(moving) {

            if(direction == 0) {
                if(y > destinationY) {
                    if(timer >= animationTweenTimer) {
                        y -= 1;
                        timer = 0;
                    }
                }else {
                    timer = 0;
                    moving = false;
                }

                timer += delta;
                northAnimation.update(delta);
            }

            else if(direction == 1) {
                if(x < destinationX) {
                    if(timer >= animationTweenTimer) {
                        x += 1;
                        timer = 0;
                    }
                }else {
                    timer = 0;
                    moving = false;
                }

                timer += delta;
                eastAnimation.update(delta);
            }

            else if(direction == 2) {
                if(y < destinationY) {
                    if(timer >= animationTweenTimer) {
                        y += 1;
                        timer = 0;
                    }
                }else {
                    timer = 0;
                    moving = false;
                }

                timer += delta;
                southAnimation.update(delta);
            }

            else if(direction == 3) {
                if(x > destinationX) {
                    if(timer >= animationTweenTimer) {
                        x -= 1;
                        timer = 0;
                    }
                }else {
                    timer = 0;
                    moving = false;
                }

                timer += delta;
                westAnimation.update(delta);
            }




        }

//        else if(noMovementPeriod) {
//
//            if(noMovementPeriodTimer >= 50) {
//                noMovementPeriodTimer = 0;
//                noMovementPeriod = false;
//            }
//
//            noMovementPeriodTimer += delta;
//
//        }


    }

    public void moveTo(int direction) {
        if(!moving) {
            if(this.direction != direction) {
                this.direction = direction;
//                noMovementPeriod = true;
//                noMovementPeriodTimer = 0;
            }else {
                switch(direction) {
                    case 0:
                        destinationY = y - 16;
                        break;
                    case 1:
                        destinationX = x + 16;
                        break;
                    case 2:
                        destinationY = y + 16;
                        break;
                    case 3:
                        destinationX = x - 16;
                        break;
                }
                moving = true;
            }
        }

//        this.destinationX = destinationX;
//        this.destinationY = destinationY;
    }


}
