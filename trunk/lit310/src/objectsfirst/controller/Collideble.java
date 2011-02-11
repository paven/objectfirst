/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Gustafsp
 */
public interface Collideble extends Positionable{
    /**
     
     * @return the area the objects ocupies.
     */
    public Rectangle getCollisionBox();
    public boolean collidesWith(Collideble other);
    public boolean collidesWith(Rectangle other);
    public boolean collidesWith(Point point);
    public void collidedWith(Collideble other);
    
}
