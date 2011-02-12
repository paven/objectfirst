/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import nu.mumma.lit310.objectsFirst.core.User;
import nu.mumma.lit310.objectsFirst.core.abstraction.Direction;
import nu.mumma.lit310.objectsFirst.core.abstraction.Moveable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;



/**
 *
 * @author Gustafsp
 */
public class Player extends Sprite  implements  Moveable {

   
    private User user;


    public Player(User user) throws IOException {

        
        this.user = user;
        setY(100);
        setX(100);


    }




    public void move(long delta) {

        if(delta<=0) {
            delta = 1;
        }
        if(delta>500) {
            delta = 500;
        }
        if(user.getDirection() == Direction.DOWN){
            setY(getY() + ((double)delta)/10000);

        }
        if(user.getDirection() == Direction.UP)
        {
            //y -= ((double)delta)/10000;
        }
        if(user.getDirection() == Direction.RIGHT)
        {
           // x += ((double)delta)/10000;
        }
        if(user.getDirection() == Direction.LEFT)
        {
            //x -= ((double)delta)/10000;
        }
    }




  



}
