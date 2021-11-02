package hk.edu.polyu.comp.comp2021.clevis;


import hk.edu.polyu.comp.comp2021.clevis.util.Point;

import java.awt.*;

public class Rectangle extends Shape {
    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(double x, double y, double l) {
        this.x = x;
        this.y = y;
        this.width = l;
        this.height = l;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect((int)x, (int)y, (int)width, (int)height);
    }

    public boolean containPoint(Point p){
        Line left = new Line(new Point(x,y),new Point(x,y+height));
        Line up = new Line(new Point(x,y),new Point(x+width,y));
        Line right = new Line(new Point(x+width,y),new Point(x+width,y+height));
        Line bottom = new Line(new Point(x,y+height),new Point(x+width,y+height));
        return (left.containPoint(p)||up.containPoint(p)||right.containPoint(p)||bottom.containPoint(p));
    }


}