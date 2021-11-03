package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.ArrayList;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.INF;

public class Group extends Shape{
    private ArrayList<Shape> list;
    public Group(){
        list = new ArrayList<>();
    }
    public void add_Shape(Shape s){
        list.add(s);
    }
    @Override
    public void draw(Graphics g){
        for (Shape s : this.list){
            s.draw(g);
        }
    }

    @Override
    public boolean containPoint(Vertex p){
        for(Shape s : list){
            if(s.containPoint(p))return true;
        }
        return false;
    }

    @Override
    public Vertex getTopLeft(){
        double min_x = INF;
        double min_y = INF;
        for (Shape s : list){
            min_x = Math.min(min_x, s.getTopLeft().x);
            min_y = Math.min(min_y, s.getTopLeft().y);
        }
        return new Vertex(min_x, min_y);
    }

    @Override
    public Vertex getBottomRight() {
        double max_x = -INF;
        double max_y = -INF;
        for (Shape s : list){
            max_x = Math.max(max_x, s.getBottomRight().x);
            max_y = Math.max(max_y, s.getBottomRight().y);
        }
        return new Vertex(max_x, max_y);
    }
}
