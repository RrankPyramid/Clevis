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
        if(x.vectorTo(p).crossProduct(x.vectorTo(y)) > EPS)
            return false;
        double minx = Math.min(x.x, y.x), maxx = Math.max(x.x, y.x);
        double miny = Math.min(x.y, y.y), maxy = Math.max(x.y, y.y);

        if(x.x-minx < -EPS || x.x-maxx > EPS || x.y-miny < -EPS || x.y-maxy > EPS)
            return false;
        if(y.x-minx < -EPS || y.x-maxx > EPS || y.y-miny < -EPS || y.y-maxy > EPS)
            return false;
        return true;
    }


}
