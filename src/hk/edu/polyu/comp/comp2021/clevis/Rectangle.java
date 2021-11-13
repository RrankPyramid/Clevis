package hk.edu.polyu.comp.comp2021.clevis;


import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.*;

public class Rectangle extends Shape {
    Vertex p;
    Vector direct;

    public Rectangle(Vertex p, Vector direct,int z) {
        this.p = p;
        this.direct = direct;
        this.zOrder = z;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)p.x, (int)p.y, (int)direct.x, (int)direct.y);
    }

    @Override
    public boolean containPoint(Vertex p){
        Vector vectorDown = new Vector(0, direct.y);
        Vector vectorRight = new Vector(direct.x, 0);
        Line left = new Line(p, p.add(vectorDown));
        Line up = new Line(p, p.add(vectorRight));
        Line right = new Line(p.add(vectorRight),p.add(direct));
        Line bottom = new Line(p.add(vectorDown),p.add(direct));
        return (left.containPoint(p)||up.containPoint(p)||right.containPoint(p)||bottom.containPoint(p));
    }

    @Override
    public void move(double dx, double dy) {
        p=p.add(new Vector(dx,dy));
    }


    @Override
    public Vertex getTopLeft(){
        return p;
    }


    @Override
    public Vertex getBottomRight(){
        return p.add(direct);
    }
}