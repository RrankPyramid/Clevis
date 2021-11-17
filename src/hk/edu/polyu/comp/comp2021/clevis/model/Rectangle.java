package hk.edu.polyu.comp.comp2021.clevis.model;


import hk.edu.polyu.comp.comp2021.clevis.model.util.BinaryPair;
import hk.edu.polyu.comp.comp2021.clevis.model.util.HistorpStatus;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import java.awt.*;
import java.util.ArrayList;

/**
 * Rectangle, a type of shape, contains squares
 */
public class Rectangle extends Shape {
    private Vertex p;
    private Vector direct;

    /**
     * @param p The top-left conner
     * @param direct the vector from top-left to bottom right;
     * @param z The Z-order
     */
    public Rectangle(Vertex p, Vector direct, int z) {
        this.setP(p);
        this.setDirect(direct);
        this.setzOrder(z);
    }

    /**
     * @param p The top-left conner
     * @param direct the vector from top-left to bottom right;
     */
    public Rectangle(Vertex p, Vector direct) {
        this.setP(p);
        this.setDirect(direct);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(getP().getX().intValue(), getP().getY().intValue(),  getDirect().getX().intValue(),  getDirect().getY().intValue());
    }

    @Override
    public boolean containPoint(Vertex point) {
        Vector vectorDown = new Vector(0, getDirect().getY());
        Vector vectorRight = new Vector(getDirect().getX(), 0);
        Line left = new Line(getP(), getP().add(vectorDown));
        Line up = new Line(getP(), getP().add(vectorRight));
        Line right = new Line(getP().add(vectorRight), getP().add(getDirect()));
        Line bottom = new Line(getP().add(vectorDown), getP().add(getDirect()));

        return right.containPoint(point) || bottom.containPoint(point) || left.containPoint(point) || up.containPoint(point);
    }

    @Override
    public void move(double dx, double dy) {
        setP(getP().add(new Vector(dx, dy)));
    }


    @Override
    public Vertex getTopLeft() {
        return getP();
    }

    @Override
    public Vertex getBottomRight() {
        return getP().add(getDirect());
    }

    @Override
    public void updateHistory(int time) {
        Rectangle temp = new Rectangle(this.getP(),this.getDirect());
        HistorpStatus status = new HistorpStatus(time,temp);
        getHistoryStatus().add(status);
    }

    @Override
    public ArrayList<String> getInfo(String name) {
        ArrayList<String> result = new ArrayList<>();
        result.add(name + " is a rectangle,");
        result.add("Top-Left Corner : " + String.format("%.2f", getP().getX()) + " " + String.format("%.2f", getP().getY()));
        result.add("Width : " + String.format("%.2f", getDirect().getX()));
        result.add("Height : " + String.format("%.2f", getDirect().getY()));
        return result;
    }

    @Override
    public void backtrace(int time) {
        Rectangle other = (Rectangle) getHistoryStatus().get(getHistoryStatus().size()-1).getY();
        this.setP(other.getP());
        this.setDirect(other.getDirect());
        this.updateHistory(time);
    }

    /**
     * @param other another rectangle
     * @return whether this circle is intersect with the rectangle
     */
    public boolean intersect(Rectangle other) {
        Vertex otherTopLeft = other.getTopLeft();
        Vertex topLeft = this.getTopLeft();
        Vertex otherBottomRight = other.getBottomRight();
        Vertex bottomRight = this.getBottomRight();

        if (otherBottomRight.getX() < topLeft.getX() || otherBottomRight.getY() < topLeft.getY()) return false;
        if (otherTopLeft.getX() > bottomRight.getX() || otherTopLeft.getY() > bottomRight.getY()) return false;

        return (!(otherTopLeft.getX() > topLeft.getX()) || !(otherTopLeft.getY() > topLeft.getY())) || (!(otherBottomRight.getX() < bottomRight.getX()) || !(otherBottomRight.getY() < bottomRight.getY()));
    }
    /**
     * @param other another circle
     * @return whether this circle is intersect with the circle
     */
    public boolean intersect(Circle other) {
        Vector vectorDown = new Vector(0, getDirect().getY());
        Vector vectorRight = new Vector(getDirect().getX(), 0);
        Line left = new Line(getP(), getP().add(vectorDown));
        Line up = new Line(getP(), getP().add(vectorRight));
        Line right = new Line(getP().add(vectorRight), getP().add(getDirect()));
        Line bottom = new Line(getP().add(vectorDown), getP().add(getDirect()));
        return left.intersect(other) || up.intersect(other) || right.intersect(other) || bottom.intersect(other);
    }
    /**
     * @param other another line
     * @return whether this circle is intersect with the line
     */
    public boolean intersect(Line other) {
        return other.intersect(this);
    }
    /**
     * @param other another group
     * @return whether this circle is intersect with the group
     */
    public boolean intersect(Group other) {
        return other.intersect(this);
    }

    /**
     * @return return the top left conner
     */
    public Vertex getP() {
        return p;
    }

    /**
     * @param p update the top left conner
     */
    public void setP(Vertex p) {
        this.p = p;
    }

    /**
     * @return return the vector from top-left to bottom right
     */
    public Vector getDirect() {
        return direct;
    }

    /**
     * @param direct update the vector from top-left to bottom right
     */
    public void setDirect(Vector direct) {
        this.direct = direct;
    }

    @Override
    public Rectangle clone() {
        Rectangle clone = (Rectangle) super.clone();
        clone.setP(getP().clone());
        clone.setDirect(getDirect().clone());
        return clone;
    }
}