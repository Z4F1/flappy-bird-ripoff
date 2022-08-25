package no.floatinggoat.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;

import org.junit.Test;

import no.floatinggoat.Global;
import no.floatinggoat.flappy.model.FlappyModel;
import no.floatinggoat.flappy.model.FlappyPlayer;
import no.floatinggoat.flappy.model.factory.pillar.Pillar;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.Player;
import no.floatinggoat.game.model.gameobject.Camera;
import no.floatinggoat.game.model.transform.Vector;

public class GameModelTest {
    private FlappyModel initial(){
        Global.gameInit();
        return new FlappyModel();
    }

    @Test
    public void gameState(){
        FlappyModel model = initial();

        assertEquals(GameState.WELCOME, model.getGameState());
    }

    @Test
    public void camera(){
        FlappyModel model = initial();

        assertTrue(model.getCamera() instanceof Camera);
    }

    @Test
    public void player(){
        FlappyModel model = initial();

        assertTrue(model.getPlayer() instanceof Player);
    }

    @Test
    public void deltaTime(){
        FlappyModel model = initial();

        assertTrue(0 == model.getDeltaTime());
    }

    @Test
    public void updateFunctionality() throws InterruptedException {
        // This also tests Player class's update method.
        FlappyModel model = initial();
        
        model.onMouseClick(new Vector(100, 100));

        assertTrue(150 == model.getPlayer().getTransform().getPosition().x);

        model.update();
        model.update();

        assertTrue(150 != model.getPlayer().getTransform().getPosition().x);
    }
    @Test
    public void onMouseClick(){
        FlappyModel model = initial();

        assertEquals(GameState.WELCOME, model.getGameState());

        model.onMouseClick(new Vector(100, 100));

        assertEquals(GameState.GAME, model.getGameState());
    }

    @Test
    public void onKeyClick(){
        FlappyModel model = initial();

        assertEquals(GameState.WELCOME, model.getGameState());

        model.onKeyClick(KeyEvent.VK_SPACE);

        assertEquals(GameState.GAME, model.getGameState());
    }

    @Test
    public void collider(){
        FlappyModel model = initial();

        model.onKeyClick(KeyEvent.VK_SPACE);
        
        model.add(new Pillar(new Vector(120, GameModel.gameScreenSize.y/2 - 20)));

        model.update();

        assertEquals(GameState.GAME_OVER, model.getGameState());
    }

    @Test
    public void removeGameObjects(){
        FlappyModel model = initial();

        assertNotEquals(0, model.getUIElements().size());
        assertNotEquals(0, model.getDrawables().size());

        model.removeAllGameObjects();

        assertEquals(0, model.getDrawables().size());

        assertNotEquals(0, model.getUIElements().size());
    }

    @Test
    public void addGameObject(){
        FlappyModel model = initial();

        model.removeAllGameObjects();

        assertEquals(0, model.getDrawables().size());

        model.add(new FlappyPlayer());

        assertNotEquals(0, model.getDrawables().size());
        assertEquals(1, model.getDrawables().size());
    }
}