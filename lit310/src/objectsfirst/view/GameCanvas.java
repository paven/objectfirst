package objectsfirst.view;





import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import objectsfirst.view.Paintable;


/**
 *
 * @author Gustafsp
 */
public class GameCanvas extends Canvas implements Runnable{
    public static final long serialVersionUID = 1L;
        /**
     * al active objectes of the paintable interface shoule be added to this list
     */
    private final static List<Paintable> paintables = new LinkedList<Paintable>();
    
    public GameCanvas() {
        new Thread(this).start();
    }
    @Override
    public void paint(Graphics g){
        //super.paint(g);
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(Paintable paintable: paintables){
           
            g.drawImage(paintable.getImage(), paintable.getX(), paintable.getY(), this);
        }
    
    }

    /**
     * @return the paintables
     */


    public void run() {
        while(true){
            if(this.isShowing()){
                this.paint(this.getGraphics());
            }
        }
    }

    public void add(Paintable paintable) {
        paintables.add(paintable);
    }
}
