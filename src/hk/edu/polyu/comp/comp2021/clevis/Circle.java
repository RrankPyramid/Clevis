package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;
import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.*;


import java.awt.Graphics;

public class Circle extends Shape {
    private Vertex center;
    private double radius;

    public Circle(Vertex center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval((int)(center.x-radius), (int)(center.y-radius), (int)radius*2, (int)radius*2);
    }

    @Override
    public boolean containPoint(Vertex p){
        return GraphConstant.EPS <= Math.abs(center.distanceTo(p)-radius);
    }

    @Override
    public void move(double dx, double dy) {
        center=center.add(new Vector(dx,dy));
    }

    @Override
    public Vertex getTopLeft(){
        return new Vertex(center.x-radius, center.y-radius);
    }


    @Override
    public Vertex getBottomRight(){
        return new Vertex(center.x+radius, center.y+radius);
    }
}
