package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

import java.awt.Graphics;
import java.util.ArrayList;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.EPS;


public class Line extends Shape {

    Vertex x,y;

    Line(Vertex x, Vertex y, int z) {
        this.x = x;
        this.y = y;
        this.zOrder = z;
    }
    Line(Vertex x, Vertex y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw(Graphics g) {
        g.drawLine((int)x.x, (int)x.y, (int)y.x, (int)y.y);
    }

    @Override
    public boolean containPoint(Vertex p){
        if(Math.abs(x.vectorTo(p).crossProduct(x.vectorTo(y)))/(x.distanceTo(y)) > EPS)
            return false;
        double min_x = Math.min(x.x, y.x), max_x = Math.max(x.x, y.x);
        double min_y = Math.min(x.y, y.y), max_y= Math.max(x.y, y.y);

        if(p.x-min_x < -EPS || p.x-max_x > EPS || p.y-min_y < -EPS || p.y-max_y > EPS)
            return false;
        return true;
    }

    @Override
    public void move(double dx, double dy) {
        Vector vector = new Vector(dx,dy);
        x=x.add(vector);
        y=y.add(vector);
    }

    @Override
    public Vertex getTopLeft(){
        return new Vertex(Math.min(x.x, y.x), Math.min(x.y, y.y));
    }

    @Override
    public Vertex getBottomRight(){
        return new Vertex(Math.max(x.x, y.x), Math.max(x.y, y.y));
    }

    @Override
    public String[] getInfo(String name){
        ArrayList<String> result = new ArrayList<>();
        result.add(name+"is a line");
        result.add("First endpoint : "+String.format("%.2f", x.x)+" "+String.format("%.2f", x.y));
        result.add("Second endpoint : "+String.format("%.2f", y.x)+" "+String.format("%.2f", y.y));
        return (String[])result.toArray();
    }

    public double distanceTo(Vertex point){
        double a = point.vectorTo(x).norm();
        double b = point.vectorTo(y).norm();
        double c = y.vectorTo(x).norm();
        double p = (a+b+c)/2;
        double s =Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return s/c;
    }

    public boolean intersect(Shape other){
        if(other instanceof Line){
            Line otherLine = (Line)other;
            double a = this.x.vectorTo(this.y).crossProduct(this.x.vectorTo(otherLine.x))*(this.x.vectorTo(y).crossProduct(this.x.vectorTo(otherLine.y)));
            double b = otherLine.x.vectorTo(otherLine.y).crossProduct(otherLine.x.vectorTo(this.x))*otherLine.x.vectorTo(otherLine.y).crossProduct(otherLine.x.vectorTo(this.y));
            return a>=0 && b>=0;
        }
        else if(other instanceof Rectangle){
            Rectangle otherRec = (Rectangle)other;
            Vector vectorDown = new Vector(0, otherRec.direct.y);
            Vector vectorRight = new Vector(otherRec.direct.x, 0);
            Line left = new Line(otherRec.p, otherRec.p.add(vectorDown));
            Line up = new Line(otherRec.p, otherRec.p.add(vectorRight));
            Line right = new Line(otherRec.p.add(vectorRight),otherRec.p.add(otherRec.direct));
            Line bottom = new Line(otherRec.p.add(vectorDown),otherRec.p.add(otherRec.direct));
            return(this.intersect(left)||this.intersect(up)||this.intersect(right)||this.intersect(bottom));
        }
        else return other.intersect(this);
    }
}
