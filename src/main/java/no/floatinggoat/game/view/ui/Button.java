package no.floatinggoat.game.view.ui;

import no.floatinggoat.game.events.ButtonListener;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class Button implements UI {

    protected Transform transform;
    protected GameState layer;

    private ButtonListener listener;

    /**
     * Creates a UI button.
     * 
     * @param position  The center position of the button.
     * @param size      The size of the button.
     * @param layer     Which {@link GameState} it is to be drawn.
     */
    public Button(Vector position, Vector size, GameState layer){
        this.transform = new Transform(position, size);
        this.layer = layer;
    }

    @Override
    public void checkClick(Vector mousePos, Viewable viewable){
        float screenScale = viewable.getScale();
        if(viewable.getGameState() == this.layer){
            if(mousePos.x > (transform.getPosition().x - (transform.getSize().x/2)) * screenScale &&
            mousePos.x < (transform.getPosition().x + (transform.getSize().x/2)) * screenScale &&
            mousePos.y > (transform.getPosition().y - (transform.getSize().y/2)) * screenScale &&
            mousePos.y < (transform.getPosition().y + (transform.getSize().y/2)) * screenScale){
                this.listener.onClick();
            }
        }
    }

    /**
     * Adds listener for when the button is clicked.
     * 
     * @param l
     */
    public void addListener(ButtonListener l){
        this.listener = l;
    }
} 
