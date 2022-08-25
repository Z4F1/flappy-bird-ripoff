package no.floatinggoat.flappy.model.factory.pillar;

import java.awt.Graphics2D;

import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.gameobject.Drawable;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Pillar extends GameObjectCollidable implements Drawable {

    private Texture texture;

    /**
     * @param position The position of this pillar (or pipe).
     */
    public Pillar(Vector position){
        transform = new Transform(position, new Vector(150, 960));
        setCollider(new Transform(Vector.zero, transform.getSize()));

        texture = AssetsLoader.getTexture("pillar");
    }

    @Override
    public void update(Scene scene) {}

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(texture.getAsset(), (int) transform.getPosition().x, (int) transform.getPosition().y, (int) transform.getSize().x, (int) transform.getSize().y, null);
    }

    @Override
    public int getZIndex() {
        return 1;
    }
}
