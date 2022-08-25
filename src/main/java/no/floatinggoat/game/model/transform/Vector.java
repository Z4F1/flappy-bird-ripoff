package no.floatinggoat.game.model.transform;

import java.util.Objects;

/**
 * @author Pelle Pastoor
 * @version 1.0.0
 */
public class Vector {
    public final float x;
    public final float y;

    /**
     * @param x The x coordinate of the vector.
     * @param y The y coordinate of the vector.
     */
    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * To add a vector to this vector.
     * 
     * @param other The other vector to be added.
     * @return      The updated vector.
     */
    public Vector add(Vector other){
        return new Vector(x + other.x, y + other.y);
    }

    /**
     * To add a x and y value to this vector.
     * 
     * @param x The x to add.
     * @param y The y to add.
     * @return  The new vector that is updated.
     */
    public Vector add(float x, float y){
        return new Vector(this.x + x, this.y + y);
    }

    /**
     * To multiply a value with both x and y of this vector.
     * 
     * @param n The multiplication value.
     * @return  The updated vector.
     */
    public Vector multiply(float n){
        return new Vector(x * n, y * n);
    }

    /**
     * To multiply a value with both x and y of this vector.
     * 
     * @param n The multiplication value.
     * @return  The updated vector.
     */
    public Vector multiply(double n){
        return new Vector((float) (x * n), (float) (y * n));
    }

    @Override
    public String toString() {
        return String.format("{%f, %f}", x, y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector)) return false;

        Vector other = (Vector) obj;
        return this.x == other.x && this.y == other.y;
    }

    public static final Vector zero = new Vector(0, 0);
}
