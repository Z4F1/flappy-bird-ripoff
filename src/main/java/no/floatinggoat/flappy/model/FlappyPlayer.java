package no.floatinggoat.flappy.model;

import java.awt.Color;
import java.awt.Graphics2D;

import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.Player;
import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyPlayer extends Player {

    private Texture texture;

    public FlappyPlayer(){
        transform = new Transform(new Vector(150, GameModel.gameScreenSize.y/2), new Vector(90, 72));
        transform.addVelocity(new Vector(150, 3f));

        setCollider(
            new Transform(
                new Vector(
                    5-transform.getSize().x/2,
                    5-transform.getSize().y/2
                ),
                transform.getSize().add(-10, -10)
            )
        );
        
        texture = AssetsLoader.getTexture("player");
    }

    @Override
    public void update(Scene scene){
        transform.addVelocity(new Vector(0, 3f));
        calculateRotationByVelocity();

        super.update(scene);
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.red);

        g.translate(transform.getPosition().x, transform.getPosition().y);
        g.rotate(Math.toRadians(transform.getRotation()));
        g.drawImage(texture.getAsset(), (int) -transform.getSize().x/2, (int) -transform.getSize().y/2, (int) transform.getSize().x, (int) transform.getSize().y, null);
    }

    /**
     * Method for making the player jump.
     */
    public void jump(){
        transform.setVelocityY(-450);
    }

    /**
     * Helper method for calculating the rotation of the player.
     * This is based on the vertical velocity and uses a map formula for calculating.
     */
    private void calculateRotationByVelocity(){
        float a1 = -200;
        float a2 = 300;
        float b1 = -30;
        float b2 = 90;
        float rangeMapped = b1 + ((transform.getVelocity().y - a1)*(b2 - b1))/(a2 - a1);
        float clamped = Math.min(90, Math.max(-30, rangeMapped));
        transform.setRotation(clamped);
    }
}
