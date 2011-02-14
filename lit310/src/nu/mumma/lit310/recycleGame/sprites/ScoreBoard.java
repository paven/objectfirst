/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.recycleGame.sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsfirst.start.Start;
import nu.mumma.lit310.recycleGame.sprites.Sprite;

/**
 *
 * @author Gustafsp
 */
public class ScoreBoard extends Sprite {

    public ScoreBoard(int x, int y, int width, int height) throws IOException {
        super(x, y, "Bin.png");
        BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.setImage(buff);
    }



    @Override
    public void collidedWith(Collideble other) {
        Start.remove(other);
    }

    void add(String string) {
        System.out.println("Score");
    }



}
