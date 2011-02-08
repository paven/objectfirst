/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Gustafsp
 */
public class User implements userInput, KeyListener{
    Direction direction = Direction.STOP;
    Character lastAction = ' ';

    public Direction getDirection() {
        return direction;
    }

    public Character getActionKey() {
        return lastAction;
    }

    public void keyTyped(KeyEvent e) {
        lastAction = e.getKeyChar();
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
           direction = Direction.LEFT;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
           direction = Direction.RIGHT;
        }
        else if(e.getKeyCode() == KeyEvent.VK_UP){
            direction = Direction.UP;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            direction = Direction.DOWN;
        }
    }

    public void keyReleased(KeyEvent e) {
        direction = Direction.STOP;
    }

}
