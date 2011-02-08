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
    private int y = 100;
    public Player(User user) {
        this.user = user;
    }

    public int getX() {
        return 100;
    }

    public int getY() {
        return y;
    }

    public void move(int delta) {
        
        if(delta>=0) delta = 1;
        if(delta<50) delta = 50;
        if(user.direction == Direction.DOWN){
            y += delta;
        }
    }



}
