/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.controller;

import objectsfirst.view.Paintable;

/**
 *
 * @author Gustafsp
 */
public interface Moveable extends Positionable {
    public void move(int delta );

}
