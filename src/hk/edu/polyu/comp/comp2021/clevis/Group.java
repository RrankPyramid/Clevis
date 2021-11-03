package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.*;

import java.awt.*;
import java.util.ArrayList;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.NotInGroup;

public class Group extends Shape{
    private ArrayList<Shape> list;
    public Group(){
        list = new ArrayList<>();
        inGroups = NotInGroup;
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
        double min_x = list.get(0).getTopLeft().x;
        double min_y = list.get(0).getTopLeft().y;
        for (Shape s : list){

        }
    }
}
