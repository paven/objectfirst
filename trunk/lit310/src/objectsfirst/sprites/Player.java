/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsfirst.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import objectsfirst.controller.*;
import objectsfirst.view.*;

/**
 *
 * @author Gustafsp
 */
public class Player extends Sprite  implements  Moveable {

    private Image image; 
    private User user;
    private double y = 100;
    private double x = 100;

    public Player(User user) throws IOException {

        
        this.user = user;


    }



    public int getX() {
        return (int)x;
    }

    public int getY() {
        return (int)y;
    }

    public void move(long delta) {

        if(delta<=0) {
            delta = 1;
        }
        if(delta>500) {
            delta = 500;
        }
        if(user.getDirection() == Direction.DOWN){
            y += ((double)delta)/10000;

        }
        if(user.getDirection() == Direction.UP)
        {
            y -= ((double)delta)/10000;
        }
        if(user.getDirection() == Direction.RIGHT)
        {
            x += ((double)delta)/10000;
        }
        if(user.getDirection() == Direction.LEFT)
        {
            x -= ((double)delta)/10000;
        }
    }


    public Image getImage() {
        return image;

    }

    public void collidesWith(Collideble other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean checkPixel(Point point) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
