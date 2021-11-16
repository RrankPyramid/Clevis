package hk.edu.polyu.comp.comp2021.clevis;


import hk.edu.polyu.comp.comp2021.clevis.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends Shape {
    private Vertex p;
    private Vector direct;

    public Rectangle(Vertex p, Vector direct, int z) {
        this.setP(p);
        this.setDirect(direct);
        this.setzOrder(z);
    }

    public Rectangle(Vertex p, Vector direct) {
        this.setP(p);
        this.setDirect(direct);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int) getP().getX(), (int) getP().getY(), (int) getDirect().getX(), (int) getDirect().getY());
    }

    @Override
    public boolean containPoint(Vertex point) {
        Vector vectorDown = new Vector(0, getDirect().getY());
        Vector vectorRight = new Vector(getDirect().getX(), 0);
        Line left = new Line(getP(), getP().add(vectorDown));
        Line up = new Line(getP(), getP().add(vectorRight));
        Line right = new Line(getP().add(vectorRight), getP().add(getDirect()));
        Line bottom = new Line(getP().add(vectorDown), getP().add(getDirect()));
        boolean result = right.containPoint(point) || bottom.containPoint(point) || left.containPoint(point) || up.containPoint(point);

        return result;
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
    public ArrayList<String> getInfo(String name) {
        ArrayList<String> result = new ArrayList<>();
        result.add(name + "is a rectangle,");
        result.add("Top-Left Corner : " + String.format("%.2f", getP().getX()) + " " + String.format("%.2f", getP().getY()));
        result.add("Width : " + String.format("%.2f", getDirect().getX()));
        result.add("Height : " + String.format("%.2f", getDirect().getY()));
        return result;
    }

    @Override
    public boolean intersect(Rectangle other) {
        Vertex otherTopLeft = other.getTopLeft();
        Vertex topLeft = this.getTopLeft();
        Vertex otherBottomRight = other.getBottomRight();
        Vertex bottomRight = this.getBottomRight();

        if (otherBottomRight.getX() < topLeft.getX() || otherBottomRight.getY() < topLeft.getY()) return false;
        if (otherTopLeft.getX() > bottomRight.getX() || otherTopLeft.getY() > bottomRight.getY()) return false;

        return (!(otherTopLeft.getX() > topLeft.getX()) || !(otherTopLeft.getY() > topLeft.getY())) || (!(otherBottomRight.getX() < bottomRight.getX()) || !(otherBottomRight.getY() < bottomRight.getY()));
    }

    @Override
    public boolean intersect(Circle other) {
        Vector vectorDown = new Vector(0, getDirect().getY());
        Vector vectorRight = new Vector(getDirect().getX(), 0);
        Line left = new Line(getP(), getP().add(vectorDown));
        Line up = new Line(getP(), getP().add(vectorRight));
        Line right = new Line(getP().add(vectorRight), getP().add(getDirect()));
        Line bottom = new Line(getP().add(vectorDown), getP().add(getDirect()));
        return left.intersect(other) || up.intersect(other) || right.intersect(other) || bottom.intersect(other);
    }

    @Override
    public boolean intersect(Line other) {
        return other.intersect(this);
    }

    @Override
    public boolean intersect(Group other) {
        return other.intersect(this);
    }

    public Vertex getP() {
        return p;
    }

    public void setP(Vertex p) {
        this.p = p;
    }

    public Vector getDirect() {
        return direct;
    }

    public void setDirect(Vector direct) {
        this.direct = direct;
    }
}