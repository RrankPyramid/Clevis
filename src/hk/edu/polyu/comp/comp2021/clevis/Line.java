package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

import java.awt.Graphics;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.EPS;
import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.NotInGroup;


public class Line extends Shape {

    Vertex x,y;

    Line(Vertex x, Vertex y) {
        this.x = x;
        this.y = y;
        inGroups = NotInGroup;
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
        if(y.x-min_x < -EPS || y.x-max_x > EPS || y.y-min_y < -EPS || y.y-max_y > EPS)
            return false;
        return true;
    }

    @Override
    public Vertex getTopLeft(){
        return new Vertex(Math.min(x.x, y.x), Math.min(x.y, y.y));
    }

    @Override
    public Vertex getBottomRight(){
        return new Vertex(Math.max(x.x, y.x), Math.max(x.y, y.y));
    }


}
