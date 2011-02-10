/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import java.awt.Point;

/**
 *
 * @author Gustafsp
 */
public interface Collideble extends Positionable{
    void collidesWith(Collideble other);
    void collidedWith(Collideble other);
    boolean checkPixel(Point point);
}
