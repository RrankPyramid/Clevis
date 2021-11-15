package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;

public abstract class Shape {

    protected int groupCounter = 0;
    public int zOrder;
    public abstract void draw(Graphics g);
    public abstract String[] getInfo(String name);
    public abstract boolean containPoint(Vertex p);
    public abstract void move(double dx,double dy);
    public abstract Vertex getTopLeft();
    public abstract Vertex getBottomRight();
    public abstract boolean intersect(Shape other);

}
