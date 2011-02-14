/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Point;
import java.io.IOException;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Moveable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Solid;

/**
 *
 * @author Gustafsp
 */
public class House extends Sprite implements Solid{
    public final static String GREEN = "husg.png";


    public House(Point point) throws IOException {
        super(point.x, point.y);


    }


    @Override
    public void collidedWith(Collideble other) {
        if(other instanceof Moveable){
            ((Moveable)other).escape(this.getCollisionBox());

        }
    }
}
