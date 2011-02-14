/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.HashAttributeSet;
import javax.swing.JOptionPane;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;

import nu.mumma.lit310.objectsFirst.core.GameEngine;
import nu.mumma.lit310.objectsFirst.core.abstraction.Moveable;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Recyclable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsfirst.start.Start;

/**
 *
 * @author Gustafsp
 */
public class Bin extends Sprite {

    private Class binType = Paper.class;
    private int savedPapper = 0;
    private final ScoreBoard scoreBoard;

    public Bin(int x, int y, ScoreBoard scoreBoard) throws IOException {
        super(x, y);
        this.scoreBoard = scoreBoard;

    }

    @Override
    public void collidedWith(Collideble other) {
        if (!(other instanceof Moveable)) {
            Start.remove(other);
        }
    }

    public void resycle(HashMap<Class, Integer> inBags) {
        if (inBags.containsKey(binType)) {
            int count = inBags.get(binType);
            inBags.put(binType, 0);
            int trees = (count + savedPapper) / 10;
            savedPapper += count - trees * 10;


            while (trees-- > 0) {
                try {
                    scoreBoard.add("Tree.png");

                } catch (IOException ex) {
                    System.out.println("ERROR: Image did not load");
                    System.exit(-1);
                }
            }


        }
    }
}
