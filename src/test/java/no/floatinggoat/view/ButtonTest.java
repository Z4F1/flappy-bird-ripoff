package no.floatinggoat.view;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;

import org.junit.Test;

import no.floatinggoat.Global;
import no.floatinggoat.flappy.model.FlappyModel;
import no.floatinggoat.flappy.view.ui.FlappyButton;
import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.events.ButtonListener;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Vector;

public class ButtonTest implements ButtonListener {

    boolean clicked = false;
    
    private FlappyButton initiate(GameState layer){
        Global.gameInit();

        return new FlappyButton(
            new Texture("hi", new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB)),
            new Vector(0, 0), new Vector(100, 100),
            layer
        );
    }

    @Override
    public void onClick() {
        clicked = true;
    }

    @Test
    public void initiateButton(){
        initiate(GameState.WELCOME);
    }

    @Test
    public void checkClick(){
        FlappyButton btn = initiate(GameState.WELCOME);

        btn.addListener(this);

        btn.checkClick(new Vector(10, 10), new FlappyModel());

        assertTrue(clicked);
        clicked = false;
    }

    @Test
    public void checkClickWrongLayer(){
        FlappyButton btn = initiate(GameState.GAME);

        btn.addListener(this);

        btn.checkClick(new Vector(10, 10), new FlappyModel());

        assertFalse(clicked);
    }
}