/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.sprites;

import java.awt.Image;
import objectsfirst.controller.Bin;
import objectsfirst.controller.GameEngine;
import objectsfirst.controller.Recyclable;
import objectsfirst.view.Paintable;

/**
 *
 * @author Gustafsp
 */
public class PaperBin implements Bin, Paintable{
    private Class binType = Paper.class;
    private int savedPapper = 0;


    public void recycle(Recyclable res) {
        if (res.getClass().equals(binType)){
            savedPapper++;
        }
    }

    public Image getImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getX() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getY() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
