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
    private List<Paintable> paintables = new LinkedList<Paintable>();
    public GameCanvas() {

    }
    @Override
    public void paint(Graphics g){
        //super.paint(g);
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(Paintable paintable: getPaintables()){
           
            g.drawImage(paintable.getImage(), paintable.getX(), paintable.getY(), this);
        }
        
    }

    /**
     * @return the paintables
     */
    public List<Paintable> getPaintables() {
        return paintables;
    }

    public void run() {
        while(true){

            this.paint(this.getGraphics());
        }
    }
}
