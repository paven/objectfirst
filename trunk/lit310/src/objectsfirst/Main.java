/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst;

import javax.swing.JFrame;
import objectsfirst.view.GameCanvas;

/**
 *
 * @author Gustafsp
 */
public class Main extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
        // TODO code application logic here
    }

    private void start() {
        this.setSize(400, 500);
        this.setVisible(rootPaneCheckingEnabled);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Start(this);

    }


}
