/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.objectsFirst.core;

import nu.mumma.lit310.objectsFirst.core.abstraction.Direction;
import nu.mumma.lit310.objectsFirst.core.abstraction.UserInput;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Gustafsp
 */
public class User implements UserInput, KeyListener {

    private Direction direction = Direction.STOP;
    private Character thisAction = 'R';
    private Character lastAction = 'R';

    public Direction getDirection() {
        return direction;
    }

    public Character getActionKey() {
        Character lastAction = this.thisAction;
        this.thisAction = 'R';
        return lastAction;
    }

    public void keyTyped(KeyEvent e) {
        thisAction = e.getKeyChar();
        lastAction = e.getKeyChar();
    }

    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction = Direction.LEFT;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direction = Direction.RIGHT;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            direction = Direction.UP;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.STOP;
        }


    }

    public void keyReleased(KeyEvent e) {
        thisAction = 'R';
    }

    public Character getLastActionKey() {
        return lastAction;
    }
}
