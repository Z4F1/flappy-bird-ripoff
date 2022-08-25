package no.floatinggoat.flappy.view.ui;

import java.awt.Graphics2D;

import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;
import no.floatinggoat.game.view.ui.Button;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyButton extends Button {

    private Texture texture;

    public FlappyButton(Texture texture, Vector position, Vector size, GameState layer) {
        super(position, size, layer);
        this.texture = texture;
    }

    @Override
    public void draw(Graphics2D g, Viewable viewable) {
        if(viewable.getGameState() == this.layer){
            g.drawImage(texture.getAsset(), (int) (transform.getPosition().x - (transform.getSize().x/2)), (int) (transform.getPosition().y - (transform.getSize().y/2)), (int) transform.getSize().x, (int) transform.getSize().y, null);
        }
    }
}
