package hk.edu.polyu.comp.comp2021.clevis.model.util;

/**
 * Defines vectors for subsequent calculations
 */
public class Vector extends BinaryPair {
    /**
     * @param x x of this Vector
     * @param y y of this Vector
     */
    public Vector(double x, double y) {
        super(x, y);
    }

    /**
     * @param other another vector
     * @return return the vector product of two vector
     */
    public double crossProduct(Vector other) {
        return this.getX() * other.getY() - other.getX() * this.getY();
    }

    /**
     * @return the norm of this vector
     */
    public double norm() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    @Override
    public Vector clone() {
        return (Vector) super.clone();
    }
}
