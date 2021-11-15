package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 */
public abstract class Shape {

    private int groupCounter = 0;
    private int zOrder;

    /**
     * @param g Draw the Graphic
     */
    public abstract void draw(Graphics g);

    /**
     * @param name name of Shape
     * @return the imformation of the shape
     */
    public abstract ArrayList<String> getInfo(String name);

    /**
     * @param p One point to check
     * @return Whether this shape contains this point
     */
    public abstract boolean containPoint(Vertex p);

    /**
     * @param dx Distance to move laterally
     * @param dy Distance travelled vertically
     */
    public abstract void move(double dx,double dy);

    /**
     * @return Return the Top-Left point of the Shape
     */
    public abstract Vertex getTopLeft();

    /**
     * @return Return the Bottom-Right point of the Shape
     */
    public abstract Vertex getBottomRight();

    /**
     * @param other Another shape
     * @return Whether these two shapes are intersected
     */
    public abstract boolean intersect(Circle other);
    public abstract boolean intersect(Line other);
    public abstract boolean intersect(Rectangle other);
    public abstract boolean intersect(Group other);

    /**
     * @return Returns how many groups the shape is contained by
     */
    public int getGroupCounter() {
        return groupCounter;
    }

    /**
     * @param groupCounter how many groups the shape is contained by
     */
    public void setGroupCounter(int groupCounter) {
        this.groupCounter = groupCounter;
    }

    /**
     * @return Returns the order the shapes have been added
     */
    public int getzOrder() {
        return zOrder;
    }

//    public boolean intersectCircle(Circle){}

    /**
     * @param zOrder The order the shapes have been added
     */
    public void setzOrder(int zOrder) {
        this.zOrder = zOrder;
    }
}
