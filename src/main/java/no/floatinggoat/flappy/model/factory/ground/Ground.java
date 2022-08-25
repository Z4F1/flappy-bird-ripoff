package no.floatinggoat.flappy.model.factory.ground;

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
public class Ground extends FactoryItem {
    private Texture texture;
    
    /**
     * @param x     Start position, only x axis.
     */
    public Ground(float x){
        transform = new Transform(new Vector(x, GameModel.gameScreenSize.y - 100), new Vector(672, 224));
    
        texture = AssetsLoader.getTexture("ground");
    }

    @Override
    public int getWidth() {
        return (int) transform.getSize().x;
    }

    @Override
    public int getZIndex() {
        return 1;
    }

    @Override
    public FactoryItem copyAt(int x) {
        return new Ground(x);
    }

    @Override
    public void update(Scene scene) {}

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(texture.getAsset(), (int) transform.getPosition().x, (int) transform.getPosition().y, (int) transform.getSize().x, (int) transform.getSize().y, null);
    }

}
