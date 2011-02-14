/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import java.io.IOException;
import java.util.HashMap;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Solid;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Recyclable;

/**
 *
 * @author Gustafsp
 */
public abstract class Trash extends Sprite implements Paintable, Recyclable {
  
    
    public Trash(double x, double y) throws IOException {
        super(x, y);
    }

    @Override
    public void collidedWith(Collideble other) {
        if (other instanceof Solid) {
            while (other.collidesWith(this.getCollisionBox())) {
                this.moveY(2);
            }
        }

    }

    public  Class pickUP() {
        if(!removed){

          removed = true;
          return this.getClass();
        }
        return null;
    }


}
