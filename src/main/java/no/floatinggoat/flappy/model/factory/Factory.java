package no.floatinggoat.flappy.model.factory;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import no.floatinggoat.game.model.Scene;
import no.floatinggoat.game.model.gameobject.Drawable;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;
import no.floatinggoat.game.model.transform.Transform;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Factory extends GameObjectCollidable implements Drawable {
    private FactoryItem defaultItem;
    private int gap;
    private int startPos;

    protected List<FactoryItem> items;
    private int lastItemX = 0;

    /**
     * Creates the factory.
     * 
     * @param item          The factory item to use.
     * @param activeItems   Number of factory items that are used.
     * @param startPos      The x position to start from.
     * @param gap           The gap between each factory item.
     */
    public Factory(FactoryItem item, int activeItems, int startPos, int gap){
        this.defaultItem = item;
        this.gap = gap;
        this.startPos = startPos;

        this.items = new ArrayList<>();
        for(int i = 0; i < activeItems; i++){
            items.add(item.copyAt(startPos + ((item.getWidth() + gap) * i)));
        }

        setLastItemX();
    }

    @Override
    public int getZIndex() {
        return this.defaultItem.getZIndex();
    }

    @Override
    public boolean colliding(GameObjectCollidable other){
        for (FactoryItem item : items) {
            if(item.colliding(other)) return true;
        }

        return false;
    }

    @Override
    public void update(Scene scene) {
        Transform camTransform = scene.getCamera().getTransform();

        List<FactoryItem> removableItems = new ArrayList<>();
        for (FactoryItem item : items) {
            item.getTransform().update(scene.getDeltaTime());

            if(item.getTransform().getPosition().x + item.getTransform().getSize().x + this.gap < camTransform.getPosition().x){
                removableItems.add(item);
            }
        }

        setLastItemX();

        for (FactoryItem item : removableItems) {
            items.remove(item);
            addNewItem();
        }
    }

    /**
     * Helper method for adding a new item when removed.
     */
    private void addNewItem(){
        lastItemX += this.defaultItem.getWidth() + this.gap;
        items.add(this.defaultItem.copyAt(lastItemX));
    }

    /**
     * Helper method for updating the furthest x value.
     */
    private void setLastItemX(){
        Transform tempLastItem = this.items.get(this.items.size()-1).getTransform();
        lastItemX = (int) tempLastItem.getPosition().x;
    }

    /**
     * Method for getting the gap size.
     * 
     * @return  Integer with the gap size.
     */
    protected int getGap(){
        return this.gap;
    }

    /**
     * Method for getting the x start position.
     * 
     * @return  The integer with the x value.
     */
    protected int getStartPos(){
        return this.startPos;
    }

    /**
     * Method for getting the default factory item.
     * 
     * @return  The factory item.
     */
    protected FactoryItem getDefaultItem(){
        return this.defaultItem;
    }

    @Override
    public void draw(Graphics2D g) {
        for (FactoryItem item : items) {
            item.draw(g);
        }
    }
}
