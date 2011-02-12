/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.sprites;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;

/**
 *
 * @author Gustafsp
 */
public class Sprite implements Collideble, Paintable {
    protected final String filname = "gubbe.png";
    private final BufferedImage image;
    private Rectangle collisionBox;
    private double x;
    private double y;

    public Sprite() throws IOException {
        String filepath = "res"+File.separator + filname;
        File file = new File(filepath);
        image = ImageIO.read(file);
        collisionBox = new Rectangle(this.getX(), this.getY(), image.getWidth(), image.getHeight());
    }


    public boolean collidesWith(Rectangle other){

        return collisionBox.intersects(other);
    }
    public boolean collidesWith(Collideble other){
        return collidesWith(other.getCollisionBox());
    }

    public Rectangle getCollisionBox() {
        return collisionBox;
    }

    public boolean collidesWith(Point point) {
        return collisionBox.contains(point);
    }

    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }

    public Image getImage() {
        return image;
    }

    public void collidedWith(Collideble other) {

    }

    /**
     * @param x the x to set
     */
    protected void setX(double x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    protected void setY(double y) {
        this.y = y;
    }

}
