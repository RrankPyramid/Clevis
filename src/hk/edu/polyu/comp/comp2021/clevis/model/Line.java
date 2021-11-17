package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.util.HistorpStatus;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;

import java.awt.*;
import java.util.ArrayList;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.EPS;


/**
 *
 */
public class Line extends Shape {

    private Vertex x;
    private Vertex y;

    /**
     * @param x The start node
     * @param y The end node
     * @param z The order the shapes have been added
     */
    public Line(Vertex x, Vertex y, int z) {
        this.setX(x);
        this.setY(y);
        this.setzOrder(z);
    }

    /**
     * @param x The start node
     * @param y The end node
     */
    public Line(Vertex x, Vertex y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void updateHistory(int time) {
        if(getHistoryStatus().size()==0){
            HistorpStatus status = new HistorpStatus(time,null);
            return;
        };
        Line temp = new Line(this.getX(),this.getY(),this.getzOrder());
        HistorpStatus status = new HistorpStatus(time,temp);
        getHistoryStatus().add(status);
    }

    @Override
    public void backtrace(int time) {
        Line other = (Line) getHistoryStatus().get(getHistoryStatus().size()-1).getY();
        this.setX(other.getX());
        this.setY(other.getY());
        this.updateHistory(time);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine( getX().getX().intValue(), getX().getY().intValue(), getY().getX().intValue(), getY().getY().intValue());
    }

    @Override
    public boolean containPoint(Vertex p) {
        if (Math.abs(getX().vectorTo(p).crossProduct(getX().vectorTo(getY()))) / (getX().distanceTo(getY())) > EPS)
            return false;
        double min_x = Math.min(getX().getX(), getY().getX()), max_x = Math.max(getX().getX(), getY().getX());
        double min_y = Math.min(getX().getY(), getY().getY()), max_y = Math.max(getX().getY(), getY().getY());

        return !(p.getX() - min_x < -EPS) && !(p.getX() - max_x > EPS) && !(p.getY() - min_y < -EPS) && !(p.getY() - max_y > EPS);
    }


    @Override
    public void move(double dx, double dy) {
        Vector vector = new Vector(dx, dy);
        setX(getX().add(vector));
        setY(getY().add(vector));
    }

    @Override
    public Vertex getTopLeft() {
        return new Vertex(Math.min(getX().getX(), getY().getX()), Math.min(getX().getY(), getY().getY()));
    }

    @Override
    public Vertex getBottomRight() {
        return new Vertex(Math.max(getX().getX(), getY().getX()), Math.max(getX().getY(), getY().getY()));
    }

    @Override
    public ArrayList<String> getInfo(String name) {
        ArrayList<String> result = new ArrayList<>();
        result.add(name + "is a line");
        result.add("First endpoint : " + String.format("%.2f", getX().getX()) + " " + String.format("%.2f", getX().getY()));
        result.add("Second endpoint : " + String.format("%.2f", getY().getX()) + " " + String.format("%.2f", getY().getY()));
        return result;
    }

    /**
     * @param point The points for which the distance is to be calculated
     * @return Distance from a point to the line where the segment is located
     */
    public double distanceTo(Vertex point) {
        return Math.abs(getX().vectorTo(point).crossProduct(getX().vectorTo(getY())) / (getX().distanceTo(getY())));
    }
    /**
     * @param other another line
     * @return whether this circle is intersect with the line
     */
    public boolean intersect(Line other) {
        Rectangle r1 = new Rectangle(this.getX(),this.getX().vectorTo(this.getY()));
        Rectangle r2 = new Rectangle(other.getX(),other.getX().vectorTo(other.getY()));
        if(! r1.intersect(r2))return false;
        double a = this.getX().vectorTo(other.getY()).crossProduct(this.getX().vectorTo(this.getY())) * (this.getX().vectorTo(getY()).crossProduct(this.getX().vectorTo(other.getX())));
        double b = other.getX().vectorTo(this.getY()).crossProduct(other.getX().vectorTo(other.getY())) * other.getX().vectorTo(other.getY()).crossProduct(other.getX().vectorTo(this.getX()));
        return a >= 0 && b >= 0;
    }
    /**
     * @param other another rectangle
     * @return whether this circle is intersect with the rectangle
     */
    public boolean intersect(Rectangle other) {
        Vector vectorDown = new Vector(0, other.getDirect().getY());
        Vector vectorRight = new Vector(other.getDirect().getX(), 0);
        Line left = new Line(other.getP(), other.getP().add(vectorDown));
        Line up = new Line(other.getP(), other.getP().add(vectorRight));
        Line right = new Line(other.getP().add(vectorRight), other.getP().add(other.getDirect()));
        Line bottom = new Line(other.getP().add(vectorDown), other.getP().add(other.getDirect()));
        return (this.intersect(left) || this.intersect(up) || this.intersect(right) || this.intersect(bottom));
    }
    /**
     * @param other another circle
     * @return whether this circle is intersect with the circle
     */
    public boolean intersect(Circle other) {
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
     * @return the Start node
     */
    public Vertex getX() {
        return x;
    }

    /**
     * @param x the Start node
     */
    public void setX(Vertex x) {
        this.x = x;
    }

    /**
     * @return the end node
     */
    public Vertex getY() {
        return y;
    }

    /**
     * @param y the end node
     */
    public void setY(Vertex y) {
        this.y = y;
    }

    @Override
    public Line clone(){
        Line clone = (Line) super.clone();
        clone.setX(getX().clone());
        clone.setY(getY().clone());
        return clone;
    }
}
