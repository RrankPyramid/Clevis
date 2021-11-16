package hk.edu.polyu.comp.comp2021.clevis.util;

/**
 *
 */
public abstract class BinaryPair {
    private double x;
    private double y;

    /**
     * @param x Horizontal coordinate
     * @param y Longitudinal coordinate
     */
    BinaryPair(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * @return return horizontal coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @param x Horizontal coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return Longitudinal coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * @param y Longitudinal coordinate
     */
    public void setY(double y) {
        this.y = y;
    }
}
