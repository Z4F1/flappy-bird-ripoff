package no.floatinggoat.game.model.transform;

import java.util.Objects;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Transform {
    private Vector position;
    private Vector velocity;
    private Vector size;
    private float rotation;

    /**
     * Transform element used by every game object.
     * 
     * @param position  The position of the transform.
     * @param size      The size of the transform.
     */
    public Transform(Vector position, Vector size){
        this.position = position;
        this.size = size;
        this.velocity = new Vector(0, 0);
    }

    /**
     * Set a velocity for this transform.
     * 
     * @param velocity  The new velocity.
     */
    public void setVelocity(Vector velocity){
        this.velocity = velocity;
    }

    /**
     * Sets a velocity only for the x axis of this transform.
     * 
     * @param vel   The new x velocity.
     */
    public void setVelocityX(float vel){
        this.velocity = new Vector(vel, this.velocity.y);
    }

    /**
     * Sets a velocity only for the y axis of this transform.
     * 
     * @param vel   The new y velocity.
     */
    public void setVelocityY(float vel){
        this.velocity = new Vector(this.velocity.x, vel);
    }

    /**
     * Add a vector to this velocity.
     * 
     * @param velocity  The vector to add.
     */
    public void addVelocity(Vector velocity){
        this.velocity = this.velocity.add(velocity);
    }

    /**
     * Sets a new position of this transform.
     * 
     * @param position  The new position in the form of a vector.
     */
    public void setPosition(Vector position){
        this.position = position;
    }

    /**
     * Sets a rotation for this transform.
     * 
     * @param rot   The rotation.
     */
    public void setRotation(float rot){
        this.rotation = rot;
    }

    /**
     * Method for getting the transforms position.
     * 
     * @return  The vector for the position.
     */
    public Vector getPosition(){
        return position;
    }

    /**
     * Method for getting the transforms velocity.
     * 
     * @return  The vector for the velocity.
     */
    public Vector getVelocity(){
        return velocity;
    }

    /**
     * Method for getting the transforms size.
     * 
     * @return  The vector for the size.
     */
    public Vector getSize(){
        return size;
    }

    /**
     * Method for getting the transforms rotation.
     * 
     * @return  The vector for the rotation.
     */
    public float getRotation(){
        return rotation;
    }

    /**
     * For updating the transform. This adds the velocity to the position
     * and is multiplied by the deltaTime to be consistent on different computers.
     * 
     * @param deltaTime The time between each update.
     */
    public void update(double deltaTime){
        setPosition(position.add(velocity.multiply(deltaTime)));
    }

    @Override
    public String toString() {
        return String.format(
            "{position: %s, velocity: %s, size: %s, rotation: %d}",
            
            position.toString(),
            velocity.toString(),
            size.toString(),
            rotation
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, velocity, size, rotation);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof Transform)) return false;
        
        Transform transform = (Transform) obj;
        return position.equals(transform.position) &&
            velocity.equals(transform.velocity) &&
            size.equals(transform.size) &&
            rotation == transform.rotation;
    }
}
