package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

import java.awt.*;

public abstract class Shape {

    public abstract void draw(Graphics g);

    public abstract boolean containPoint(Vertex p);

    public abstract Vertex getTopLeft();
    public abstract Vertex getBottomRight();

}
