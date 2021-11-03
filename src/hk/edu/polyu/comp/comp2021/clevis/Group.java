package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.HashMap;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.INF;

public class Group extends Shape{
    protected HashMap<String,Shape> list;
    public Group(){
        list = new HashMap<>();
    }
    public void add_Shape(String name,Shape s){
        list.put(name,s);
        s.groupCounter += 1;
    }
    @Override
    public void draw(Graphics g){
        for (Shape s : this.list.values()){
            s.draw(g);
        }
    }

    @Override
    public boolean containPoint(Vertex p){
        for(Shape s : list.values()){
            if(s.containPoint(p))return true;
        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for(Shape s : list.values()){
            s.move(dx,dy);
        }
    }

    @Override
    public Vertex getTopLeft(){
        double min_x = INF;
        double min_y = INF;
        for (Shape s : list.values()){
            min_x = Math.min(min_x, s.getTopLeft().x);
            min_y = Math.min(min_y, s.getTopLeft().y);
        }
        return new Vertex(min_x, min_y);
    }

    @Override
    public Vertex getBottomRight() {
        double max_x = -INF;
        double max_y = -INF;
        for (Shape s : list.values()){
            max_x = Math.max(max_x, s.getBottomRight().x);
            max_y = Math.max(max_y, s.getBottomRight().y);
        }
        return new Vertex(max_x, max_y);
    }
}
