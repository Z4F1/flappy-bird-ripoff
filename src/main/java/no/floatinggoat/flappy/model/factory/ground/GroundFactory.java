package no.floatinggoat.flappy.model.factory.ground;

import no.floatinggoat.flappy.model.factory.Factory;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class GroundFactory extends Factory {

    public GroundFactory() {
        super(new Ground(0), 3, 0, 0);
    }
    
    @Override
    public boolean colliding(GameObjectCollidable other){
        return false;
    }
}

