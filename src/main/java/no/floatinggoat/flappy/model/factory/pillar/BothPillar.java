package no.floatinggoat.flappy.model.factory.pillar;

import java.awt.Graphics2D;
import java.util.Random;

import no.floatinggoat.flappy.model.factory.FactoryItem;
import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class BothPillar extends FactoryItem {

    private Random r = new Random();

    private Pillar top;
    private Pillar bottom;

    /**
     * @param x The x position of the factory item.
     */
    public BothPillar(float x){
        float y = getRandomHeight();

        transform = new Transform(new Vector(x, y), Vector.zero);

        bottom = new Pillar(new Vector(x, y + 200));
        top = new Pillar(new Vector(x, y - bottom.getTransform().getSize().y));
    }

    /**
     * Helper method for calculating a random height.
     * 
     * @return  Random float value within a specific range.
     */
    private float getRandomHeight(){
        return r.nextFloat(GameModel.gameScreenSize.y - 500) + 100;
    }

    @Override
    public int getWidth() {
        return (int) top.getTransform().getSize().x;
    }

    @Override
    public boolean colliding(GameObjectCollidable other){
        return top.colliding(other) ||  bottom.colliding(other);
    }

    @Override
    public void update(Scene scene) {}

    @Override
    public void draw(Graphics2D g) {
        top.draw(g);
        bottom.draw(g);
    }

    @Override
    public int getZIndex() {
        return 1;
    }

    @Override
    public FactoryItem copyAt(int x) {
        return new BothPillar(x);
    }
}
