package no.floatinggoat.game.view.ui;

import java.awt.Graphics2D;

import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public interface UI {

    /**
     * Method for checking if ui element is clicked. 
     * 
     * @param mousePos  Vector position of the mouse click.
     * @param viewable  Viewable object to check which game state.
     */
    public void checkClick(Vector mousePos, Viewable viewable);

    /**
     * Method for drawing the ui element.
     * 
     * @param g         Graphics2D to draw the element on.
     * @param viewable  Viewable object to check which game state.
     */
    public void draw(Graphics2D g, Viewable viewable);
}
