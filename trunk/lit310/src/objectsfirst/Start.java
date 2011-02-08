/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst;

import objectsfirst.view.Player;
import java.awt.Container;
import objectsfirst.controller.User;
import objectsfirst.view.GameCanvas;



/**
 *
 * @author Gustafsp
 */
public class Start {
    
    private GameCanvas gameCanvas = new GameCanvas();

    public Start(Container container){
        User user = new User();
        container.addKeyListener(user);
        Player player = new Player(user);
        gameCanvas.getPaintables().add(player);
        container.add(gameCanvas);
        
    }

}
