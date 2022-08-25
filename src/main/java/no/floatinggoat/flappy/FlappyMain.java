package no.floatinggoat.flappy;

import no.floatinggoat.flappy.model.FlappyModel;
import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.window.GameFrame;
import no.floatinggoat.game.view.window.GameScreen;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyMain {

    private FlappyModel model;
    private GameScreen gameScreen;

    /**
     * Initialises the game.
     * Loads assets, sets screen size, creates the frame and model.
     */
    public FlappyMain(){
        try {
            AssetsLoader.loadTexture("player", "bird.png");
            AssetsLoader.loadTexture("ground", "ground.png");
            AssetsLoader.loadTexture("pillar", "pipe.png");
            AssetsLoader.loadTexture("start screen", "message.png");
            AssetsLoader.loadTexture("background", "background-day.png");
            AssetsLoader.loadTexture("gameover", "gameover.png");
            AssetsLoader.loadTexture("messagebox", "flappy-box.png");
            AssetsLoader.loadTexture("button-scores", "flappy-button-scores.png");
            AssetsLoader.loadTexture("button-submit", "flappy-button-submit.png");
            AssetsLoader.loadTexture("button-restart", "flappy-restart-button.png");

            AssetsLoader.loadFont("default", "game_over.ttf");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        GameModel.gameScreenSize = new Vector(540, 960);
        model = new FlappyModel();

        gameScreen = new GameScreen(model);
        new GameFrame(gameScreen, "Flappy Bird");

        gameScreen.start();
    }
}
