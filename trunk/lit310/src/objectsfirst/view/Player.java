/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objectsfirst.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import objectsfirst.controller.User;

/**
 *
 * @author Gustafsp
 */
public class Player extends objectsfirst.controller.Player implements Paintable {

    private Image image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);

    public Player() {
        super(new User());

        Graphics g = image.getGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
    }

    public Player(User user) {
        super(user);
    }

    public Image getImage() {
        return image;

    }

   
}
