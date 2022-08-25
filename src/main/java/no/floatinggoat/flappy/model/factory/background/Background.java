package no.floatinggoat.flappy.model.factory.background;

import java.awt.Graphics2D;

import no.floatinggoat.flappy.model.factory.FactoryItem;
import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Background extends FactoryItem {

    private Texture texture;

    public Background(float x){
        transform = new Transform(new Vector(x, 0), GameModel.gameScreenSize);
        // Added velocity to create parallax effect.
        transform.addVelocity(new Vector(75, 0));

        texture = AssetsLoader.getTexture("background");
    }

    @Override
    public FactoryItem copyAt(int x) {
        return new Background(x);
    }

    @Override
    public int getWidth() {
        return (int) transform.getSize().x;
    }

    @Override
    public int getZIndex() {
        return -1;
    }

    @Override
    public void update(Scene scene) {
        transform.update(scene.getDeltaTime());
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.drawImage(texture.getAsset(), (int) transform.getPosition().x, (int) transform.getPosition().y, (int) transform.getSize().x, (int) transform.getSize().y, null);
    }
}
