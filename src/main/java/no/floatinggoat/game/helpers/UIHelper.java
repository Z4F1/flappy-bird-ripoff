package no.floatinggoat.game.helpers;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class UIHelper {

    /**
     * Helper method for drawing text centered around the given position.
     * 
     * @param g     Is the graphics2D where the text is going to be written on.
     * @param text  The actual text that going to be written.
     * @param font  The font in which the text is written. 
     * @param x     The x position of the text.
     * @param y     the y position of the text.
     */
    public static void drawCenteredText(Graphics2D g, String text, Font font, int x, int y){
        FontMetrics fm = g.getFontMetrics(font);
        x = x - fm.stringWidth(text)/2;
        y = y - fm.getHeight()/2 + fm.getAscent();

        g.setFont(font);
        g.drawString(text, x, y);
    }
}
