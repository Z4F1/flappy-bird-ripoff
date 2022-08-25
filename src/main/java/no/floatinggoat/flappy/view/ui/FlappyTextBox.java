package no.floatinggoat.flappy.view.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import no.floatinggoat.game.assets.AssetsLoader;
import no.floatinggoat.game.assets.CustomFont;
import no.floatinggoat.game.assets.Texture;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;
import no.floatinggoat.game.view.ui.Text;
import no.floatinggoat.game.helpers.UIHelper;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyTextBox extends Text {

    private CustomFont font;
    private Texture texture;

    public FlappyTextBox(String text, float size, Vector position, CustomFont font, GameState layer) {
        super(text, size, position, layer);

        transform = new Transform(position, new Vector(384, 192));

        texture = AssetsLoader.getTexture("messagebox");
        this.font = font;
    }

    @Override
    public void draw(Graphics2D g, Viewable viewable) {
        if(viewable.getGameState() == layer){
            g.drawImage(texture.getAsset(), (int) (transform.getPosition().x - (transform.getSize().x/2)), (int) (transform.getPosition().y - (transform.getSize().y/2)), (int) transform.getSize().x, (int) transform.getSize().y, null);
            g.setColor(Color.white);
            UIHelper.drawCenteredText(g, text, font.getAsset().deriveFont(this.size), (int) transform.getPosition().x, (int) transform.getPosition().y);
        }
    }
    
}
