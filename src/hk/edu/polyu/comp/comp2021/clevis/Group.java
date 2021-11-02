package hk.edu.polyu.comp.comp2021.clevis;

import java.awt.*;
import java.util.ArrayList;

public class Group extends Shape{
    private ArrayList<Shape> list;
    public Group(){
        super();
        list = new ArrayList<>();
    }
    public void add_Shape(Shape s){
        list.add(s);
        s.groupCount++;
    }

    @Override
    public void draw(Graphics g){
        for (Shape s : this.list){
            s.draw(g);
        }
    }

    protected void ungroup(){
        for (Shape s: list
             ) {
                s.groupCount --;
                if(s.groupCount < 0){
                    throw new RuntimeException();
                }
        }
    }

    @Override
    public boolean containsPoint(double x, double y){
        return false;
    }


}
