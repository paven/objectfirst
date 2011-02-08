/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import java.util.LinkedList;
import java.util.List;
import objectsfirst.view.Paintable;

/**
 *
 * @author Gustafsp
 */
public interface Moveable extends Positionable {
    /**
     * al active objectes of the Moveable interface shoule be added to this list
     */
    public final static List<Moveable> moveables = new LinkedList<Moveable>();
    /** delta is in milli seconds */
    public void move(long delta );

}
