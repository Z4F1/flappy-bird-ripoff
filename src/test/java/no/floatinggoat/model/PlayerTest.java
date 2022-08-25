package no.floatinggoat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import no.floatinggoat.Global;
import no.floatinggoat.flappy.model.FlappyPlayer;

public class PlayerTest {

    private FlappyPlayer initial(){
        Global.gameInit();
        return new FlappyPlayer();
    }

    @Test
    public void ZIndex(){
        FlappyPlayer player = initial();

        assertEquals(10, player.getZIndex());
    }

    @Test
    public void jump(){
        FlappyPlayer player = initial();

        assertNotEquals(-450, player.getTransform().getVelocity().y);
        player.jump();
        assertEquals(-450, player.getTransform().getVelocity().y, 0);
    }
}
