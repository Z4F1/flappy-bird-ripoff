package no.floatinggoat.flappy.model;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import no.floatinggoat.flappy.model.factory.background.BackgroundFactory;
import no.floatinggoat.flappy.model.factory.ground.GroundFactory;
import no.floatinggoat.flappy.model.factory.pillar.BothPillarFactory;
import no.floatinggoat.flappy.model.gameobject.FlappyCamera;
import no.floatinggoat.flappy.view.score.ScoreSubmitFrame;
import no.floatinggoat.flappy.view.ui.FlappyButton;
import no.floatinggoat.flappy.view.ui.FlappyText;
import no.floatinggoat.flappy.view.ui.FlappyTextBox;
import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.events.ButtonListener;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.Player;
import no.floatinggoat.game.model.gameobject.GameObject;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.ui.Image;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyModel extends GameModel  {
    protected BothPillarFactory pillarFactory;

    private FlappyText scoreCounter;
    private FlappyTextBox scoreBox;

    public FlappyModel(){
        initialiseGameElements();

        initialiseUIElements();
    }
    
    /**
     * Helper method for initialising game object/elements
     */
    private void initialiseGameElements(){
        this.gameState = GameState.WELCOME;

        this.player = new FlappyPlayer();
        this.camera = new FlappyCamera();

        this.initiate();

        pillarFactory = new BothPillarFactory();

        add(pillarFactory);
        add(new GroundFactory());
        add(new BackgroundFactory());

    }

    /**
     * Helper method for initialising ui elements
     */
    private void initialiseUIElements(){
        //WELCOME:
        FlappyButton startButton = new FlappyButton(AssetsLoader.getTexture("start screen"), gameScreenSize.multiply(0.5), gameScreenSize, GameState.WELCOME);

        startButton.addListener(new ButtonListener() {

            @Override
            public void onClick() {
                startGame();
            }
            
        });

        add(startButton);

        //GAME:
        scoreCounter = new FlappyText(String.valueOf(pillarFactory.getScore()), 256f, new Vector(gameScreenSize.x/2, 150), AssetsLoader.getFont("default"), GameState.GAME);
        add(scoreCounter);

        //RESULT SCREEN:
        add(new Image(AssetsLoader.getTexture("gameover"), new Vector(gameScreenSize.x/2, 150), new Vector(530, 100), GameState.RESULT));

        scoreBox = new FlappyTextBox("SCORE: " + String.valueOf(pillarFactory.getScore()), 128, new Vector(gameScreenSize.x/2, 400), AssetsLoader.getFont("default"), GameState.RESULT);
        add(scoreBox);

        FlappyButton restartButton = new FlappyButton(AssetsLoader.getTexture("button-restart"), new Vector(gameScreenSize.x/2, 600), new Vector(384, 96), GameState.RESULT);

        restartButton.addListener(new ButtonListener() {

            @Override
            public void onClick() {
                restartGame();
            }
            
        });

        add(restartButton);

        FlappyButton submitScoreButton = new FlappyButton(AssetsLoader.getTexture("button-submit"), new Vector(gameScreenSize.x/2 - 98, 700), new Vector(190, 95), GameState.RESULT);
        submitScoreButton.addListener(new ButtonListener() {

            @Override
            public void onClick() {
                new ScoreSubmitFrame(pillarFactory.getScore());
            }
            
        });

        add(submitScoreButton);

        FlappyButton scoresButton = new FlappyButton(AssetsLoader.getTexture("button-scores"), new Vector(gameScreenSize.x/2 + 98, 700), new Vector(190, 95), GameState.RESULT);
        scoresButton.addListener(new ButtonListener() {

            @Override
            public void onClick() {
                try {
                    java.awt.Desktop.getDesktop().browse(new URI("https://flappy.floatinggoat.no"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
            
        });

        add(scoresButton);
    }

    /**
     * Helper method for starting the game.
     */
    private void startGame(){
        gameState = GameState.GAME;
    }

    /**
     * Helper method for restarting the game.
     */
    private void restartGame(){
        removeAllGameObjects();
        
        initialiseGameElements();
    }

    @Override
    public void update() {
        super.update();
        
        if (gameState == GameState.GAME_OVER) {
            player.update(this);
        }

        if (this.gameState != GameState.RESULT && player.getTransform().getPosition().y > GameModel.gameScreenSize.y - 100){
            this.gameState = GameState.RESULT;
        }

        scoreCounter.updateText(String.valueOf(pillarFactory.getScore()));
        scoreBox.updateText("SCORE: " + String.valueOf(pillarFactory.getScore()));

        //Pillar factory sjekker om siste pillar er utenfor skjerm, hvis så fjerner vi den med remove.
        //Da ber vi også pillar factory om en ny.
    }

    @Override
    protected void colliding(Player p, GameObject col){
        if(this.gameState == GameState.GAME){
            this.gameState = GameState.GAME_OVER;
        }
    }

    @Override
    public void onKeyClick(int keyCode) {
        if(this.gameState == GameState.WELCOME){
            if(keyCode == KeyEvent.VK_SPACE){
                this.gameState = GameState.GAME;
            }
        }
        if(this.gameState == GameState.GAME){
            if(keyCode == KeyEvent.VK_SPACE){
                ((FlappyPlayer) this.player).jump();
            }
        }
    }

    @Override
    public void onMouseClick(Vector pos) {
        super.onMouseClick(pos);

        if(this.gameState == GameState.GAME){
            ((FlappyPlayer) this.player).jump();
        }
    }
}
