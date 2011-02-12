/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Recyclable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;

/**
 *
 * @author Gustafsp
 */
public class Paper implements Recyclable, Paintable {

      private Image image;
   
    private int y = 200;
    private int x = 200;

    public Paper() throws IOException {
        String filepath = "res"+File.separator +"gubbe.png";
        File file = new File(filepath);
        image = ImageIO.read(file);

    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
