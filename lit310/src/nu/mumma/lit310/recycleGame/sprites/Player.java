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
import javax.imageio.ImageIO;
import nu.mumma.lit310.objectsFirst.core.abstraction.Solid;



/**
 *
 * @author Gustafsp
 */
public class Player extends Sprite  implements  Moveable {

   
    private User user;


    public Player(User user) throws IOException {

        super(100, 100);
        this.user = user;
        


    }




    public void move(long delta) {
        System.out.println(delta);
        if(user.getDirection() == Direction.DOWN){
            moveY(((double)delta)/100);

        }
        if(user.getDirection() == Direction.UP)
        {
            moveY( - ((double)delta)/100);
        }
        if(user.getDirection() == Direction.RIGHT)
        {
           moveX(((double)delta)/100);
        }
        if(user.getDirection() == Direction.LEFT)
        {
            moveX(- ((double)delta)/100);
        }
    }

    @Override
    public void collidedWith(Collideble other) {
        if(other instanceof Solid){
            this.escape(other.getCollisionBox());
        }
    }

    public void escape(Rectangle2D.Double other) {

        while(collidesWith(other)){
            if(other.getCenterX() < this.getCollisionBox().getCenterX()){
                this.moveX(1);
            }
            else if(other.getCenterX() > this.getCollisionBox().getCenterX())
            {
                this.moveX(-1);
            }
        }
    }




  



}
