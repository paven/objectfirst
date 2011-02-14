/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import nu.mumma.lit310.objectsFirst.core.User;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Direction;
import nu.mumma.lit310.objectsFirst.core.abstraction.Moveable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import nu.mumma.lit310.objectsFirst.core.abstraction.Solid;
import nu.mumma.lit310.objectsfirst.start.Start;

/**
 *
 * @author Gustafsp
 */
public class Player extends Sprite implements Moveable {

    HashMap<Class, Integer> trashCount = new HashMap<Class, Integer>();
    private User user;

    public Player(User user) throws IOException {

        super(100, 100);
        this.user = user;



    }

    public void move(long delta) {

        if (user.getDirection() == Direction.DOWN) {
            moveY(((double) delta) / 10);

        }
        else if(user.getDirection() == Direction.UP) {
            moveY(-((double) delta) / 10);
        }
        else if(user.getDirection() == Direction.RIGHT) {
            moveX(((double) delta) / 10);
        }
        else if(user.getDirection() == Direction.LEFT) {
            moveX(-((double) delta) / 10);
        }
    }

    @Override
    public void collidedWith(Collideble other) {
        if (other instanceof Solid) {
            this.escape(other.getCollisionBox());
        } else if (other instanceof Trash) {
            if (user.getActionKey() == ' ') {
                Class type = ((Trash) other).pickUP();
                countTrash(type);
                Start.remove(other);
            }
        } else if (other instanceof Bin) {
            if (user.getActionKey() == ' ') {
                ((Bin) other).resycle(trashCount);
                this.escape(other.getCollisionBox());
            }
        }
    }

    public void escape(Rectangle2D.Double other) {


        while (collidesWith(other)) {
            double down = other.getMaxY() - this.getCollisionBox().getMinY();
            double up = this.getCollisionBox().getMaxY() - other.getMinY();
            double left = other.getMaxX() - this.getCollisionBox().getMinX();
            double right = this.getCollisionBox().getMaxX() - other.getMinX();
            System.out.println("Down; " + down + " UP: " + up + " LEFT: " + left + " Right " + right);

            if (Math.abs(Math.min(down, up) - Math.min(left, right)) < 2) { //is close to corner
                if (user.getDirection() == Direction.LEFT) {
                    right /= 2;
                } else if (user.getDirection() == Direction.RIGHT) {
                    left /= 2;
                } else if (user.getDirection() == Direction.DOWN) {
                    up /= 2;
                } else if (user.getDirection() == Direction.UP) {
                    down /= 2;
                }
            }
            if (Math.min(down, up) < Math.min(left, right)) { //Less is closer
                if (down < up) {
                    this.moveY(down);
                } else {
                    this.moveY(-up);
                }
            } else {
                if (left < right) {
                    this.moveX(left);
                } else {
                    this.moveX(-right);
                }
            }


        }
    }

    private void countTrash(Class type) {
        if (type != null) {
            int count = 1;
            if (trashCount.containsKey(type)) {
                count = trashCount.get(type) + 1;
            }
            trashCount.put(type, count);
            System.out.println(count);
        }
    }
}
