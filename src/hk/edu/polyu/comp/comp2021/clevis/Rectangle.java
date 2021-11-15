package hk.edu.polyu.comp.comp2021.clevis;


import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends Shape {
    Vertex p;
    Vector direct;

    public Rectangle(Vertex p, Vector direct,int z) {
        this.p = p;
        this.direct = direct;
        this.setzOrder(z);
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int) p.getX(), (int) p.getY(), (int) direct.getX(), (int) direct.getY());
    }

    @Override
    public boolean containPoint(Vertex p){
        Vector vectorDown = new Vector(0, direct.getY());
        Vector vectorRight = new Vector(direct.getX(), 0);
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

    @Override
    public ArrayList<String> getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a rectangle,");
        result.add("Top-Left Corner : "+String.format("%.2f", p.getX())+" "+String.format("%.2f", p.getY()));
        result.add("Width : "+String.format("%.2f", direct.getX()));
        result.add("Height : "+String.format("%.2f", direct.getY()));
        return result;
    }

    @Override
    public boolean intersect(Rectangle other){
            Vertex otherTopLeft = other.getTopLeft();
            Vertex topLeft = this.getTopLeft();
            Vertex otherBottomRight = other.getBottomRight();
            Vertex bottomRight = this.getBottomRight();

            if(otherBottomRight.getX() < topLeft.getX() || otherBottomRight.getY() < topLeft.getY())return false;
            if(otherTopLeft.getX() > bottomRight.getX() || otherTopLeft.getY() > bottomRight.getY())return false;

            return (!(otherTopLeft.getX() > topLeft.getX()) || !(otherTopLeft.getY() > topLeft.getY())) || (!(otherBottomRight.getX() < bottomRight.getX()) || !(otherBottomRight.getY() < bottomRight.getY()));
    }
    @Override
    public boolean intersect(Circle other){
            Vector vectorDown = new Vector(0, direct.getY());
            Vector vectorRight = new Vector(direct.getX(), 0);
            Line left = new Line(p, p.add(vectorDown));
            Line up = new Line(p, p.add(vectorRight));
            Line right = new Line(p.add(vectorRight),p.add(direct));
            Line bottom = new Line(p.add(vectorDown),p.add(direct));
            return left.intersect(other)||up.intersect(other)||right.intersect(other)||bottom.intersect(other);
    }

    @Override
    public boolean intersect(Line other){
        return other.intersect(this);
    }
    @Override
    public boolean intersect(Group other){
        return other.intersect(this);
    }

}