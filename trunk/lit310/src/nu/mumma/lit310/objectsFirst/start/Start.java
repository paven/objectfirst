/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.objectsfirst.start;

import java.io.IOException;

import nu.mumma.lit310.recycleGame.sprites.Player;
import java.awt.Container;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import nu.mumma.lit310.objectsFirst.core.GameEngine;
import nu.mumma.lit310.objectsFirst.core.abstraction.Positionable;
import nu.mumma.lit310.objectsFirst.core.User;
import nu.mumma.lit310.objectsFirst.core.GameCanvas;
import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsFirst.core.abstraction.Paintable;

import nu.mumma.lit310.recycleGame.sprites.*;

/**
 *
 * @author Patrik Gustafsson  at mumma.nu
 */
public class Start {

    private GameCanvas gameCanvas = new GameCanvas();
    private GameEngine gameEngine = new GameEngine();
    private static List<Positionable> removed = new LinkedList<Positionable>();
    private final Container container;
    private final ScoreBoard scoreBoard;

    public static void remove(Positionable remove) {
        removed.add(remove);
    }
    private long lastTrash = System.currentTimeMillis();
    private long difficulty = 1500; //lower is harder
    private User user = new User();

    public Start(Container container) throws IOException {


        this.container = container;

        //gameCanvas.addKeyListener(user);
        Player player = new Player(user);
        container.add(gameCanvas);
        add(player);
        scoreBoard = new ScoreBoard(0, 0, container.getWidth(), 45);
        add(scoreBoard);
        buildMap();
        container.setVisible(true);
        gameCanvas.requestFocus();
        gameCanvas.addKeyListener(user);
        container.addKeyListener(user);
        JOptionPane.showMessageDialog(null,
                "I din stad har folk blivigt tokiga och slänger tidningar för vinden. \n"
                + "Träd skövlas i onödan! \n"
                + "Du inser att du måste återvinna skräpet. \n");
        JOptionPane.showMessageDialog(null, "Du styr med piltangenterna. \n"
                + "Du plockar upp saker med <space>! \n"
                + "På återviningsstationen kan du återvinna skräpet du samlat upp genom att trycka på <space>.");
        run();

    }

    public void add(Positionable positionable) {
        gameEngine.add(positionable);
        if (positionable instanceof Paintable) {
            gameCanvas.add((Paintable) positionable);
        }
        if (positionable instanceof Collideble) {
            gameEngine.collisionCalculations((Collideble) positionable);
        }
    }

    public void remove() {
        gameEngine.clearRemoved(removed);
        gameCanvas.clearRemoved(removed);
    }

    private void buildMap() throws IOException {
        add(new Bin(150, 100, scoreBoard));
        //Borders
        for (int y = 50; y < container.getHeight(); y += 50) {
            add(new House(new Point(0, y)));
        }
        for (int x = 0; x < container.getWidth(); x += 60) {
            add(new GreenHouse(new Point(x, 50)));
        }
        for (int x = 0; x < container.getWidth(); x += 60) {
            add(new House(new Point(x, container.getHeight() - 70)));
        }
        for (int y = 50; y < container.getHeight(); y += 50) {
            add(new GreenHouse(new Point(container.getWidth() - 60, y)));
        }

        //Interior Houses
        for (int x = 400; x < container.getWidth() - 200; x += 50) {
            add(new GreenHouse(new Point(x, 300)));
        }
        for (int y = 100; y < container.getHeight() - 150; y += 50) {
            add(new House(new Point(container.getWidth() - 170, y)));
        }
        for (int y = 150; y < container.getHeight() - 150; y += 50) {
            add(new House(new Point(300, y)));
        }
        for (int y = 150; y < container.getHeight() - 200; y += 50) {
            add(new GreenHouse(new Point(150, y)));
        }
        for (int x = 360; x < container.getWidth() - 250; x += 50) {
            add(new House(new Point(x, 200)));
        }
        for (int i = 0; i < 10; i++) {
            spawnTrash();
        }


    }

    private void run() throws IOException {
        while (true) {
            remove();
            if (user.getLastActionKey() != 'p' && user.getLastActionKey() != 'P') {
                gameEngine.run();
            }
            gameCanvas.run();
            generateTrash();

        }
    }

    private void generateTrash() throws IOException {

        if (lastTrash < System.currentTimeMillis() - difficulty) {
            lastTrash = System.currentTimeMillis();
            spawnTrash();
        }
    }

    private void spawnTrash() throws IOException {
        Paper p = new Paper(new Point((int) (Math.random() * this.container.getWidth()), (int) (Math.random() * this.container.getHeight())));
        add(p);
        gameEngine.collisionCalculations(p);
        //if
    }

}
