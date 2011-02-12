/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nu.mumma.lit310.objectsfirst.start;


import java.io.IOException;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Recyclable;
import nu.mumma.lit310.recycleGame.sprites.Player;
import java.awt.Container;
import nu.mumma.lit310.objectsFirst.core.GameEngine;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;
import nu.mumma.lit310.objectsFirst.core.User;
import nu.mumma.lit310.objectsFirst.core.GameCanvas;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;
import nu.mumma.lit310.objectsFirst.recycleGame.abstraction.Bin;
import nu.mumma.lit310.recycleGame.sprites.PaperBin;



/**
 *
 * @author Patrik Gustafsson  at mumma.nu
 */
public class Start {
    
    private GameCanvas gameCanvas = new GameCanvas();
    private GameEngine gameEngine = new GameEngine();

    public Start(Container container) throws IOException{

        User user = new User();


        //gameCanvas.addKeyListener(user);
        Player player = new Player(user);
        container.add(gameCanvas);
        container.validate();
        gameCanvas.requestFocus();
        gameCanvas.addKeyListener(user);
        container.addKeyListener(user);
        add(player);
        buildMap();
        run();
  
    }
    public void add(Positionable positionable){
        gameEngine.add(positionable);
        if(positionable instanceof Paintable){
            gameCanvas.add((Paintable) positionable);
        }
    }

    private void buildMap() {
      //  add(new PaperBin());
        

    }

    private void run() {
        while(true){
            gameEngine.run();
            gameCanvas.run();
        }
    }



}
