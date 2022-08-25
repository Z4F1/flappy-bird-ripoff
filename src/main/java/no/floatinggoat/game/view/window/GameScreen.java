package no.floatinggoat.game.view.window;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import no.floatinggoat.game.model.GameModel;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 * 
 * Heavily inspired by https://www.youtube.com/watch?v=1gir2R7G9ws
 */
public class GameScreen extends JPanel implements Runnable {
    
    private static final long serialVersionUID = 7578879949844915251L;

    private GameView view;
    private GameModel model;

    private Thread thread;
    private boolean running;
    
    private double maxFPS = 60;

    /**
     * Creates a JPanel which is the actual game screen.
     * This is also used for maintaining the highest resolution
     * and aspect ratio. This also contains the game loop.
     * 
     * @param model The game model for the game.
     */
    public GameScreen(GameModel model){
        this.model = model;
        
        setLayout(null);

        view = new GameView(model);

        view.addKeyListener(model);
        view.addMouseListener(model);

        // Calculates scale factor for scaling the gameview.
        view.updateScreenScale(getWidth(), getHeight());

        add(view);

        // Needed for when the window is resized. This then recalculates the scale factor to make the gameview responsive.
        addComponentListener(new ComponentAdapter(){
            @Override
            public void componentResized(ComponentEvent e){
                view.updateScreenScale(
                    e.getComponent().getWidth(),
                    e.getComponent().getHeight()
                );
            }
        });
    }

    public GameScreen(GameModel model, double maxFPS){
        this(model);

        this.maxFPS = maxFPS;
    }

    public synchronized void start(){
        // Load images first.
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        running = false;
    }

    @Override
    public void run(){
        thread = Thread.currentThread();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0;
        try {
            while(running){
                model.update();
                if(System.nanoTime() - lastTime >= 1000000000/this.maxFPS){
                    lastTime = System.nanoTime();
                    view.repaint();
                    frames++;
                }

                if(System.currentTimeMillis() - timer >= 1000){
                    timer = System.currentTimeMillis();
                    System.out.println("FPS: " + frames);
                    frames = 0; 
                }

                Thread.sleep(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stop();
    }
}
