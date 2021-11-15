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

        if(x.x-min_x < -EPS || x.x-max_x > EPS || x.y-min_y < -EPS || x.y-max_y > EPS)
            return false;
        return !(y.x - min_x < -EPS) && !(y.x - max_x > EPS) && !(y.y - min_y < -EPS) && !(y.y - max_y > EPS);
    }

    @Override
    public void move(double dx, double dy) {
        Vector vector = new Vector(dx,dy);
        x.add(vector);
        y.add(vector);
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

    public boolean intersect(Line other){
        double a = this.x.vectorTo(this.y).crossProduct(this.x.vectorTo(other.x))*(this.x.vectorTo(y).crossProduct(this.x.vectorTo(other.y)));
        double b = other.x.vectorTo(other.y).crossProduct(other.x.vectorTo(this.x))*other.x.vectorTo(other.y).crossProduct(other.x.vectorTo(this.y));
        return a>=0 && b>=0;
    }

    public boolean intersect(Rectangle other){
        Vector vectorDown = new Vector(0, other.direct.y);
        Vector vectorRight = new Vector(other.direct.x, 0);
        Line left = new Line(other.p, other.p.add(vectorDown));
        Line up = new Line(other.p, other.p.add(vectorRight));
        Line right = new Line(other.p.add(vectorRight),other.p.add(other.direct));
        Line bottom = new Line(other.p.add(vectorDown),other.p.add(other.direct));
        return(this.intersect(left)||this.intersect(up)||this.intersect(right)||this.intersect(bottom));
    }
    public boolean intersect(Circle other){
        return other.intersect(this);
    }
}
