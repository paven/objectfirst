/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst;

import java.awt.PopupMenu;
import objectsfirst.sprites.Player;
import java.awt.Container;
import objectsfirst.controller.GameEngine;
import objectsfirst.controller.Positionable;
import objectsfirst.controller.User;
import objectsfirst.view.GameCanvas;
import objectsfirst.view.Paintable;



/**
 *
 * @author Gustafsp
 */
public class Start {
    
    private GameCanvas gameCanvas = new GameCanvas();
    private GameEngine gameEngine = new GameEngine();

    public Start(Container container){
        User user = new User();
        container.addKeyListener(user);
        Player player = new Player(user);
        add(player);
        container.add(gameCanvas);
        container.validate();
    }
    public void add(Positionable positionable){
        gameEngine.add(positionable);
        if(positionable instanceof Paintable){
            gameCanvas.add((Paintable) positionable);
        }
    }

}
