package no.floatinggoat.game.controller;

import java.util.HashMap;
import java.util.Map;

import no.floatinggoat.game.model.transform.Vector;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;  
import java.awt.event.KeyListener;  
import java.awt.event.KeyEvent;  

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class Input implements MouseListener, KeyListener {

    private Map<Integer, Boolean> pressedKeys;
    private boolean mouseDown;
    private Vector mousePosition;

    public Input(){
        pressedKeys = new HashMap<Integer, Boolean>();

        mouseDown = false;
        mousePosition = new Vector(0, 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(pressedKeys.get(e.getKeyCode()) == null){
            pressedKeys.put(e.getKeyCode(), true);
            onKeyClick(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove(e.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePosition = new Vector(e.getX(), e.getY());
        
        if(!mouseDown){
            onMouseClick(mousePosition);
            mouseDown = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDown = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * The method that is executed on key down. This is only executed on key down, not hold.
     * 
     * @param keyCode   The code of the key that is pressed.
     */
    public abstract void onKeyClick(int keyCode);

    /**
     * The method that is executed on mouse click. This is only executed on mouse click, not hold.
     * 
     * @param pos   The vector position of the mouse click.
     */
    public abstract void onMouseClick(Vector pos);

    /**
     * Method for checking if a key is pressed.
     * 
     * @param keyCode   The key to check.
     * @return          True or false, based on if the key is pressed.
     */
    public boolean isKeyDown(int keyCode){
        return pressedKeys.get(keyCode);
    }

    /**
     * Method for checking if the mouse is pressed.
     * 
     * @return  True or false, based on if the mouse is pressed.
     */
    public boolean isMouseDown(){
        return mouseDown;
    }

    /**
     * Method for getting the current mouse position.
     * 
     * @return  The vector position of the mouse.
     */
    public Vector getMousePosition(){
        return mousePosition;
    }
}
