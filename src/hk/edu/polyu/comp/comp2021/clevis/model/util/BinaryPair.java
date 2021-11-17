package hk.edu.polyu.comp.comp2021.clevis.model.util;

/**
 *
 */
public abstract class BinaryPair<T,W> {
    private T x;
    private W y;

    /**
     * @param x Horizontal coordinate
     * @param y Longitudinal coordinate
     */
    public BinaryPair(T x, W y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * @return return horizontal coordinate
     */
    public T getX() {
        return x;
    }

    /**
     * @param x Horizontal coordinate
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * @return Longitudinal coordinate
     */
    public W getY() {
        return y;
    }

    /**
     * @param y Longitudinal coordinate
     */
    public void setY(W y) {
        this.y = y;
    }
}
