package no.floatinggoat.flappy.view.ui;

import java.awt.Color;
import java.awt.Graphics2D;

import no.floatinggoat.game.assets.CustomFont;
import no.floatinggoat.game.model.GameState;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;
import no.floatinggoat.game.view.ui.Text;
import no.floatinggoat.game.helpers.UIHelper;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class FlappyText extends Text {
    private CustomFont font;

    public FlappyText(String text, float size, Vector position, CustomFont font, GameState layer) {
        super(text, size, position, layer);
        
        this.font = font;
    }

    @Override
    public void draw(Graphics2D g, Viewable viewable) {
        if(viewable.getGameState() == layer){
            g.setColor(Color.white);
            UIHelper.drawCenteredText(g, text, font.getAsset().deriveFont(this.size), (int) transform.getPosition().x, (int) transform.getPosition().y);
        }
    }
    
}
