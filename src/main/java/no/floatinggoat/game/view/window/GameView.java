package no.floatinggoat.game.view.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JComponent;

import no.floatinggoat.game.model.GameModel;
import no.floatinggoat.game.model.gameobject.Drawable;
import no.floatinggoat.game.model.transform.Transform;
import no.floatinggoat.game.view.Viewable;
import no.floatinggoat.game.view.ui.UI;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class GameView extends JComponent {
    
    private static final long serialVersionUID = 3112980535423328346L;

    {
        setFocusable(true);
    }

    private float scale;
    private Viewable viewable;

    /**
     * The drawable JComponent added to the GameScreen in which is drawn.
     * 
     * @param viewable  The game model which implements the Viewable interface.
     */
    public GameView (Viewable viewable){
        this.viewable = viewable;
    }

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        //updateScreenScale();

        g.scale(scale, scale);

        drawGame(g);
        drawUI(g);
    }

    /**
     * Helper method for drawing the game objects.
     * 
     * @param g Graphics2D to draw on.
     */
    private void drawGame(Graphics2D g){
        Transform camTransform = viewable.getCamera().getTransform();

        g.setColor(Color.white);
        g.fillRect(0, 0, (int) camTransform.getSize().x, (int) camTransform.getSize().y);
        g.translate(-camTransform.getPosition().x, -camTransform.getPosition().y);

        for(Drawable item : viewable.getDrawables()){
            AffineTransform old = g.getTransform();
            item.draw(g);
            g.setTransform(old);
        }

        g.translate(camTransform.getPosition().x, camTransform.getPosition().y);
    }

    /**
     * Helper method for drawing the ui elements.
     * 
     * @param g Graphics2D to draw on.
     */
    private void drawUI(Graphics2D g){
        for(UI item : viewable.getUIElements()){
            item.draw(g, viewable);
        }
    }

    /**
     * The method that actual calculates the screen scale based on width.
     * Uses the {@link Viewable#updateScale(float)} to update it and also
     * updates the size using {@link JComponent#setBounds(int, int, int, int)}.
     * 
     * @param width
     * @param height
     */
    public void updateScreenScale(int width, int height){
        scale = Math.min(
            (float) width / (float) GameModel.gameScreenSize.x,
            (float) height / (float) GameModel.gameScreenSize.y
        );

        viewable.updateScale(scale);

        setBounds(
            (int) ((width/2) - ((GameModel.gameScreenSize.x * scale)/2)),
            (int) ((height/2) - ((GameModel.gameScreenSize.y * scale)/2)),
            (int) (GameModel.gameScreenSize.x * scale),
            (int) (GameModel.gameScreenSize.y * scale)
        );
    }
}
