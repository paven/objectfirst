/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import objectsfirst.controller.Positionable;
import objectsfirst.controller.User;

/**
 *
 * @author Gustafsp
 */
public class Player implements Moveable{
    private User user;
    private double y = 100;
    private double x = 100;
    public Player(User user) {

        this.user = user;


    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }

    public void move(long delta) {
        
        if(delta<=0) delta = 1;
        if(delta>500) delta = 500;
        if(user.direction == Direction.DOWN){
            y += ((double)delta)/10000;
           
        }
        if(user.direction == Direction.UP)
        {
            y -= ((double)delta)/10000;
        }
        if(user.direction == Direction.RIGHT)
        {
            x += ((double)delta)/10000;
        }
        if(user.direction == Direction.LEFT)
        {
            x -= ((double)delta)/10000;
        }
    }



}
