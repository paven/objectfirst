/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Gustafsp
 */
public class GameEngine implements Runnable{
 
    private long lastLoop = System.currentTimeMillis();
    /**
     * al active objectes of the Positionable interface shoule be added to this list
     */
    private final static List<Positionable> positionables = new LinkedList<Positionable>();
    public GameEngine() {
        new Thread(this).start();
    }

    public void run() {
        while(true){
            long delta = System.currentTimeMillis()-lastLoop;;
            lastLoop = System.currentTimeMillis();
            for(Positionable moveable: positionables){
                if(moveable instanceof Moveable){
                    ((Moveable) moveable).move(delta);
                    
                }
            }

        }
    }

    public void add(Positionable positionable) {
        positionables.add(positionable);
    }


}
