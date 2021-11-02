package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Point;

import java.awt.Graphics;

public class Circle extends Shape {
    static double EPS;
    private double x;
    private double y;
    private double radius;

    public Circle(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
        left_boundary=x-radius;
        upper_boundary=y-radius;
        right_boundary=x+radius;
        lower_boundary=y+radius;
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval((int)(x-radius), (int)(y-radius), (int)radius*2, (int)radius*2);
    }

    public boolean containPoint(Point p){
        Point center = new Point(x,y);
        return EPS <= Math.abs(center.distanceTo(p)-radius);
    }
}
