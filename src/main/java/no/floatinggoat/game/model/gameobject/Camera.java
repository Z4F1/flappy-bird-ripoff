package no.floatinggoat.game.model.gameobject;

import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Camera extends GameObject {

    public Camera(){
        transform = new Transform(new Vector(0, 0), GameModel.gameScreenSize);
    }

    @Override
    public void update(Scene scene) {
        transform.update(scene.getDeltaTime());
    }
}
