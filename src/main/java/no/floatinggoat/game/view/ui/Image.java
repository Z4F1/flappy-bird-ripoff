package no.floatinggoat.game.view.ui;

import java.awt.Graphics2D;

import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Image implements UI {

    private Texture texture;
    private Transform transform;
    private GameState layer;

    /**
     * Creates image ui element.
     * 
     * @param texture   The {@link Texture} element to draw.
     * @param position  The center position of the image.
     * @param size      The size of the image to draw.
     * @param layer     Which {@link GameState} to draw the image.
     */
    public Image(Texture texture, Vector position, Vector size, GameState layer){
        transform = new Transform(position, size);
        this.layer = layer;

        this.texture = texture;
    }

    @Override
    public void checkClick(Vector mousePos, Viewable viewable) {}

    @Override
    public void draw(Graphics2D g, Viewable viewable) {
        if(viewable.getGameState() == this.layer){
            g.drawImage(texture.getAsset(), (int) (transform.getPosition().x - (transform.getSize().x/2)), (int) (transform.getPosition().y - (transform.getSize().y/2)), (int) transform.getSize().x, (int) transform.getSize().y, null);
        }
    }
    
}
