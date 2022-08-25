package no.floatinggoat.flappy.model.gameobject;

import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.gameobject.Camera;
import no.floatinggoat.game.model.transform.Vector;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyCamera extends Camera {
    public FlappyCamera(){
        transform.setPosition(new Vector(0, 0));
        
        transform.addVelocity(new Vector(150, 0));
    }

    @Override
    public void update(Scene scene){
        super.update(scene);
    }
}
