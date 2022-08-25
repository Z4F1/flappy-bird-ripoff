package no.floatinggoat.flappy.model.factory;

import no.floatinggoat.game.model.gameobject.Drawable;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class FactoryItem extends GameObjectCollidable implements Drawable{

    /**
     * The copy method for making a new factory item at an x position.
     * 
     * @param x     The x coordinate of the copy.
     * @return      The copied object.
     */
    public abstract FactoryItem copyAt(int x);

    /**
     * Method for getting the width of the factory items.
     * 
     * @return  The width value.
     */
    public abstract int getWidth();
}
