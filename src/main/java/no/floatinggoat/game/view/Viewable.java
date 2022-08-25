package no.floatinggoat.game.view;

import java.util.List;

import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.gameobject.Camera;
import no.floatinggoat.game.model.gameobject.Drawable;
import no.floatinggoat.game.view.ui.UI;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public interface Viewable {

    /**
     * Method for returning all the UI Elements, when for example drawing.
     * 
     * @return  List with UI Elements.
     */
    public List<UI> getUIElements();

    /**
     * Method for returning all the drawable game objects, used for drawing.
     * 
     * @return  List with all the drawable game objects.
     */
    public List<Drawable> getDrawables();

    /**
     * Method for returning the active camera.
     * 
     * @return  The active camera.
     */
    public Camera getCamera();

    /**
     * Method for getting the current game state.
     * 
     * @return  The current game state.
     */
    public GameState getGameState();

    /**
     * Called when screen is resized. The scale is calculated based on width and height
     * for maintaining the highest resolution for that window. Also keeps the aspect ratio.
     * 
     * @param scale     Is the new scale.
     */
    public void updateScale(float scale);

    /**
     * Method for returning the scale. Used when drawing gameobjects and ui.
     * 
     * @return  The scale for that window size.
     */
    public float getScale();
}

