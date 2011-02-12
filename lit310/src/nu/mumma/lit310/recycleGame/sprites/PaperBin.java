/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Image;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Bin;
import nu.mumma.lit310.objectsFirst.core.GameEngine;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Recyclable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;

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
