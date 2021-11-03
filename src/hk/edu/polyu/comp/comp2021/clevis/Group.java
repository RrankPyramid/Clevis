package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.NotInGroup;

public class Group extends Shape{
    protected HashMap<String,Shape> list;
    public Group(int z_Order){
        list = new HashMap<>();
    }
    public void add_Shape(String name,Shape s){
        list.put(name,s);
        s.GroupCounter += 1;
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
        double min_x = list.get(0).getTopLeft().x;
        double min_y = list.get(0).getTopLeft().y;
        return new Vertex(1,1);
    }
    @Override
    public Vertex getBottomRight(){
        return new Vertex(1,1);
    }
}
