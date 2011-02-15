/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import javax.swing.JFrame;
import nu.mumma.lit310.objectsfirst.start.Start;


/**
 *
 * @author Gustafsp
 */
public class Main extends JFrame{

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.start();
        // TODO code application logic here
    }

    private void start() throws IOException {
        this.setSize(720, 620);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        new Start(this);
        
    }


}
