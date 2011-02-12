/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.objectsFirst.core;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.mumma.lit310.objectsFirst.core.abstraction.Moveable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;


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
//            if(delta<10){ //
//                try {
//                    Thread.sleep(10 - delta);
//                } catch (InterruptedException ex) {
//                    break;
//                }
//                delta = System.currentTimeMillis()-lastLoop;
//            }
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
