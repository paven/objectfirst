/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsfirst.start.Start;

/**
 *
 * @author Gustafsp
 */
public class ScoreBoard extends Sprite {

    private HashMap<String, Integer> resycleCount = new HashMap<String, Integer>();
    private HashMap<String, Image> resycleImage = new HashMap<String, Image>();
    private int nextVerison = 1;
    private int version = 0;

    public ScoreBoard(int x, int y, int width, int height) throws IOException {
        super(x, y, "Bin.png");
        BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.setImage(buff);
        resycleImage.put("Bin.png", loadImage("Bin.png"));
    }

    @Override
    public void collidedWith(Collideble other) {
        Start.remove(other);
    }

    @Override
    public Image getImage() {

        if (nextVerison > version) {
            System.out.println(this.getClass().toString() + " NEW SCORE");
            version= nextVerison;
            Graphics g = super.getImage().getGraphics();
            Color c = new Color(87,165,255) ;

            g.setColor(c);
            g.fillRect(0, 0, (int) this.getCollisionBox().getWidth(), (int) this.getCollisionBox().getHeight());
            g.drawImage(resycleImage.get("Bin.png"), 0, 10, null);

            //Paints the Scores on the scoreBoard
            Object[] types =  resycleCount.keySet().toArray();
            System.out.println(types.length);
            int[] widthAndBorder = {0};
            
            for (int i = 0; i < types.length; i++) {
                System.out.println(types[i]);
                if (resycleCount.containsKey(types[i])) {
                    System.out.println("YES");
                    for (int j = 0; j < resycleCount.get(types[i]) ; j++) {
                        //&& j * widthAndBorder[j] < this.getCollisionBox().getWidth()
                        System.out.println("Yes again");
                        g.drawImage(resycleImage.get(types[i]), 50 + j * widthAndBorder[i], 5, null);
                    }

                }
            }

        }

        return super.getImage();
    }

    void add(String key) throws IOException {
        if (!resycleImage.containsValue(key)) {
            resycleImage.put(key, loadImage(key));
        }
        if (!resycleCount.containsKey(key)) {
            resycleCount.put(key, 1);
        } else {
            resycleCount.put(key, resycleCount.get(key)+1);
        }
        nextVerison++;
        System.out.println(this.getClass() + " "+ key+ ": " + resycleCount.get(key));
    }
}
