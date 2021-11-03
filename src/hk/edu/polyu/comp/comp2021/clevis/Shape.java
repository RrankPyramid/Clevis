package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.NotInGroup;

public abstract class Shape {

    public int z_Order;
    protected int GroupCounter=NotInGroup;

    public abstract void draw(Graphics g);

    public abstract boolean containPoint(Vertex p);
    public abstract void move(double dx,double dy);
    public abstract Vertex getTopLeft();
    public abstract Vertex getBottomRight();

}
