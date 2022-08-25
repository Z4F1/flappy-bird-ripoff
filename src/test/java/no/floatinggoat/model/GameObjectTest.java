package no.floatinggoat.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.floatinggoat.Global;
import no.floatinggoat.game.model.gameobject.Camera;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;

public class GameObjectTest {
    
    @Test
    public void transform(){
        Global.gameInit();
        
        Camera cam = new Camera();
        
        assertEquals(new Transform(new Vector(0, 0), new Vector(540, 960)), cam.getTransform());
    }
}