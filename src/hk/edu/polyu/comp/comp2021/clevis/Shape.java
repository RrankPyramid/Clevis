package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Point;

import java.awt.*;

public abstract class Shape {

    protected double upper_boundary,lower_boundary,left_boundary,right_boundary;

    public abstract void draw(Graphics g);

    public abstract boolean containPoint(Point p);

}
