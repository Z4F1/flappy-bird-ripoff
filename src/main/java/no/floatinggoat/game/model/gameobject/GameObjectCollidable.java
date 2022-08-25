package no.floatinggoat.game.model.gameobject;

import no.floatinggoat.game.model.transform.Transform;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public abstract class GameObjectCollidable extends GameObject {

    private Transform collider;

    /**
     * Sets collider transform.
     * 
     * @param collider  The transform object of the collider.
     */
    protected void setCollider(Transform collider){
        this.collider = collider;
    }

    /**
     * Getts the collider transform.
     * 
     * @return  The collider transform.
     */
    public Transform getCollider(){
        return collider;
    }

    /**
     * Method for checking if this object is colliding with another.
     * 
     * @param other The other collidable game object.
     * @return      True or false, based on if they collide.
     */
    public boolean colliding(GameObjectCollidable other){
        Transform otherTransform = other.getTransform();
        Transform otherCollider = other.getCollider();

        //Collider transform is offset of actual location.
        return (collider.getPosition().x + transform.getPosition().x < otherCollider.getPosition().x + otherTransform.getPosition().x + otherCollider.getSize().x) &&
            (collider.getPosition().y + transform.getPosition().y < otherCollider.getPosition().y + otherTransform.getPosition().y + otherCollider.getSize().y) &&
            (collider.getPosition().x + transform.getPosition().x + collider.getSize().x > otherCollider.getPosition().x + otherTransform.getPosition().x) &&
            (collider.getPosition().y + transform.getPosition().y + collider.getSize().y > otherCollider.getPosition().y + otherTransform.getPosition().y);
    }
}
