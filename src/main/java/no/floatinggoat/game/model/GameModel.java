package no.floatinggoat.game.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import no.floatinggoat.game.controller.Input;
import no.floatinggoat.game.model.gameobject.Camera;
import no.floatinggoat.game.model.gameobject.Drawable;
import no.floatinggoat.game.model.gameobject.GameObject;
import no.floatinggoat.game.model.gameobject.GameObjectCollidable;
import no.floatinggoat.game.model.transform.Vector;
import no.floatinggoat.game.view.Viewable;
import no.floatinggoat.game.view.ui.UI;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class GameModel extends Input implements Scene, Viewable {

    public static Vector gameScreenSize = Vector.zero;
    private float scale = 1;
    private double deltaTime = 0.00f;
    private double lastTime;

    protected Camera camera;
    protected Player player;

    protected GameState gameState;

    private List<GameObject> gameObjects = new ArrayList<>();
    private List<Drawable> drawables = new ArrayList<>();
    private List<GameObjectCollidable> collidables = new ArrayList<>();
    private List<UI> uiElements = new ArrayList<>();

    /**
     * Method for adding the player and camera after they are initialised.
     * Also sets lastTime variable for calculating the deltatime.
     */
    protected void initiate() {
        add(player);
        add(camera);

        lastTime = System.nanoTime();
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public GameState getGameState() {
        return gameState;
    }

    @Override
    public double getDeltaTime() {
        return deltaTime;
    }

    @Override
    public void updateScale(float scale) {
        this.scale = scale;
    }

    @Override
    public float getScale() {
        return this.scale;
    }

    /**
     * The method for updating all the game objects.
     * Also checks for collision between collidable game objects.
     */
    public void update() {
        deltaTime = (System.nanoTime() - lastTime) / 1000000000L;
        lastTime = System.nanoTime();

        if (gameState == GameState.GAME) {
            for (GameObject obj : gameObjects) {
                obj.update(this);
            }

            for (GameObjectCollidable col : collidables) {
                if (col.colliding(player)) {
                    colliding(player, col);
                }
            }
        }
    }

    /**
     * Method for handeling the collision between the player and some other object.
     * 
     * @param player    The player object.
     * @param col       The other collidable object.
     */
    protected abstract void colliding(Player player, GameObject col);

    @Override
    public List<Drawable> getDrawables() {
        return drawables;
    }

    @Override
    public List<UI> getUIElements() {
        return uiElements;
    }

    /**
     * This method is used to add game objects to the game. It can be any obj, but it
     * selects which of them is added. If the obj is an instance of something unknown
     * it will be ignored.
     * 
     * @param obj   The object to add.
     */
    public void add(Object obj) {
        if (obj instanceof GameObject) {
            gameObjects.add((GameObject) obj);
        }

        if (obj instanceof Drawable) {
            drawables.add((Drawable) obj);
        }

        if (obj instanceof UI) {
            uiElements.add((UI) obj);
        }

        if (obj instanceof GameObjectCollidable && !(obj instanceof Player)) {
            collidables.add((GameObjectCollidable) obj);
        }

        Collections.sort(drawables, new Comparator<Drawable>() {
            public int compare(Drawable e1, Drawable e2) {
                return e1.getZIndex() - e2.getZIndex();
            }
        });
    }

    /**
     * Removed all the game objects, but not the ui.
     */
    public void removeAllGameObjects() {
        gameObjects = new ArrayList<>();
        drawables = new ArrayList<>();
        collidables = new ArrayList<>();
    }

    @Override
    public void onMouseClick(Vector pos) {
        for (UI item : uiElements) {
            item.checkClick(pos, this);
        }
    }
}
