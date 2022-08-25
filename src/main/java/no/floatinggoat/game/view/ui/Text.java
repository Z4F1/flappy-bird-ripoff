package no.floatinggoat.game.view.ui;

import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class Text implements UI {

    protected String text;
    protected float size;

    protected Transform transform;
    protected GameState layer;
    
    /**
     * Creates text ui element
     * 
     * @param text      The text to be drawn.
     * @param size      The font size.
     * @param position  The center position of the text.
     * @param layer     Which {@link GameState} to draw the image
     */
    public Text(String text, float size, Vector position, GameState layer){
        this.text = text;
        this.size = size;
        this.transform = new Transform(position, Vector.zero);
        this.layer = layer;
    }

    @Override
    public void checkClick(Vector mousePos, Viewable viewable) {}

    /**
     * Method for updating the text after creation.
     * 
     * @param text  The new text string.
     */
    public void updateText(String text){
        this.text = text;
    }
}
