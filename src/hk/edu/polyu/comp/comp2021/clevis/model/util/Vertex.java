package hk.edu.polyu.comp.comp2021.clevis.model.util;

/**
 * Defines veetex for subsequent calculations
 */
public class Vertex extends BinaryPair<Double,Double> {
    /**
     * @param x Initialize x
     * @param y Initialize y
     */
    public Vertex(double x, double y) {
        super(x, y);
    }

    /**
     * @param other another vector
     * @return vector from this to other
     */
    public Vector vectorTo(Vertex other) {
        return new Vector(other.getX() - this.getX(), other.getY() - this.getY());
    }

    /**
     * @param other another vector
     * @return Distance from this to other
     */
    public double distanceTo(Vertex other) {
        return this.vectorTo(other).norm();
    }

    /**
     * @param other another vector
     * @return The position of this point after moving towards the vector other
     */
    public Vertex add(Vector other) {
        return new Vertex(this.getX() + other.getX(), this.getY() + other.getY());
    }

    @Override
    public Vertex clone() {
        return (Vertex) super.clone();
    }
}
