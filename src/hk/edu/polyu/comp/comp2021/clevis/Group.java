package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.*;
import java.util.ArrayList;

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
    public boolean contains_point(double x,double y){
        return false;
    }


}
