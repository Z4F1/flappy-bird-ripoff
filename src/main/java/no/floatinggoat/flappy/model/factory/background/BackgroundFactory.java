package no.floatinggoat.flappy.model.factory.background;

import no.floatinggoat.flappy.model.factory.Factory;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class BackgroundFactory extends Factory {

    public BackgroundFactory() {
        super(new Background(0), 4, 0, 0);
    }
    
    @Override
    public boolean colliding(GameObjectCollidable other){
        return false;
    }
}
