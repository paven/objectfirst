/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.objectsfirst.start;

import java.io.IOException;
import javax.swing.JFrame;
import nu.mumma.lit310.objectsFirst.core.GameCanvas;

/**
 *
 * @author Gustafsp
 */
public class Main extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.start();
        // TODO code application logic here
    }

    private void start() throws IOException {
        this.setSize(400, 500);
        this.setVisible(rootPaneCheckingEnabled);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Start(this);

    }


}
