package no.floatinggoat.game.model.gameobject;

import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.transform.Transform;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class GameObject {
    protected Transform transform;

    /**
     * Gets the transform of the object. Storing position, size, velocity and rotation.
     * 
     * @return  The transform object.
     */
    public Transform getTransform(){
        return transform;
    }

    public abstract void update(Scene scene);
}
