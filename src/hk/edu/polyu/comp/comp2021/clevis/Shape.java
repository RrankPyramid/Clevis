package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Point;

import java.awt.*;

public abstract class Shape {

    public abstract void draw(Graphics g);

    public abstract boolean containPoint(Point p);

    public abstract Point getTopLeft();
    public abstract Point getBottomRight();

}
