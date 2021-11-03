package hk.edu.polyu.comp.comp2021.clevis;


import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;

public class Rectangle extends Shape {
    Vertex p;
    Vector direct;

    public Rectangle(Vertex p, Vector direct) {
        this.p = p;
        this.direct = direct;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)p.x, (int)p.y, (int)direct.x, (int)direct.y);
    }

    @Override
    public boolean containPoint(Vertex p){
        Vector vectorDown = new Vector(0, direct.y);
        Vector vectorUp = new Vector(direct.x, 0);
        Line left = new Line(p, p.add(vectorDown));
        Line up = new Line(new Vertex(x,y),new Vertex(x+width,y));
        Line right = new Line(new Vertex(x+width,y),new Vertex(x+width,y+height));
        Line bottom = new Line(new Vertex(x,y+height),new Vertex(x+width,y+height));
        return (left.containPoint(p)||up.containPoint(p)||right.containPoint(p)||bottom.containPoint(p));
    }
    @Override
    public Vertex getTopLeft(){
        return new Vertex(x,y);
    }


    @Override
    public Vertex getBottomRight(){
        return new Vertex(x+width,y+height);
    }

}