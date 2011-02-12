/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objectsfirst;

import java.awt.PopupMenu;
import java.io.IOException;
import objectsfirst.sprites.Player;
import java.awt.Container;
import nu.mumma.lit310.objectsFirst.core.GameEngine;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;
import objectsfirst.controller.User;
import nu.mumma.lit310.objectsFirst.core.GameCanvas;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;



/**
 *
 * @author Patrik Gustafsson  at mumma.nu
 */
public class Start {
    
    private GameCanvas gameCanvas = new GameCanvas();
    private GameEngine gameEngine = new GameEngine();

    public Start(Container container) throws IOException{
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
