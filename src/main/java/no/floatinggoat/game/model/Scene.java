package no.floatinggoat.game.model;

import no.floatinggoat.game.model.gameobject.Camera;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public interface Scene {
    
    /**
     * For getting the current camera.
     * 
     * @return  The camera object.
     */
    public Camera getCamera();

    /**
     * For getting the active player.
     * 
     * @return The player object.
     */
    public Player getPlayer();

    /**
     * For getting the delta time. The delta time is the time between each update.
     * This is because on slower computers the update can take more and therefore
     * move objects slower. This creates away of making it equal.
     * 
     * @return  The last delta time.
     */
    public double getDeltaTime();
}
