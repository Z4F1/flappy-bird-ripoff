package no.floatinggoat;

import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.transform.Vector;

public class Global {
    public static void gameInit(){
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
    }
}