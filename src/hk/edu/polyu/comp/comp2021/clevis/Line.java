package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Point;

import java.awt.Graphics;



public class Line extends Shape {

    static final double EPS = 0.05;

    Point x,y;

    Line(Point x, Point y) {
        x = this.x;
        y = this.y;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine((int)x.x, (int)x.y, (int)y.x, (int)y.y);
    }

    public boolean containPoint(Point p){

    }

}
