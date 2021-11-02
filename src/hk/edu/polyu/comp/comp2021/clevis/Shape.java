package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.*;

public abstract class Shape {
    protected int groupCount;
    public abstract void draw(Graphics g);
    public abstract boolean containsPoint(double x, double y);


}
