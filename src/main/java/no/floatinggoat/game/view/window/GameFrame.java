package no.floatinggoat.game.view.window;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class GameFrame extends JFrame {

    private static final long serialVersionUID = 5485961417864214345L;

    /**
     * Creates a JFrame for the Game.
     * 
     * @param gameScreen    The actual gameScreen.
     * @param title         Title of the window.
     */
    public GameFrame(GameScreen gameScreen, String title) {
        super(title);

        setContentPane(gameScreen);
        
        setSize(new Dimension(960, 540));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
