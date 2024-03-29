/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.text.Position;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;

/**
 *
 * @author Gustafsp
 */
public abstract class Sprite implements Collideble, Paintable {

    protected String filename = "gubbe.png";
    private BufferedImage image;
    private Rectangle2D.Double collisionBox;
    protected boolean removed;

    public Sprite(double x, double y, String filename) throws IOException {
        this.filename = filename;
        init(x, y);
    }

    public Sprite(double x, double y) throws IOException {
        int lastPoint = this.getClass().toString().lastIndexOf('.');
        this.filename = this.getClass().toString().substring(lastPoint + 1) + ".png";
        init(x, y);
    }

    protected void init(double x, double y) throws IOException {
        image = loadImage(filename);
        collisionBox = new Rectangle2D.Double(x, y, image.getWidth(), image.getHeight());
    }

    protected BufferedImage loadImage(String filename) throws IOException {
        String filepath = "res" + File.separator + filename;
        File file = new File(filepath);
        return ImageIO.read(file);
    }

    /**
     *
     * @param positionables
     * @return
     */
    public boolean collidesWith(Rectangle2D.Double other) {

        return collisionBox.intersects(other);
    }

    public boolean collidesWith(Collideble other) {
        return collidesWith(other.getCollisionBox());
    }

    public Rectangle2D.Double getCollisionBox() {

        return collisionBox;
    }

    public boolean collidesWith(Point point) {
        return collisionBox.contains(point);
    }

    public int getX() {
        return (int) getCollisionBox().getX();
    }

    public int getY() {
        return (int) getCollisionBox().getY();
    }

    public void moveY(double dy) {
        getCollisionBox().y += dy;
    }

    public void moveX(double dx) {
        getCollisionBox().x += dx;
    }

    public Image getImage() {
        return image;
    }

    public abstract void collidedWith(Collideble other);

    /**
     * @param x the x to set
     */
    protected void setX(double x) {
        getCollisionBox().x = x;

    }

    /**
     * @param y the y to set
     */
    protected void setY(double y) {
        getCollisionBox().y = y;
    }

    protected void setImage(BufferedImage buff) {
        image = buff;
        getCollisionBox().setRect(getCollisionBox().getX(), getCollisionBox().getY(), image.getWidth(), image.getHeight());
        System.out.println(this.getClass() + " setImage");
    }
        /**
     * @return the pickedUP
     */
    public boolean isRemoved() {
        return removed;
    }
}
