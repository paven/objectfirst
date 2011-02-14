/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Recyclable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Solid;

/**
 *
 * @author Gustafsp
 */
public class Paper extends Trash {
     private static boolean firstPaperPicked;

    /**
     * @return the firstPaperPicked
     */
    public static boolean isFirstPaperPicked() {
        return firstPaperPicked;
    }

    /**
     * @param aFirstPaperPicked the firstPaperPicked to set
     */
    public static void setFirstPaperPicked(boolean aFirstPaperPicked) {
        firstPaperPicked = aFirstPaperPicked;
    }
   

    public Paper(Point point) throws IOException {
        super(point.getX(), point.getY());

    }



   

}
