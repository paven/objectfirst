/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.objectsFirst.core.abstraction;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gustafsp
 */
public interface Moveable extends Positionable {
    /**
     * al active objectes of the Moveable interface shoule be added to this list
     */
    public final static List<Moveable> moveables = new LinkedList<Moveable>();
    /** delta is in milli seconds
     * @param delta gametime in ms since last call;
     */
    public void move(long delta );

    /**
     * a metohod to let the player move out of an box in one step.
     * to escape for solidobjects on collison;
     * @param other
     */
    public void escape(Rectangle2D.Double other);

}
