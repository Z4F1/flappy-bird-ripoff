package no.floatinggoat.game.model;

import no.floatinggoat.game.model.gameobject.GameObjectCollidable;
import no.floatinggoat.game.model.gameobject.Drawable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class Player extends GameObjectCollidable implements Drawable {
    
    @Override
    public void update(Scene scene) {
        transform.update(scene.getDeltaTime());
    }

    @Override
    public int getZIndex(){
        return 10;
    }
}
