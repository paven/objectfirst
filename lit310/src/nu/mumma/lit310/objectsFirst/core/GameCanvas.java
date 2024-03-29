package nu.mumma.lit310.objectsFirst.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;
import nu.mumma.lit310.objectsfirst.start.Start;
import nu.mumma.lit310.recycleGame.sprites.Trash;

/**
 *
 * @author Gustafsp
 */
public class GameCanvas extends Canvas implements Runnable {

    public static final long serialVersionUID = 1L;
    /**
     * al active objectes of the paintable interface shoule be added to this list
     */
    private final static List<Paintable> paintables = new LinkedList<Paintable>();
    private BufferStrategy bufferStrategy = null;
    private int targetFPS = 100;
    private int targetmSPF = 1000 / targetFPS;  //miliseconds per frame

    public GameCanvas() {
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Paintable paintable : paintables) {
            if (paintable.getX() > this.getWidth() || paintable.getX() < 0) { //x out of bounds
                System.out.println("OUT");
                Start.remove(paintable);
            } else if (paintable.getY() > this.getHeight() || paintable.getY() < 0) { //y out of bounds
                Start.remove(paintable);
            } else {
                g.drawImage(paintable.getImage(), paintable.getX(), paintable.getY(), null);
            }
        }
    }

    private void bufferStrategyRunOnce() {
        //super.paint(g);
        if (this.bufferStrategy == null) {
            this.createBufferStrategy(2);
            bufferStrategy = this.getBufferStrategy();
        }
    }

    /**
     * @return the paintables
     */
    public void run() {


        long loopStart = System.currentTimeMillis();
        if (this.isShowing()) {
            bufferStrategyRunOnce();
            this.paint(bufferStrategy.getDrawGraphics());
            bufferStrategy.show();
            bufferStrategy.getDrawGraphics().dispose();

        }

    }

    public void add(Paintable paintable) {
        paintables.add(paintable);
    }

    public void clearRemoved(List<Positionable> list) {
        paintables.removeAll(list);
    }
}
