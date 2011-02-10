/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst.sprites;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import objectsfirst.controller.Collideble;
import objectsfirst.view.Paintable;

/**
 *
 * @author Gustafsp
 */
public abstract class Sprite implements Collideble, Paintable {
    protected final String filname = "gubbe.png";
    private final BufferedImage image;
    private Rectangle collisionBox = new Rectangle(image., y, width, height);

    public Sprite() throws IOException {
        String filepath = "res"+File.separator + filname;
        File file = new File(filepath);
        image = ImageIO.read(file);
    }

    public void collidedWith(Collideble other) {
        if
    }

}
