package no.floatinggoat.game.model.gameobject;

import java.awt.Graphics2D;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public interface Drawable {
    /**
     * Method for drawing the drawable object.
     * 
     * @param g The graphics2d to draw the object on.
     */
    public void draw(Graphics2D g);

    /**
     * Gets the z index of the drawable, determining which object to draw first. Higher number means in front of lower number.
     * 
     * @return Integer index.
     */
    public int getZIndex();
}
