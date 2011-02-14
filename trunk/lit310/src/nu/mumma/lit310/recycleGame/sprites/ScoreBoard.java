/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.mumma.lit310.recycleGame.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

import nu.mumma.lit310.objectsFirst.core.abstraction.Collideble;
import nu.mumma.lit310.objectsfirst.start.Start;

/**
 *
 * @author Gustafsp
 */
public class ScoreBoard extends Sprite {

    List<String> messages = new LinkedList<String>();
    private HashMap<String, Integer> resycleCount = new HashMap<String, Integer>();
    private HashMap<String, Image> resycleImage = new HashMap<String, Image>();
    private int nextVerison = 1;
    private int version = 0;

    public ScoreBoard(int x, int y, int width, int height) throws IOException {
        super(x, y, "Bin.png");
        BufferedImage buff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.setImage(buff);
        resycleImage.put("Bin.png", loadImage("Bin.png"));
        initMessages();
    }

    @Override
    public void collidedWith(Collideble other) {
        Start.remove(other);
    }

    @Override
    public Image getImage() {

        if (nextVerison > version) {
            System.out.println(this.getClass().toString() + " NEW SCORE");
            version = nextVerison;
            Graphics g = super.getImage().getGraphics();
            Color c = new Color(87, 165, 255);

            g.setColor(c);
            g.fillRect(0, 0, (int) this.getCollisionBox().getWidth(), (int) this.getCollisionBox().getHeight());
            g.drawImage(resycleImage.get("Bin.png"), 0, 10, null);

            //Paints the Scores on the scoreBoard
            Object[] types = resycleCount.keySet().toArray();

            int[] widthAndBorder = {30};
            int offset = 40;
            for (int i = 0; i < types.length; i++) {
                System.out.println(types[i]);
                if (resycleCount.containsKey(types[i])) {

                    for (int j = 0; j < resycleCount.get(types[i]); j++) {


                        g.drawImage(resycleImage.get(types[i]), offset, 5, null);
                        offset += widthAndBorder[i];
                        if (offset > this.getCollisionBox().getWidth()) {
                            offset = 35;
                        }
                    }

                }
            }

        }

        return super.getImage();
    }

    void add(String key) throws IOException {

        if (!resycleImage.containsValue(key)) {
            resycleImage.put(key, loadImage(key));
        }
        if (!resycleCount.containsKey(key)) {
            resycleCount.put(key, 1);
        } else {
            resycleCount.put(key, resycleCount.get(key) + 1);
        }
        nextVerison++;
        message();
        System.out.println(this.getClass() + " " + key + ": " + resycleCount.get(key));


    }

    private void initMessages() {
        String[] tempMessages = {
            "Visste du att metall är det mest lönsamma att återvinna? Återvinning av aluminium sparar upp till 95% av energin som krävs vid nytillverkning.",
            "Det mesta av återvunnet papper används till att tillverka tidningar.",
            "Innan återvinning kan man testa att återanvända sakerna! Omslagspapper går till exempel att använda flera gånger, och tidningspapper kan bli dekorationer.",
            "Redan Platon talade sig varm för återvinning. Under hårda tider med mindre resurser, visar arkeologiska fynd på att människor använde sig av mer återvinning.",
            "Luftföroreningarna från papperstillverkning kan minska med upp till 73% genom återvinning!",
            "Om den globala konsumtionen av en råvara stiger med mer än 1% per år, är det oundvikligt att råvaran uttöms. Återvinning kan försena detta.",
            "Sparar återvinning träd? Den största delen av papperstillverkningen sker av planterad skog — återvinning kan i själva verket då leda till färre planterade skogar och därmed färre träd! De planterade skogarna är dock inte lika bra som naturliga skogar ur miljösynpunkt.",
            "Det bästa sättet att få fler att återvinna är genom personlig kontakt — människor övertalas lättare av någon de känner än av ett papper med information.",
            "Visste du att Sverige är världsledande på insamling av elavfall? Detta kan bero på att ett producentansvar infördes 2001.",
            "En aluminiumburk som blir kvar i naturen tar 300 år att försvinna. Den kan annars återvinnas till 100%.",
            "Tänk på de tre Å:na: Återhållsamhet, Återanvänd, Återvinn.",
            "I Sverige skapar varje medborgare ungefär 480 kilo sopor per år. Det är en minskning med 5% från året innan."
        };
        messages.addAll(Arrays.asList(tempMessages));
    }

    private void message() {
        String message = "Du är en sann hjälte, som räddat så många träd!";
        if (version == 1) {
            message = "Ett träd kan användas till 1000 tidningar. \n Varje tidningshög innehåller 100 tidningar. \n du behöver alltså 10 tidningshögar för att rädda ett Träd";
        } else if (messages.size() > 0) {
            int random = (int) (Math.random() * (messages.size() - 1));
            message = messages.get(random);
            messages.remove(random);
        }

        JOptionPane.showMessageDialog(null, message);




    }
}
