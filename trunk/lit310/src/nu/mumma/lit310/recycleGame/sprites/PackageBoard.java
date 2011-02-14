/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.recycleGame.sprites;

import java.io.IOException;
import java.util.logging.Logger;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;

/**
 *
 * @author Gustafsp
 */
public class PackageBoard extends Sprite{

    public PackageBoard(double x, double y) throws IOException {
        super(x, y, "Paper.png");
    }


    @Override
    public void collidedWith(Collideble other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static final Logger LOG = Logger.getLogger(PackageBoard.class.getName());


}
