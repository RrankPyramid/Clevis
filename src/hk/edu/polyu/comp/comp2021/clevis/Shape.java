package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.*;

public abstract class Shape {

    protected int groupCount;
    public abstract boolean containsPoint(double x, double y);


    protected double upper_boundary,lower_boundary,left_boundary,right_boundary;

    public abstract void draw(Graphics g);

}
