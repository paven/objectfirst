/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.objectsFirst.core;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Moveable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;
import nu.mumma.lit310.recycleGame.sprites.Trash;

/**
 *
 * @author Gustafsp
 */
public class GameEngine implements Runnable {

    private long lastLoop = System.currentTimeMillis();
    /**
     * al active objectes of the Positionable interface shoule be added to this list
     */
    private final static List<Positionable> positionables = new LinkedList<Positionable>();
    private  final static List<Positionable> removed = new LinkedList<Positionable>();

    public GameEngine() {
        //new Thread(this).start();
    }
public void add(Positionable positionable) {
        GameEngine.positionables.add(positionable);
    }

    public void clearRemoved(List<Positionable> list) {
        positionables.removeAll(list);
    }

    public void run() {
        
        long delta = System.currentTimeMillis() - lastLoop;
        lastLoop = System.currentTimeMillis();
        makeMoves(delta);
    }
    private void makeMoves(long delta) {
        for (Positionable moveable : positionables) {
            if (moveable instanceof Moveable) {
                ((Moveable) moveable).move(delta);
                if (moveable instanceof Collideble) {
                    collisionCalculations((Collideble) moveable);
                }
            }
        }
    }

    public void collisionCalculations(Collideble collidable) {
        for (Positionable other : positionables) {
            if (other != collidable) {
                if (other instanceof Collideble) {
                    if (((Collideble) other).collidesWith((Collideble) collidable)) {
                        ((Collideble) other).collidedWith((Collideble) collidable);
                        ((Collideble) collidable).collidedWith((Collideble) other);
                    }
                }
            }
        }
    }


}
