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
        double min_x = Math.min(x.x, y.x), max_x = Math.max(x.x, y.x);
        double min_y = Math.min(x.y, y.y), max_y= Math.max(x.y, y.y);

        if(x.x-min_x < -EPS || x.x-max_x > EPS || x.y-min_y < -EPS || x.y-max_y > EPS)
            return false;
        if(y.x-min_x < -EPS || y.x-max_x > EPS || y.y-min_y < -EPS || y.y-max_y > EPS)
            return false;
        return true;
    }

    public Point getTopLeft(){
        return new Point(Math.min(x.x, y.x), Math.min(x.y, y.y));
    }
    public Point getBottomRight(){
        return new Point(Math.max(x.x, y.x), Math.max(x.y, y.y));
    }


}
