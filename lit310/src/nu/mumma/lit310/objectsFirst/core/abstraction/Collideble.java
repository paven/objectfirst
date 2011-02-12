/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.objectsFirst.core.abstraction;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Gustafsp
 */
public interface Collideble extends Positionable{
    /**
     
     * @return the area the objects ocupies.
     */
    public Rectangle2D.Double getCollisionBox();
    public boolean collidesWith(Collideble other);
    public boolean collidesWith(Rectangle2D.Double other);
    public boolean collidesWith(Point point);
    public void collidedWith(Collideble other);


    
}
